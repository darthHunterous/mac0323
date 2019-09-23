#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include "fileread.h"

/* Sets the current input to the beginning of the next string */
char set_beginning(FILE* input) {
    char c;
    if (fscanf(input, "%c", &c) == EOF)
        return -1;
    while(isblank(c))
        if (fscanf(input, "%c", &c) == EOF)
            return -1;
    return c;
}

/* Checks if the input has another word or has reached the end of the file */
int has_next_word(FILE* input){
    char c;
    int pos = ftell(input);
    if (fscanf(input, "%c", &c) == EOF){
        fseek(input, pos, SEEK_SET);
        return 0;
    }
    else{
        fseek(input, pos, SEEK_SET);
        return -1;
    }
}

/* Gets the next word in the input stream */
char* next_word(FILE* input) {
    char* string = malloc(sizeof(char));
    string[0] = '\0';
    char c = set_beginning(input);
    int loop = 1;
    if (c == -1)
        return NULL;

    string[0] = c;

    while (loop)
        if (fscanf(input, "%c", &c) == EOF)
            loop = 0;
        else
            if (!isblank(c) && c != '\n')
                string = string_append(string, c);
            else
                loop = 0;

    return string;
}

/* Appends the char c to the end of the string */
char* string_append(char* string, char c) {
    char* string_aux = malloc(strlen(string) + 2);
    strcpy(string_aux, string);
    string_aux[strlen(string)] = c;
    string_aux[strlen(string) + 1] = '\0';

    return string_aux;
}

/* Prints n spaces */
void print_n_spaces(int n) {
    int i;
    for (i = 0; i < n; i++)
        printf(" ");
}
