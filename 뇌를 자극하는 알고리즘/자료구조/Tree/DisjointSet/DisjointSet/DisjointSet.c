#include "DisjointSet.h"

void UnionSet(DisjointSet* Set1, DisjointSet* Set2) {
	Set2 = FindSet(Set2);
	Set2->Parent = Set1;
}

DisjointSet* FindSet(DisjointSet* Set) {
	while (Set->Parent != NULL) {
		Set = Set->Parent;
	}

	return Set;
}

DisjointSet* MakeSet(void* NewData) {
	DisjointSet* NewNode = (DisjointSet*)malloc(sizeof(DisjointSet));
	NewNode->Data = NewData;
	NewNode->Parent = NULL;

	return NewNode;
}

void DestroySet(DisjointSet* Set) {
	free(Set);
}