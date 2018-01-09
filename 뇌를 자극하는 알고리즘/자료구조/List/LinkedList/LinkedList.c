#include "LinkedList.h"

Node* CreateNode(ElementType NewData){
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->Data = NewData;
	NewNode->NextNode = NULL;

	return NewNode;
}

void DestroyNode(Node* Node){
	free(Node);
}

void AppendNode(Node** Head, Node* NewNode){
	if((*Head) == NULL){
		*Head = NewNode;
	}
	else {
		Node* Tail = (*Head);
		while(Tail->NextNode != NULL){
			Tail = Tail->NextNode;
		}
		Tail->NextNode = NewNode;
	}
}

void InsertAfter(Node* Current, Node* NewNode){
	NewNode->NextNode = Current->NextNode;
	Current->NextNode = NewNode;
}

void InsertNewHead(Node** Head, Node* NewHead){
	if(*Head == NULL){
		(*Head) == NewHead;
	}
	else {
		NewHead->NextNode = (*Head);
		(*Head) = NewHead;
	}
}

void RemoveNode(Node** Head, Node* Remove){
	if(*Head == Remove){
		*Head = Remove->NextNode;
	}
	else {
		Node* Current = *Head;
		while (Current != NULL && Current->NextNode != Remove){
			Current = Current->NextNode;
		}

		if(Current != NULL)
			Current->NextNode = Remove->NextNode;
	}
}

Node* GetNodeAt(Node* Head, int Location){
	Node* Current = Head;

	while (Current != NULL && (--Location) >= 0){
		Current = Current->NextNode;
	}

	return Current;
}

int GetNodeCount(Node* Head){
	int Count = 0;
	Node* Current = Head;

	while (Current != NULL){
		Current = Current->NextNode;
		Count++;
	}

	return Count;
}

void InsertBefore(Node** Head, Node* Current, Node* NewNode){
	if (*Head == NewNode) {
		InsertNewHead(&(*Head), NewNode);
	}
	else {
		Node* PrevNode = (*Head);
		while (PrevNode->NextNode != Current){
			PrevNode = PrevNode->NextNode;
		}
		NewNode->NextNode = Current;
		PrevNode->NextNode = NewNode;
	}
}

void DestroyAllNodes(Node** List){
	Node* Current = GetNodeAt(*List, 0);
	int Count = GetNodeCount(Current);
	int i = 0;

	for(i=0; i<Count; i++){
		Current = GetNodeAt(*List, 0);

		if(Current != NULL){
			RemoveNode(List, Current);
			DestroyNode(Current);
		}
	}
}