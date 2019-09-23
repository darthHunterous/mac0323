#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "stable.h"
#include "node.h"
#include "hash.h"

SymbolTable stable_create() {
    int i;
    SymbolTable st = malloc(sizeof *st);
    st->M = 2;
    st->N = 0;
    st->varal = malloc(st->M * sizeof *st->varal);

    //Node *array = malloc(2*sizeof(Node)); 

    for (i = 0; i < st->M; i++) {
        st->varal[i] = malloc(st->M * sizeof (Node));;
        //st->varal[i]->next = NULL;
    }
    return st;
}


void stable_destroy(SymbolTable table) {
    int i;
    Node current, next;
    for (i = 0; i < table->M; i++) {
        current = table->varal[i];
        while(current != NULL) {
            next = current->next;
            //free((char *)current->key);
            free(current);
            current = next;
        }
    }
    free(table->varal);
    free(table);
}

InsertionResult stable_insert(SymbolTable table, const char *key) {
    int hash = hash_convert(key, table->M);
    char *dummy = "dummyHead";
    table->varal[hash]->key = dummy;

    Node current = table->varal[hash];
    InsertionResult result;
    while (current->next != NULL) {
        if (strcmp(current->key, key) == 0) {
            result.new = 0;
            result.data = &current->value;
            return result;
        }
        current = current->next;
    }
    if (strcmp(current->key, key) == 0) {
        result.new = 0;
        result.data = &current->value;
        return result;
    }
    else {
        result.new = 1;
        Node aux = malloc(sizeof(Node));
        if (aux == NULL) {
            fprintf(stderr, "Not enough memory for the insertion");
            exit(EXIT_FAILURE);
        }
        current->next = aux;
        aux->key = key;
        aux->next = NULL;
        result.data = &aux->value;
        table->N += 1;
    }
    return result;
}

EntryData *stable_find(SymbolTable table, const char *key) {
    int hash = hash_convert(key, table->M);
    char *dummy = "dummyHead";
    table->varal[hash]->key = dummy;

    Node current = table->varal[hash];
    while (current != NULL) {
        if (strcmp(current->key, key) == 0)
            return &current->value;
        current = current->next;
    }
    //if (current->next == NULL)
    return NULL;
}

int stable_visit(SymbolTable table, int (*visit)(const char *key, EntryData *data)) {
    int i, return_value;
    for (i = 0; i < table->M; i++) {
        Node current = table->varal[i]->next;
        while (current != NULL) {
            return_value = visit(current->key, &current->value);
            if (!return_value)
                return 0;
            current = current->next;
        }
    }
    return 1;
}
