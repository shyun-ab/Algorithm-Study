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
	/* ��� ��尡 NULL�̸� �� ��尡 Head�� �ȴ�.
	�� �� Head�� NextNode�� PrevNode ��� �ڱ� �ڽ��� ����!! */
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

		//��� �ϳ��� �ִ� ����Ʈ��� ���ѹݺ� �ϰ� �ǹǷ� break�� ���־�� ��!
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