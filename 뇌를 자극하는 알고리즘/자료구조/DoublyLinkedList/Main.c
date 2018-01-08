#include "DoublyLinkedList.h"

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

	//����Ʈ ���
	Count = GetNodeCount(List);
	for (i = 0; i < Count; i++) {
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	//����Ʈ �Ųٷ� ���
	PrintReverse(List);

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