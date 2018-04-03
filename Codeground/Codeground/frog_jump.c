/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

#include <stdio.h>

int Answer;

int main(void)
{
	int T, test_case;
	int N, *a, K;
	int i;
	int current;
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
		current = 0;
		Answer = 1;

		scanf("%d", &N);
		a = (int*)malloc(sizeof(int)*N);

		for (i = 0; i < N; i++)
		{
			scanf("%d", &a[i]);
		}
		scanf("%d", &K);

		for (i = 0; i < N-1; i++)
		{
			if ((a[i + 1] - a[i]) > K)
			{
				Answer = -1;
				break;
			}
		}

		if (Answer != -1)
		{
			for (i = 0; i < N - 1; i++)
			{
				if (current + K < a[i + 1])
				{
					
				}
			}
		}

		// Print the answer to standard output(screen).

		printf("Case #%d\n", test_case + 1);
		printf("%d\n", Answer);

	}

	fclose(f);

	return 0;//Your program should return 0 on normal termination.
}