/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

#include <stdio.h>
#define TRUE 1
#define FALSE 0

//str - 뒤에 이어지는 string, n - 남은 str의 개수
int check_s(char *str, int n) { 
	int i = 0;

	for (i = 0; i < n; i++)
	{
		if (str[i] == ')') 
		{
			return TRUE;
		}
	}

	return FALSE;
}

int check_m(char *str, int n) {
	int i = 0;

	for (i = 0; i < n; i++)
	{
		if (str[i] == '}')
		{
			return TRUE;
		}
	}

	return FALSE;
}

int check_l(char *str, int n) {
	int i = 0;

	for (i = 0; i < n; i++)
	{
		if (str[i] == ']')
		{
			return TRUE;
		}
	}

	return FALSE;
}

int Answer;

int main(void)
{
	int T, test_case;
	char *str;
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
		Answer = 0;

		/////////////////////////////////////////////////////////////////////////////////////////////
		/*
		Implement your algorithm here.
		The answer to the case will be stored in variable Answer.
		*/
		/////////////////////////////////////////////////////////////////////////////////////////////

		scanf("%s", &str);

		// Print the answer to standard output(screen).

		printf("Case #%d\n", test_case + 1);
		printf("%d\n", Answer);

	}

	fclose(f);

	return 0;//Your program should return 0 on normal termination.
}