package practice;
import java.io.FileInputStream;
import java.util.*;

public class RGBstreet {

	static int Answer;
	static int N;
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
		
		Answer = 0;
		N = sc.nextInt();
		cost = new int[N][3];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < 3; j++){
				cost[i][j] = sc.nextInt();
			}
		}
		
		Answer = dp();
		
		// Print the answer to standard output(screen).
		System.out.println(Answer);
	}
	
	
	public static int dp(){
		for(int i = 1; i < N; i++){
			for(int j = 0; j < 3; j++){
				switch(j){
				case 0:
					cost[i][j] += Math.min(cost[i-1][1], cost[i-1][2]);
					break;
				case 1:
					cost[i][j] += Math.min(cost[i-1][0], cost[i-1][2]);
					break;
				case 2:
					cost[i][j] += Math.min(cost[i-1][0], cost[i-1][1]);
					break;
				}
			}
		}
		
		return Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2]));
	}
}