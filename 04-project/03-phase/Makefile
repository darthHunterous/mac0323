CC = gcc
CFLAGS = -I.
XFLAGS = -Wall -std=c99 -pedantic -O2 -Wextra
DEPS = fileread.h hash.h node.h stable.h
OBJ = freq.o fileread.o hash.o stable.o

%.o: %.c $(DEPS)
	$(CC) $(XFLAGS) -c -o $@ $< $(CFLAGS)

freq: freq.c fileread.c hash.c stable.c
	gcc -Wall -std=c99 -pedantic -O2 -Wextra -g -o freq freq.c fileread.c hash.c stable.c -I .
