#include "BinaryTree.h"

int main(void) {
	Node* A = CreateNode('A');
	Node* B = CreateNode('B');
	Node* C = CreateNode('C');
	Node* D = CreateNode('D');
	Node* E = CreateNode('E');
	Node* F = CreateNode('F');
	Node* G = CreateNode('G');

	A->Left = B;
	B->Left = C;
	B->Right = D;

	A->Right = E;
	E->Left = F;
	E->Right = G;

	printf("Preorder...\n");
	PreorderPrintTree(A);
	printf("\n\n");

	printf("Inorder...\n");
	InorderPrintTree(A);
	printf("\n\n");

	printf("Postorder...\n");
	PostorderPrintTree(A);
	printf("\n");

	DestroyTree(A);

	return 0;
}