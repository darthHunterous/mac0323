#include <stdio.h>
#include "buffer.h"
#include "stable.h"

int main (int argc, char *argv[]) {
    FILE *in = fopen(argv[1], "r");
    Buffer *line = buffer_create();
    SymbolTable alias = stable_create();
    int buffer_size = read_line(in, line);

    int blah = parse(line->data, alias, instruction, error);
    
    fclose(in);
    return 0;
}