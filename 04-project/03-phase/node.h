#ifndef __NODE_H__
#define __NODE_H__

/* Node for separate chaining
The separate chain is a linked list for keys with the same hash */
    typedef struct node* Node;
    struct node {
    const char *key;
    EntryData value;
    Node next;
    };

    /* Defines the symbol table structure */
    struct stable_s {
        int M;
        int N;
        Node *varal;
    };
#endif
