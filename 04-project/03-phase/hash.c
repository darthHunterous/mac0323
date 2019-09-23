#include <stdlib.h>
#include "stable.h"
#include "hash.h"
#include "node.h"

/* Converte a string para divisâo por M na função hash() */
unsigned int hash_convert(const char *key, int M) {
   unsigned int h = 0;
   int i;
   for (i = 0; key[i] != '\0'; i++)
      h = (h * 31 + key[i]) % M;
   return h;
}

/* Resizes the SymbolTable, to keep load factor below 10 */
SymbolTable rehash(SymbolTable table) {
    int i;

    SymbolTable aux = malloc(sizeof(*aux));
    aux->M = table->M * 2;
    aux->N = 0;
    aux->varal = malloc(aux->M * sizeof *aux->varal);
    for (i = 0; i < aux->M; i++) {
        aux->varal[i] = malloc(sizeof(Node));
        aux->varal[i]->next = NULL;
    }

    for (i = 0; i < table->M; i++) {
        Node current = table->varal[i]->next;
        while (current != NULL) {
            InsertionResult result = stable_insert(aux, current->key);
            result.data->i = current->value.i;
            current = current->next;
        }
    }
    return aux;
}
