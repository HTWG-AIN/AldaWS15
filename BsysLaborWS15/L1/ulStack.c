#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <assert.h>

#include "ulstack.h"


//ulstack *top = NULL;


void ULStackNew(ulstack *s)
{
	s->allocLength = MAX;
	s->elems =  calloc(s->allocLength , sizeof(unsigned long));
	s->logLength = 0;
	assert(s != NULL);
	if (s->elems != NULL)
	{
		//	s->elems=NULL;
		printf("stack created!\n\n");	

	}else {
		perror("stack can not be created (not malloced)!\n\n");	
	}

}


void ULStackPush(ulstack *s, unsigned long value)
{

	//ulstack *temp;
	//temp =(ulstack *) malloc(sizeof(ulstack));
	assert(s->elems != NULL);
	if(s == NULL)
	{
		exit(0);
	}
	
	if(s->logLength == s->allocLength -1)
	{
		printf("stack is full, realloc will be invoked\n");
		s->allocLength = s->allocLength * 2 ;
		s->elems=realloc(s->elems, s->allocLength * sizeof(unsigned long));
		assert(s->elems != NULL);
	}
	
	s->elems[s->logLength++] = value;

	//s->elems=top;
	
}
unsigned long ULStackPop(ulstack *s)
{
	unsigned long pop;
	assert(s->elems != NULL);
	assert(s->logLength > 0);
//  ulstack p;	
//	unsigned long *help = &poppedValue;
	
	//if(assert(s->logLength > 0 ))// printf("underflow, stack is empty\n");
 	//fprintf(stderr, "%s\n", strerror(errno));
	
    // s->logLength--;
    // return *s->elems;
	//*poppedValue = top->elems;
	s->logLength--;
	pop = s->elems[s->logLength];
	
	return pop;
	
}
unsigned int GetULStackNumberOfElements(ulstack *s)
{
	unsigned int number;
	assert(s->elems != NULL);
	return number = s->logLength;
	
	
}
void ULStackDispose(ulstack *s)
{
	assert(s->elems != NULL);
	free(s->elems);
	//s->elems = NULL;
	//free(s);
}

