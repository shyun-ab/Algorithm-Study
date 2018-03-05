#include <stdio.h>
#include <stdlib.h>

#ifndef DISJOINTSET_H
#define DISJOINTSET_H

typedef struct DisjointSet {
	struct DisjointSet* Parent;
	void* Data;
} DisjointSet;

void UnionSet(DisjointSet* Set1, DisjointSet* Set2);
DisjointSet* FindSet(DisjointSet* Set);
DisjointSet* MakeSet(void* NewData);
void DestroySet(DisjointSet* Set);

#endif // !DISJOINTSET_H
