#ifndef LCRS_TREE_H
#define LCRS_TREE_H

#include <stdio.h>
#include <stdlib.h>

typedef char ElementType;

typedef struct tagNode {
	struct tagNode* LeftChild;
	struct tagNode* RightSibling;

	ElementType Data;
} Node;

Node* CreateNode(ElementType NewData);
void DestroyNode(Node* Node);
void DestroyTree(Node* Root);
void AddChildNode(Node* ParentNode, Node* ChildNode);
void PrintTree(Node* Node, int Depth);

#endif // !LCRS_TREE_H
