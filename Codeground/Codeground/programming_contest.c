/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

#include <stdio.h>
#include <stdlib.h>

int Answer;

int static compare(const void *first, const void *second)
{
	if (*(int*)first > *(int*)second)
		return 1;
	else if (*(int*)first < *(int*)second)
		return -1;
	else
		return 0;
}

int main(void)
{
	int T, test_case;
	int *scores = NULL;
	int N, i, j, max, temp;
	//int scores[10];
	//int new_scores[10];

	/*
	The freopen function below opens input.txt file in read only mode, and afterward,
	the program will read from input.txt file instead of standard(keyboard) input.
	To test your program, you may save input data in input.txt file,
	and use freopen function to read from the file when using scanf function.
	You may remove the comment symbols(//) in the below statement and use it.
	But before submission, you must remove the freopen function or rewrite comment symbols(//).
	*/
	int f = freopen("input.txt", "r", stdin);

	/*
	If you remove the statement below, your program's output may not be rocorded
	when your program is terminated after the time limit.
	For safety, please use setbuf(stdout, NULL); statement.
	*/
	setbuf(stdout, NULL);

	scanf("%d", &T);
	for (test_case = 0; test_case < T; test_case++)
	{

		/////////////////////////////////////////////////////////////////////////////////////////////
		/*
		Implement your algorithm here.
		The answer to the case will be stored in variable Answer.
		*/
		/////////////////////////////////////////////////////////////////////////////////////////////

		max = 0; i = 0; j = 0;

		scanf("%d", &N);
		scores = (int*)malloc(sizeof(int)*N);

		for (i = 0; i < N; i++)
		{
			scanf("%d", &scores[i]);
		}

		qsort(scores, N, sizeof(int), compare);

		for (i = 0; i < N; i++)
		{
			if (scores[i] + (N - i) > max) max = scores[i] + (N - i);
		}

		Answer = 0;

		for (i = 0; i < N; i++)
		{
			if (scores[i] + N >= max) Answer++;
		}

		// Print the answer to standard output(screen).

		printf("Case #%d\n", test_case + 1);
		printf("%d\n", Answer);
	}

	fclose(f);

	return 0;//Your program should return 0 on normal termination.
}