#ifndef __FILEREAD_H__
#define __FILEREAD_H__

/* Ignore blank spaces at the beginning of the file read, returning first char
in the file */
char set_beginning(FILE* input);

/* Returns the pointer to the next string in the file read */
char* next_word(FILE* input);

/* Appends the given char to the string, returning the corresponding char*   */
char* string_append(char* string, char c);

/* Checks if the filestream has reached the end of file */
int has_next_word(FILE* input);

/* Prints the n given spaces */
void print_n_spaces(int n);

#endif
