#include "LinkedListStack.h"

void CreateStack(LinkedListStack** Stack){
	(*Stack) = (LinkedListStack*)malloc(sizeof(LinkedListStack));
	(*Stack)->List = NULL;
	(*Stack)->Top = NULL;
}

void DestroyStack(LinkedListStack* Stack){
	while(!IsEmpty(stack)) {
		Node* Popped = Pop(Stack);
		DestroyNode(Popped);
	}

	free(Stack);
}

Node* CreateNode(char* NewData){
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->Data = (char*)malloc(strlen(NewData) + 1);

	strcpy(NewNode->Data, NewData);

	NewNode->NextNode = NULL;
	
	return NewNode;
}

void DestroyNode(Node* Node){
	free(Node->Data);
	free(Node);
}

void Push(LinkedListStack* Stack, Node* NewNode){
	if(Stack->List == NULL){
		Stack->List = NewNode;
	}
	else {
		Node* OldTop = Stack->List;
		while(OldTop->NextNode != NULL){
			OldTop = OldTop->NextNode;
		}

		OldTop->NextNode = NewNode;
	}

	Stack->Top = NewNode;
}

Node* Pop(LinkedListStack* Stack){
	Node* TopNode = Stack->Top;

	if(Stack->List == Stack->Top){
		Stack->List = NULL;
		Stack->Top = NULL;
	}
	else {
		Node* CurrentTop = Stack->List;
		while(CurrentTop != NULL && CurrentTop->NextNode != Stack->Top){
			CurrentTop = CurrentTop->NextNode;
		}

		Stack->Top = CurrentTop;
		CurrentTop->NextNode = NULL;
	}

	return TopNode;
}

Node* Top(LinkedListStack* Stack){
	return Stack->Top;
}

int GetSize(LinekdListStack* Stack){
	int Count = 0;
	Node* Current = Stack->List;

	while(Current != NULL){
		Current = Current->NextNode;
		Count++;
	}

	return Count;
}

int isEmpty(LinkedListStack* Stack){
	return (Stack->List == NULL);
}