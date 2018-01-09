#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct tagNode {
	ElementType Data;
	struct tagNode* NextNode;
} Node;

Node* CreateNode(ElementType NewData);
void DestroyNode(Node* Node);
void AppendNode(Node** Head, Node* NewNode);
void InsertAfter(Node* Current, Node* NewNode);
void InsertNewHead(Node** Head, Node* NewHead);
void RemoveNode(Node** Head, Node* remove);
void InsertBefore(Node** Head, Node* Current, Node* NewNode);
void DestroyAllNodes(Node** List);
Node* GetNodeAt(Node* Head, int Location);
int GetNodeCount(Node* Head);

#endif