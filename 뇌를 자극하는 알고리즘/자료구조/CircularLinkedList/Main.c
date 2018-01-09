#include "CircularDoublyLinkedList.h"

int main(void) {

	int		i = 0;
	int		Count = 0;
	Node*	List = NULL;
	Node*	NewNode = NULL;
	Node*	Current = NULL;

	//��� 5�� �߰�
	for (i = 0; i < 5; i++) {
		NewNode = CreateNode(i);
		AppendNode(&List, NewNode);
	}

	//����Ʈ ��� (��� ���� 2�踸ŭ �ݺ��Ͽ� ȯ�� Ȯ��!)
	Count = GetNodeCount(List);
	for (i = 0; i < Count*2; i++) {
		if (i == 0)
			Current = List;
		else
			Current = Current->NextNode;

		printf("List[%d] : %d\n", i, Current->Data);
	}

	//��� ��� �޸𸮿��� ����
	printf("��� ����\n");

	Count = GetNodeCount(List);
	for (i = 0; i < Count; i++) {
		Current = GetNodeAt(List, 0);

		if (Current != NULL) {
			RemoveNode(&List, Current);
			DestroyNode(Current);
		}
	}

	return 0;
}