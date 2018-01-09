#include "DoublyLinkedList.h"
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
	//��� ��尡 NULL�̸� �� ��尡 Head�� �ȴ�.
	if ((*Head) == NULL) {
		*Head = NewNode;
	}
	else {
		Node* Tail = (*Head);
		while (Tail->NextNode != NULL) {
			Tail = Tail->NextNode;
		}
		Tail->NextNode = NewNode;
		NewNode->PrevNode = Tail;
	}
}

void InsertAfter(Node* Current, Node* NewNode) {
	NewNode->NextNode = Current->NextNode;
	NewNode->PrevNode = Current;

	if (Current->NextNode != NULL) {
		Current->NextNode->PrevNode = NewNode;
	}
	Current->NextNode = NewNode;
}

void RemoveNode(Node** Head, Node* Remove) {
	if (*Head == Remove) {
		*Head = Remove->NextNode;
		if ((*Head) != NULL) {
			(*Head)->PrevNode = NULL;
		}
		Remove->PrevNode = NULL;
		Remove->NextNode = NULL;
	}
	else {
		Node* Temp = Remove;
		if (Remove->PrevNode != NULL) {
			Remove->PrevNode->NextNode = Temp->NextNode;
		}
		if (Remove->NextNode != NULL) {
			Remove->NextNode->PrevNode = Temp->PrevNode;
		}
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
	unsigned int Count	= 0;
	Node* Current		= Head;

	while (Current != NULL) {
		Current = Current->NextNode;
		Count++;
	}

	return Count;
}

//�������� ����ϴ� �Լ�
void PrintReverse(Node* Head) {
	Node* Current = NULL;
	int Count = GetNodeCount(Head);
	int i = Count-1;

	for (i = Count-1; i >= 0; i--) {
		Current = GetNodeAt(Head, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}
}