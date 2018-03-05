#include "ExpressionTree.h"

Node* CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->Left = NULL;
	NewNode->Right = NULL;
	NewNode->Data = NewData;

	return NewNode;
}

void DestroyNode(Node* Node) {
	free(Node);
}

void DestroyTree(Node* Root) {
	if (Root == NULL)
		return;

	DestroyTree(Root->Left);
	DestroyTree(Root->Right);
	DestroyNode(Root);
}

void PreorderPrintTree(Node* Node) {
	if (Node == NULL)
		return;

	printf(" %c", Node->Data);
	PreorderPrintTree(Node->Left);
	PreorderPrintTree(Node->Right);
}

void InorderPrintTree(Node* Node) {
	if (Node == NULL)
		return;

	printf("(");
	InorderPrintTree(Node->Left);
	printf(" %c", Node->Data);
	InorderPrintTree(Node->Right);
}

void PostorderPrintTree(Node* Node) {
	if (Node == NULL)
		return;

	PostorderPrintTree(Node->Left);
	PostorderPrintTree(Node->Right);
	printf(" %c", Node->Data);
}

void BuildExpressionTree(char* PostfixExpression, Node** Node) {
	int len = strlen(PostfixExpression);
	char Token = PostfixExpression[len - 1];
	PostfixExpression[len - 1] = '\0';

	switch (Token) {
		//연산자인 경우
		case '+': case '-': case '*': case '/':
			(*Node) = CreateNode(Token);
			BuildExpressionTree(PostfixExpression, &(*Node)->Right);
			BuildExpressionTree(PostfixExpression, &(*Node)->Left);
			break;

		//피연산자인 경우
		default:
			(*Node) = CreateNode(Token);
			break;
	}
}

double Evaluate(Node* Tree) {
	char Temp[2];

	double Left = 0;
	double Right = 0;
	double Result = 0;

	if (Tree == NULL)
		return 0;

	switch (Tree->Data) {
		//연산자인 경우
	case '+': case '-': case '*': case '/':
		Left = Evaluate(Tree->Left);
		Right = Evaluate(Tree->Right);

		if (Tree->Data == '+') Result = Left + Right;
		else if (Tree->Data == '-') Result = Left - Right;
		else if (Tree->Data == '*') Result = Left * Right;
		else if (Tree->Data == '/') Result = Left / Right;

		break;

		//피연산자인 경우
	default:
		memset(Temp, 0, sizeof(Temp));
		Temp[0] = Tree->Data;
		Result = atof(Temp);
		break;
	}

	return Result;
}