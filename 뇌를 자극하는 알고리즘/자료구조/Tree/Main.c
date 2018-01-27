#include "LCRS_Tree.h"

int main(void) {
	Node* Root = CreateNode('A');

	Node* B = CreateNode('B');
	Node* C = CreateNode('C');
	Node* D = CreateNode('D');
	Node* E = CreateNode('E');
	Node* F = CreateNode('F');
	Node* G = CreateNode('G');
	Node* H = CreateNode('H');

	AddChildNode(Root, B);
		AddChildNode(B, C);
		AddChildNode(B, D);
			AddChildNode(D, E);
			AddChildNode(D, F);
	AddChildNode(Root, G);
		AddChildNode(G, H);

	PrintTree(Root, 0);

	PrintNodesAtLevel(Root, 2);

	DestroyTree(Root);

	return 0;
}