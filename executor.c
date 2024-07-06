

#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>
#include "command.h"
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <err.h>
#include <sysexits.h>
#include "executor.h"
#include <stdio.h>
#define OPEN_FLAGS (O_WRONLY | O_TRUNC | O_CREAT)
#define DEF_MODE 0664
int execute_aux_func(struct tree *t, int p_input_fd, int p_output_fd);




int execute(struct tree *t) {
    int result;

    if(t) {
        result = execute_aux_func(t, STDIN_FILENO, STDOUT_FILENO);
        return result;
    }

    return 0;

}


int execute_aux_func(struct tree *t, int p_input_fd, int p_output_fd) {

    if (t->conjunction == NONE) {
        pid_t pid;
        int status;

        if ((strcmp(t->argv[0], "exit")) == 0) {
            exit(EXIT_SUCCESS);
        } else if ((strcmp(t->argv[0], "cd")) == 0) {
            if (t->argv[1] != NULL) {
                status = chdir(t->argv[1]);
                if(status) {
                    perror("Error changing the directory");
                }
            } else {
                char *directory = getenv("HOME");
                status = chdir(directory);
                if(status) {
                    perror("Error changing the directory");
                }
            }
        } else {

            if((pid = fork()) < 0) {
                perror("fork error");
                exit(EX_OSERR);
            }

            if (pid > 0 ) {
                wait(&status);
                return status;
            } else {

                if(t->input) {
                    p_input_fd = open(t->input, O_RDONLY);
                    if(p_input_fd < 0) {
                        perror("Error opening input file");
                        exit(EX_OSERR);
                    }

                    if((dup2(p_input_fd, STDIN_FILENO)) == -1) {
                        perror("Error duplicating input file");
                        exit(EX_OSERR);
                    }

                    if((close(p_input_fd)) == -1) {
                        perror("Error closing input file");
                        exit(EX_OSERR);
                    }


                }

                if(t->output) {
                    p_output_fd = open(t->output, OPEN_FLAGS, DEF_MODE);
                    if(p_output_fd < 0) {
                        perror("Error opening output file");
                        exit(EX_OSERR);
                    }

                    if((dup2(p_output_fd, STDOUT_FILENO)) == -1) {
                        perror("Error duplicating output file");
                        exit(EX_OSERR);
                    }


                    if((close(p_output_fd)) == -1) {
                        perror("Error closing output file");
                        exit(EX_OSERR);
                    }               
                }

                execvp(t->argv[0], t->argv);
                fprintf(stderr, "Failed to execute %s\n", t->argv[0]);
                fflush(stdout);
                exit(EX_OSERR);

            }            
        }
    } else if (t->conjunction == AND) {
        int status = execute_aux_func(t->left, p_input_fd, p_output_fd);
        if(status) {
            return status;
        } else {
            return execute_aux_func(t->right, p_input_fd, p_output_fd);
        }
    } else if (t->conjunction == PIPE) {

        int pipe_fd[2];
        pid_t pid_1, pid_2;
       

        if (t->left->output != NULL) {
            printf("Ambiguous output redirect.\n");
        } else if(t->right->input != NULL) {
            printf("Ambiguous input redirect.\n");
        } else {
            if((pipe(pipe_fd)) == -1) {
                perror("pipe error");
                exit(EX_OSERR);
            }

            if((pid_1 = fork()) < 0) {
                perror("fork error");
                exit(EX_OSERR);
            }

            if (pid_1 == 0) {

                if(t->input) {
                    p_input_fd = open(t->left->input, O_RDONLY);
                    if(p_input_fd < 0) {
                        perror("Error opening input file");
                        exit(EX_OSERR);
                    }
                }

                if((close(pipe_fd[0])) == -1) {
                    perror("Error closing output file");
                    exit(EX_OSERR);
                }

                if((dup2(pipe_fd[1], STDOUT_FILENO)) == -1) {
                    perror("Error duplicating output file");
                    exit(EX_OSERR);
                }

                if((close(pipe_fd[1])) == -1) {
                    perror("Error closing output file");
                    exit(EX_OSERR);
                }

                execute_aux_func(t->left,p_input_fd, p_output_fd);
                exit(EXIT_SUCCESS);              
            }

            if((pid_2 = fork()) < 0) {
                perror("fork error");
                exit(EX_OSERR);
            }

            if (pid_2 == 0) {

                if(t->output) {
                    p_output_fd = open(t->right->output, OPEN_FLAGS, DEF_MODE);
                    if(p_output_fd < 0) {
                        perror("Error opening output file");
                        exit(EX_OSERR);
                    }
                }

                if((close(pipe_fd[1])) == -1) {
                    perror("Error closing output file");
                    exit(EX_OSERR);
                }

                if((dup2(pipe_fd[0], STDIN_FILENO)) == -1) {
                    perror("Error duplicating output file");
                    exit(EX_OSERR);
                }

                if((close(pipe_fd[0])) == -1) {
                    perror("Error closing output file");
                    exit(EX_OSERR);
                }

                execute_aux_func(t->right, p_input_fd, p_output_fd);
                exit(EXIT_SUCCESS);
            }

            if((close(pipe_fd[0])) == -1) {
                perror("Error closing output file");
                exit(EX_OSERR);
            }

            if((close(pipe_fd[1])) == -1) {
                perror("Error closing output file");
                exit(EX_OSERR);
            }

            waitpid(pid_1, NULL, 0);
            waitpid(pid_2, NULL, 0);            
        }
    } else if( t->conjunction == SUBSHELL) {
        pid_t pid;
        
        if((pid = fork()) < 0) {
            perror("fork error");
            exit(EX_OSERR);
        }

        if (pid == 0) {
            if(t->input) {
                p_input_fd = open(t->input, O_RDONLY);
                if(p_input_fd < 0) {
                    perror("Error opening input file");
                    exit(EX_OSERR);
                }

                if((dup2(p_input_fd, STDIN_FILENO)) == -1) {
                    perror("Error duplicating input file");
                    exit(EX_OSERR);
                }

                if((close(p_input_fd)) == -1) {
                    perror("Error closing input file");
                    exit(EX_OSERR);
                }


            }

            if(t->output) {
                p_output_fd = open(t->output, OPEN_FLAGS, DEF_MODE);
                if(p_output_fd < 0) {
                    perror("Error opening output file");
                    exit(EX_OSERR);
                }

                if((dup2(p_output_fd, STDOUT_FILENO)) == -1) {
                    perror("Error duplicating output file");
                    exit(EX_OSERR);
                }


                if((close(p_output_fd)) == -1) {
                    perror("Error closing output file");
                    exit(EX_OSERR);
                }               
            }

            execute_aux_func(t->left, p_input_fd, p_output_fd);
            exit(EXIT_SUCCESS);
        } else {
            wait(NULL);
        }        
    }

    return 0;
}


