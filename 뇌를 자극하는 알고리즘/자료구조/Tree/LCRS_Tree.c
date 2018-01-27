#include "LCRS_Tree.h"

Node* CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->LeftChild = NULL;
	NewNode->RightSibling = NULL;
	NewNode->Data = NewData;

	return NewNode;
}

void DestroyNode(Node* Node) {
	free(Node);
}

void DestroyTree(Node* Root) {
	if (Root->RightSibling != NULL)
		DestroyTree(Root->RightSibling);

	if (Root->LeftChild != NULL)
		DestroyTree(Root->LeftChild);

	Root->LeftChild = NULL;
	Root->RightSibling = NULL;

	DestroyNode(Root);
}

void AddChildNode(Node* Parent, Node* Child) {
	if (Parent->LeftChild == NULL) {
		Parent->LeftChild = Child;
	}
	else {
		Node* TempNode = Parent->LeftChild;
		while (TempNode->RightSibling != NULL)
			TempNode = TempNode->RightSibling;

		TempNode->RightSibling = Child;
	}
}

void PrintTree(Node* Node, int Depth) {
	int i = 0;
	for (i = 0; i < Depth; i++)
		printf(" ");

	printf("%c\n", Node->Data);

	if (Node->LeftChild != NULL)
		PrintTree(Node->LeftChild, Depth + 1);

	if (Node->RightSibling != NULL)
		PrintTree(Node->RightSibling, Depth);
}

void PrintNodesAtLevel(Node* Root, int Level) {
	Node* Temp = Root;
	
	if (Level == 0) {
		printf("%c\n", Temp->Data);
	}
	else {
		if (Temp->LeftChild != NULL)
			PrintNodesAtLevel(Temp->LeftChild, Level - 1);
	}

	if (Temp->RightSibling != NULL)
		PrintNodesAtLevel(Temp->RightSibling, Level);
}