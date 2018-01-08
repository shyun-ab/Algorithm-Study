#include "DoublyLinkedList.h"

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

	//리스트 출력
	Count = GetNodeCount(List);
	for (i = 0; i < Count; i++) {
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	//리스트 거꾸로 출력
	PrintReverse(List);

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