
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>

#include "ulstack.h"


int main(int argc, char* argv[])
{
	
	int choice;
	ulstack *stack = NULL;
	
	start:
	printf("Enter your choice:\n"
"1) Create Stack\n"	
"2) Push Value\n"
"3) Pop Value\n"
"4) Print Number of Elements on Stack\n"
"5) Remove Stack\n"
"6) Exit\n"
">> ");
	while(1)
	{	
		do { 
			scanf("%d", &choice);
		} while(getchar() != '\n' && getchar() != EOF);
		
		if(choice < 1 || choice > 6 )
		{
			printf("inviled number\n");
			goto start;
		} 
		else {
				break;
			 }
			
	}

	while(1)
	{
		if(choice == 1)
		{
			assert(stack == NULL);
			stack = (ulstack *) malloc(sizeof(ulstack));
			ULStackNew(stack);		
			goto start;
		
		}
		else if(choice == 6)
			{
				exit(1);
				break;
			} 
		 
		 if(stack != NULL)
		 {
			if(choice == 2)
			{
				unsigned long value;
				do {
					printf("Enter Value: ");
					scanf("%lu", &value);
				} while(getchar() != '\n');
				
			//	stack=realloc(stack,MAX * sizeof(unsigned long));
				ULStackPush(stack, value);
				goto start;
			}
			 else if(choice == 3)
				{
					printf("Pop from stack: %lu \n",ULStackPop(stack));
					goto start;
				}
			else if(choice == 4)
				{
					printf("Elements on stack: %d \n", GetULStackNumberOfElements(stack) );
					goto start;
				}
			else if(choice == 5)
				{
					ULStackDispose(stack);
					printf("stack is removed \n ");
					free(stack);
					stack = NULL;
					exit(0);
					goto start;
				}
		 } else 
			{
				printf("stack musst be created, type 1 to creat it!\n");
				goto start;
			}
	}
	
	free(stack);
	//stack= NULL;
	return EXIT_SUCCESS;
}
