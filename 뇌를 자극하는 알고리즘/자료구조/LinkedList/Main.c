#include "LinkedList.h"

int main(void){

	int i			= 0;
	int Count		= 0;
	Node* List		= NULL;
	Node* Current	= NULL;
	Node* NewNode	= NULL;
	
	//��� 5�� �߰�
	for(i=0; i<5; i++){
		NewNode = CreateNode(i);
		AppendNode(&List, NewNode);
	}

	/*
	//����Ʈ ���
	Count = GetNodeCount(List);
	for(i=0; i<Count; i++){
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}
	*/

	//�� ��° ��� ���� �� ��� ����
	NewNode = CreateNode(10);
	Current = GetNodeAt(List, 2);
	InsertBefore(&List, Current, NewNode);

	//����Ʈ ���
	Count = GetNodeCount(List);
	for(i=0; i<Count; i++){
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	//��� ��� ����
	DestroyAllNodes(&List);

	//�ٽ� ���
	Count = GetNodeCount(List);
	for(i=0; i<Count; i++){
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}
	printf("��� ���� �Ϸ�\n");

	return 0;
}