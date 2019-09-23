#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "buffer.h"

int main (int argc, char *argv[]) {
    int col;
    int i, extra_spaces, empty_lines = 0, line_num = 0;
    FILE *in, *out;
    Buffer *buffer = buffer_create();

    if (argc != 4) {
        fprintf(stderr, "Invalid program usage\n");
        fprintf(stderr, "./center <in.txt> <out.txt> <number_of_columns>\n");
        return 0;
    }
    in = fopen(argv[1], "r");
    out = fopen(argv[2], "w");
    col = atoi(argv[3]);

    int nchar = -1;
    /*
      Loop principal que lê todas as linhas do arquivo.
      É interrompido quando chega ao final do arquivo
      (read_line retorna 0).
    */
    while(nchar != 0){
        nchar = read_line(in, buffer);
        line_num++;
        if(nchar == 1)  // Se a linha tiver só um caracter, é uma linha vazia
            empty_lines++;
        else
            empty_lines = 0;
        if (empty_lines < 2) {
            if(nchar > 1){
                if (nchar > col + 1)
                    fprintf(stderr, "center: %s: line %d: line too long.\n", argv[1], line_num);
                extra_spaces = (col - (nchar-1))/2;
                for(i = 0; i < extra_spaces; i++)
                    //Imprime os espaços extras antes da primeira palavra
                    fprintf(out," ");
            }
            for(i = 0; i < nchar; i++)
                fprintf(out,"%c", buffer->data[i]);
        }
    }
    buffer_destroy(buffer);
    buffer->data = NULL;
    buffer = NULL;
    fclose(in);
    fclose(out);
}
