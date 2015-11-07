### .........  MAKEFILE .........................####
###                                              ####
### .......generic Makefile .....................####

CC=clang 
CFLAGS=-Wall -pedantic -Werror -g
LDFLAGS=-lm
RM = rm -f
SOURCES = $(OBJECTS:.o=.c)
OBJECTS = ulstack.o 
HEADERS = ulstack.h
TARGET  = ulMenuStack
CPPFLAGS = -I.

ulMenuStack: ulMenuStack.o ulstack.o
	$(CC) ulMenuStack.o ulstack.o -o ulMenuStack
ulMenuStack.o: ulMenuStack.c ulstack.h
	$(CC) -c ulMenuStack.c
ulstack.o: ulstack.c ulstack.h
		$(CC) -c ulstack.c


.PHONY: all clean

all: $(TARGET)

# CleanUp .......................................#

clean:
	$(RM) $(TARGET).o $(OBJECTS) 
