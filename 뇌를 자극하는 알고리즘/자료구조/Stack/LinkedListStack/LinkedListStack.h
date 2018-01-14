#ifndef LINKEDLIST_STACK_H
#define LINKEDLIST_STACK_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct tagNode {
	char* Data;
	struct tagNode* NextNode;
} Node;

typedef struct tagLinkedListStack {
	Node* List;
	Node* Top;
} LinkedListStack;

void CreateStack(LinkedListStack** Stack);
void DestoryStack(LinkedListStack* Stack);

Node* CreateNode(char* Data);
void DestroyNode(Node* Node);

void Push(LinkedListStack* Stack, Node* NewNode);
Node* Pop(LinkedListStack* Stack);

Node* Top(LinkedListStack* Stack);
int GetSize(LinkedListStack* Stack);
int isEmpty(LinkedListStack* Stack);

#endif // !LINKEDLIST_STACK_H
