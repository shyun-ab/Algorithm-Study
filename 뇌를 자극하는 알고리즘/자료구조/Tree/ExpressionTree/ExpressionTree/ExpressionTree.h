#ifndef EXPRESSION_TREE_H
#define EXPRESSION_TREE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char ElementType;

typedef struct tagETNode {
	struct tagNode* Left;
	struct tagNode* Right;

	ElementType Data;
} Node;

Node* CreateNode(ElementType NewData);
void DestroyNode(Node* Node);
void DestroyTree(Node* Root);

void PreorderPrintTree(Node* Node);
void InorderPrintTree(Node* Node);
void PostorderPrintTree(Node* Node);
void BuildExpressionTree(char* PostfixExpression, Node** Node);
double Evaluate(Node* Tree);

#endif // ! EXPRESSION_TREE_H
