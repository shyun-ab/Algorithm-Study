//SW역량테스트 기출문제

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
	int N, M, Red_x, Red_y, Blue_x, Blue_y, goal_x, goal_y;
	char board[10][10];
	int i, j, temp;
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
		
		scanf("%d %d", &N, &M);
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				scanf("%c", &board[i][j]);
				if (board[i][j] == 'R') {
					Red_x = i;
					Red_y = j;
				}
				else if (board[i][j] == 'B') {
					Blue_x = i;
					Blue_y = j;
				}
				else if (board[i][j] == 'O') {
					goal_x = i;
					goal_y = j;
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