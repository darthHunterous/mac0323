#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "buffer.h"

//Cria e retorna um buffer vazio.
Buffer *buffer_create() {
    Buffer *buffer = malloc(sizeof(Buffer));
    buffer->data = malloc(128*sizeof(char));
    buffer->n = 128;
    buffer->i = 0;

    return buffer;
}

//Destroi um buffer
void buffer_destroy(Buffer *B) {
    free(B->data);
    free(B);
}

//Reinicializa o buffer, apagando o vetor data.
void buffer_reset(Buffer *B) {
    free(B->data);
    B->data = malloc(B->n * sizeof(char));
    B->i = 0;
}

//Adiciona o caracter c no buffer.
void buffer_push_back(Buffer *B, char c) {
    if (B->i == B->n)
        B->data = realloc(B->data, B->n * 2);
    B->data[B->i] = c;
    B->i += 1;
}
/*
  Lê uma linha no arquivo input e adiciona
  ao buffer, retirando espaços extras antes
  da primeira palavra e após a última.
*/
int read_line(FILE *input, Buffer *B) {
    char c;
    long int pos;
    int to_break = 0, number_spaces = 0, i;

    buffer_reset(B);

    //Verifica se essa linha é apenas o EOF.
    pos = ftell(input);
    if (fscanf(input, "%c", &c) ==  EOF)
        return 0;
    fseek(input, pos, SEEK_SET);

    //Tira os espaços extras antes da primeira palavra.
    while (fscanf(input, "%c", &c) && isspace(c))
        if (c == '\n') {
            buffer_push_back(B, c);
            return B->i;
        }
    buffer_push_back(B, c);

    //Loop principal
    while (fscanf(input, "%c", &c) != EOF){
        if (c == '\n') {    //Se for um fim de linha, sai do loop.
            buffer_push_back(B, c);
            break;
        }
        if (isspace(c)) {  //Verifica o que existe após um ou mais expaços.
            pos = ftell(input);
            number_spaces = 1;
            while(fscanf(input, "%c", &c) && isspace(c)) {
                number_spaces++ ;
                if (c == '\n') {  // Se for um fim de linha, sai da função.
                    buffer_push_back(B, c);
                    to_break = 1;
                    return B->i;
                }
            }
        }
        //Se for outra palavra, volta e adiciona ao buffer o número de
        // espaços entre as palavras.
        if (number_spaces != 0) {
            fseek(input, pos-1, SEEK_SET);
            for (i = 0; i < number_spaces; i++) {
                fscanf(input, "%c", &c);
                buffer_push_back(B, c);
            }
            number_spaces = 0;
            continue;
        }
        buffer_push_back(B, c); //Adiciona os não-espaços ao buffer.
    }
    return B->i;
}
