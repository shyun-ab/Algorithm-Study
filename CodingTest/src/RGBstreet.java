import java.io.FileInputStream;
import java.util.*;

public class RGBstreet {

	static int Answer;
	static int N;
	static int[][] street;
	static int[] RGB;
	static int min, cost;

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
		N = sc.nextInt();
		street = new int[N][3];
		RGB = new int[N];
		cost = 0;
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < 3; j++){
				street[i][j] = sc.nextInt();
			}
		}
		
		
		
		// Print the answer to standard output(screen).
		System.out.println(Answer);
	}
	
	
	public static void dp(int i){
		
	}
}