import java.io.FileInputStream;
import java.util.*;

public class Fibonacci {

	static int zeroAnswer;
	static int oneAnswer;

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
		int N, result;
		
		for(int test_case = 0; test_case < T; test_case++) {

			zeroAnswer = 0;
			oneAnswer = 0;
			N = sc.nextInt();
			
			result = f(N);
			
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(zeroAnswer+" "+oneAnswer);
		}
	}
	
	public static int f(int n) {
	    if (n == 0) {
	        count(0);
	    	return 0;
	    } 
	    else if (n == 1) {
	    	count(1);
	        return 1;
	    } 
	    else {
	        return f(n - 1) + f(n - 2);
	    }
	}
	
	public static void count(int num){
		if(num == 0) zeroAnswer++;
		else if(num == 1) oneAnswer++;
		else System.out.println("error in count");
	}
}