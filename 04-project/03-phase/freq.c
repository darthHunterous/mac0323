#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "fileread.h"
#include "stable.h"
#include "node.h"
#include "hash.h"

/* Global variables to be able to sort the array */
const char** list;
int pos = 0;

/* Adds the symbol table key to the array to be sorted */
int array_to_sort(const char* key, EntryData *data) {
    list[pos] = key;
    pos++;
    (void)data;
    return 1;
}

/* Compare two string by strcmp() */
int compare(const void *a, const void *b){
    const char **pa = (const char **)a;
    const char **pb = (const char **)b;
    return strcmp(*pa, *pb);
}

int main(int argc, char *argv[]) {
    char* word = NULL;
    unsigned int max_length = 0;
    int i;
    FILE *in = fopen(argv[1], "r");

    /* Returns an error in case the program is called without arguments */
    if (argc != 2) {
        fprintf(stderr, "Missing input argument\n");
        fprintf(stderr, "Usage: ./freq <input-text-file>\n");
        return 0;
    }
    SymbolTable frequency_table = stable_create();

    while(has_next_word(in)){
        word = next_word(in);
        if (strlen(word) > max_length)
            max_length = strlen(word);
        InsertionResult result = stable_insert(frequency_table, word);
        result.data->i++;
        if (frequency_table->N >= frequency_table->M * 10)
            frequency_table = rehash(frequency_table);
    }

    list = malloc(frequency_table->N * sizeof(char*));

    stable_visit(frequency_table, array_to_sort);
    qsort (list, (size_t) frequency_table->N, sizeof(char *), compare);

    for(i = 0; i < frequency_table->N; i++){
        EntryData *frequency = stable_find(frequency_table, list[i]);
        printf("%s", list[i]);
        print_n_spaces(max_length - strlen(list[i]) + 1);
        printf("%d\n", frequency->i);
    }

    free(list);
    list = NULL;
    stable_destroy(frequency_table);
    frequency_table = NULL;
    fclose(in);

    return 0;
}
