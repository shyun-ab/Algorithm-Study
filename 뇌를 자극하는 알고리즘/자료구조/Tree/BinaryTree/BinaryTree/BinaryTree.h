#ifndef BINARY_TREE_H
#define BINARY_TREE_H

#include <stdio.h>
#include <stdlib.h>

typedef char ElementType;

typedef struct TagNode {
	struct TagNode* Left;
	struct TagNode* Right;

	ElementType Data;
} Node;

Node* CreateNode(ElementType NewData);
void DestroyNode(Node* Node);
void DestroyTree(Node* Root);

void PreorderPrintTree(Node* Node);
void 

#endif // !BINARY_TREE_H
