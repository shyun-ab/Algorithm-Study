package practice;
import java.io.FileInputStream;
import java.util.*;

public class Sudoku {

	static int Answer;
	static int[][] board;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		Answer = 0;
		board = new int[9][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		
		// Print the answer to standard output(screen).
		System.out.println(Answer);
	}
}