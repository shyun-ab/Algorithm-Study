#include "LinkedListStack.h"

int main(void){

	int i		= 0;
	int Count	= 0;
	Node* Popped;

	LinkedListStack* Stack;

	CreateStack(&Stack);

	Push(Stack, CreateNode("abc"));
	Push(Stack, CreateNode("def"));
	Push(Stack, CreateNode("efg"));
	Push(Stack, CreateNode("hij"));
	
	Count = GetSize(Stack);
	printf("Size: %d, Top: %s\n\n", Count, Top(Stack)->Data);

	for(i=0; i<Count; i++){
		if(IsEmpty(Stack))
			break;

		Popped = Pop(Stack);

		printf("Popped: %s, ", Popped->Data);

		DestroyNode(Popped);

		if(!Empty(Stack)){
			printf("Current Top: %s\n", Top(Stack)->Data);
		}
		else {
			printf("Stack Is Empty.\n");
		}
	}

	DestroyStack(Stack);

	return 0;

}