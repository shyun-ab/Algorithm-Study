package practice;
import java.io.FileInputStream;
import java.util.*;

public class Fibonacci {

	static int[] zero;
	static int[] one;

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

		int T = sc.nextInt();
		int N;
		
		for(int test_case = 0; test_case < T; test_case++) {

			N = sc.nextInt();
			zero = new int[N+1];
			one = new int[N+1];
			zero[0] = 1;
			one[0] = 0;
			if(0 < N) {
				zero[1] = 0;
				one[1] = 1;
			}
			
			dp(N);
			
			// Print the answer to standard output(screen).
			//System.out.println("Case #"+(test_case+1));
			System.out.println(zero[N]+" "+one[N]);
		}
	}
	
	public static void dp(int n) {
	    if(n == 0 || n == 1) return;
	    for(int i = 2; i <= n; i++){
	    	zero[i] = zero[i-2] + zero[i-1];
	    	one[i] = one[i-2] + one[i-1];
	    }
	}
}