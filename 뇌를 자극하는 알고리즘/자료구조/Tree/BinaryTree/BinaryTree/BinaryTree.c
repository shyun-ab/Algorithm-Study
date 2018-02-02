#include "BinaryTree.h"

Node* CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->Left = NULL;
	NewNode->Right = NULL;
	NewNode->Data = NewData;

	return NewNode;
}

void DestroyNode(Node* Node) {
	free(Node);
}

void DestroyTree(Node* Node) {
	if (Node == NULL)
		return;

	DestroyTree(Node->Left);	//왼쪽 하위 트리
	DestroyTree(Node->Right);	//오른쪽 하위 트리
	DestroyNode(Node);			//루트 노드
}

void PreorderPrintTree(Node* Node) {
	if (Node == NULL)
		return;

	printf(" %c", Node->Data);
	PreorderPrintTree(Node->Left);
	PreorderPrintTree(Node->Right);
}

void InorderPrintTree(Node* Node) {
	if (Node == NULL)
		return;

	InorderPrintTree(Node->Left);
	printf(" %c", Node->Data);
	InorderPrintTree(Node->Right);
}

void PostorderPrintTree(Node* Node) {
	if (Node == NULL)
		return;

	PostorderPrintTree(Node->Left);
	PostorderPrintTree(Node->Right);
	printf(" %c", Node->Data);
}