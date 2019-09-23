#ifndef __HASH_H__
#define __HASH_H__

/*
    Converte a string para divisâo por M na função hash().
*/
unsigned int hash_convert(const char *key, int M);

/* Resizes the SymbolTable, to keep load factor below 10 */
SymbolTable rehash(SymbolTable table);

#endif
