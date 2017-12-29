#include "LinkedList.h"

int main(void){

	int i			= 0;
	int Count		= 0;
	Node* List		= NULL;
	Node* Current	= NULL;
	Node* NewNode	= NULL;
	
	//노드 5개 추가
	for(i=0; i<5; i++){
		NewNode = CreateNode(i);
		AppendNode(&List, NewNode);
	}

	/*
	//리스트 출력
	Count = GetNodeCount(List);
	for(i=0; i<Count; i++){
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}
	*/

	//세 번째 노드 전에 새 노드 삽입
	NewNode = CreateNode(10);
	Current = GetNodeAt(List, 2);
	InsertBefore(&List, Current, NewNode);

	//리스트 출력
	Count = GetNodeCount(List);
	for(i=0; i<Count; i++){
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}

	//모든 노드 제거
	DestroyAllNodes(&List);

	//다시 출력
	Count = GetNodeCount(List);
	for(i=0; i<Count; i++){
		Current = GetNodeAt(List, i);
		printf("List[%d] : %d\n", i, Current->Data);
	}
	printf("모두 삭제 완료\n");

	return 0;
}