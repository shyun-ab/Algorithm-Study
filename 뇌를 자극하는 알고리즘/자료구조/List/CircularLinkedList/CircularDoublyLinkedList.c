#include "CircularDoublyLinkedList.h"

Node* CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->Data = NewData;
	NewNode->PrevNode = NULL;
	NewNode->NextNode = NULL;

	return NewNode;
}

void DestroyNode(Node* Node) {
	free(Node);
}

void AppendNode(Node** Head, Node* NewNode) {
	/* 헤드 노드가 NULL이면 새 노드가 Head가 된다.
	이 때 Head는 NextNode와 PrevNode 모두 자기 자신을 참조!! */
	if ((*Head) == NULL) {
		*Head = NewNode;
		(*Head)->NextNode = *Head;
		(*Head)->PrevNode = *Head;
	}
	else {
		Node* Tail = (*Head)->PrevNode;
		
		Tail->NextNode->PrevNode = NewNode;
		Tail->NextNode = NewNode;

		NewNode->NextNode = (*Head);
		NewNode->PrevNode = Tail;
	}
}

void InsertAfter(Node* Current, Node* NewNode) {
	NewNode->NextNode = Current->NextNode;
	NewNode->PrevNode = Current;

	Current->NextNode->PrevNode = NewNode;
	Current->NextNode = NewNode;
}

void RemoveNode(Node** Head, Node* Remove) {
	if (*Head == Remove) {
		(*Head)->PrevNode->NextNode = Remove->NextNode;
		(*Head)->NextNode->PrevNode = Remove->PrevNode;

		*Head = Remove->NextNode;

		Remove->PrevNode = NULL;
		Remove->NextNode = NULL;
	}
	else {
		Node* Temp = Remove;
		
		Remove->PrevNode->NextNode = Temp->NextNode;
		Remove->NextNode->PrevNode = Temp->PrevNode;

		Remove->PrevNode = NULL;
		Remove->NextNode = NULL;
	}
}

Node* GetNodeAt(Node* Head, int Location) {
	Node* Current = Head;

	while (Current != NULL && (--Location) >= 0) {
		Current = Current->NextNode;
	}

	return Current;
}

int GetNodeCount(Node* Head) {
	unsigned int	Count	= 0;
	Node*			Current = Head;

	while (Current != NULL) {
		Current = Current->NextNode;
		Count++;

		//헤드 하나만 있는 리스트라면 무한반복 하게 되므로 break를 해주어야 함!
		if (Current == Head)
			break;
	}

	return Count;
}

void PrintNode(Node* Node) {
	if (Node->PrevNode == NULL)
		printf("Prev: NULL");
	else
		printf("Prev: %d", Node->PrevNode->Data);

	printf("Current: %d", Node->Data);

	if (Node->NextNode == NULL)
		printf("Next: NULL");
	else
		printf("Next: %d", Node->NextNode->Data);
}