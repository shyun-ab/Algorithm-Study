package practice;
import java.io.FileInputStream;
import java.util.*;

public class IntegerTriangle {

	static int Answer;
	static int n;
	static int[][] tri;
	static int tmpMax;

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
		n = sc.nextInt();
		tri = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(tri[i], -1);
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				tri[i][j] = sc.nextInt();
			}
		}
		
		Answer = dp();
		
		
		// Print the answer to standard output(screen).
		System.out.println(Answer);
	}
	
	
	public static int dp(){
		tmpMax = 0;
		for(int i = 1; i < n; i++){
			for(int j = 0; j <= i; j++){
				if(j == 0) tri[i][j] += tri[i-1][j];
				else if(j == i) tri[i][j] += tri[i-1][j-1];
				else tri[i][j] += Math.max(tri[i-1][j-1], tri[i-1][j]);
			}
		}
		
		for(int j = 0; j < n; j++){
			if(tmpMax < tri[n-1][j]) tmpMax = tri[n-1][j];
		}
		
		return tmpMax;
	}
}