#include "CircularDoublyLinkedList.h"

int main(void) {

	int		i = 0;
	int		Count = 0;
	Node*	List = NULL;
	Node*	NewNode = NULL;
	Node*	Current = NULL;

	//노드 5개 추가
	for (i = 0; i < 5; i++) {
		NewNode = CreateNode(i);
		AppendNode(&List, NewNode);
	}

	//리스트 출력 (노드 수의 2배만큼 반복하여 환형 확인!)
	Count = GetNodeCount(List);
	for (i = 0; i < Count*2; i++) {
		if (i == 0)
			Current = List;
		else
			Current = Current->NextNode;

		printf("List[%d] : %d\n", i, Current->Data);
	}

	//모든 노드 메모리에서 제거
	printf("노드 삭제\n");

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