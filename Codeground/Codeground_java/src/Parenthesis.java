//아직 미완!

import java.io.FileInputStream;
import java.util.Scanner;

public class Parenthesis {

	static int Answer;

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
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

			String str = sc.nextLine();
			
			int pair;
			int result = 0;
			for(int i = 0; i < str.length(); i++) {
				
			}

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	
	public static int check_s(String str, int i, int n) {
		for(; i < n; i++){
			if(str.charAt(i) == ')'){
				return i;
			}
		}
		return 0;
	}
	
	public static int check_m(String str, int i, int n) {
		for(; i < n; i++){
			if(str.charAt(i) == '}'){
				return i;
			}
		}
		return 0;
	}
	
	public static int check_l(String str, int i, int n) {
		for(; i < n; i++){
			if(str.charAt(i) == ']'){
				return i;
			}
		}
		return 0;
	}
	
}
