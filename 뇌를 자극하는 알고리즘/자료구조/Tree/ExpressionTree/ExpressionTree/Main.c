#include "ExpressionTree.h"

int main(void) {
	Node* Root = NULL;

	char PostfixExpression[20] = "71*52-/";
	BuildExpressionTree(PostfixExpression, &Root);

	//Ʈ�� ���
	printf("Preorder...\n");
	PreorderPrintTree(Root);
	printf("\n\n");

	prinf("Inorder...\n");
	InorderPrintTree(Root);
	printf("\n\n");

	printf("Postorder...\n");
	PostfixPrintTree(Root);
	printf("\n\n");

	printf("Evaluation Result: %f \n", Evaluate(Root));

	//Ʈ�� �Ҹ�
	DestroyTree(Root);

	return 0;
}