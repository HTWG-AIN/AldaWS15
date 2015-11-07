#ifndef ULSTACK_H
#define ULSTACK_H

#define MAX 4

extern unsigned long  aktuellData;

typedef struct {
    unsigned long *elems;
    unsigned int logLength;
    unsigned int allocLength;
} ulstack;

//extern ulstack *top;

void ULStackNew(ulstack *s);
void ULStackDispose(ulstack *s);
void ULStackPush(ulstack *s, unsigned long value);
unsigned long ULStackPop(ulstack *s);
unsigned int GetULStackNumberOfElements(ulstack *s);

#endif
