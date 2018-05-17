import java.io.FileInputStream;
import java.util.*;

public class RGBstreet {

	static int Answer;
	static int[][] cost;

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

		int N;
		
		Answer = 0;
		N = sc.nextInt();
		cost = new int[N][3];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < 3; j++){
				cost[i][j] = sc.nextInt();
			}
		}
		
		
		
		
		// Print the answer to standard output(screen).
		System.out.println(Answer);
	}
}