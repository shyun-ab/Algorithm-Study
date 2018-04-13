//SCPC 3È¸ ¿¹¼± - °ýÈ£

import java.io.FileInputStream;
import java.util.*;

public class Parenthesis {

	static int Answer;
	static char[] list;
	static String str;
	static Stack st;
	static boolean[] matched;
	static int temp;
	

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
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			temp = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

			str = sc.next();
			list = str.toCharArray();
			matched = new boolean[list.length];
			
			st = new Stack();
			//answerst = new Stack();
			
			Search(list);
			for(int i = 0; i < matched.length; i++){
				if(matched[i]){
					temp += 1;
					if(Answer < temp) Answer = temp;
				}
				else {
					temp = 0;
				}
			}
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static void Search(char[] array){
		int pop;
		for(int i = 0; i < array.length; i++) {
			if(match(array[i]) == 'x'){
				if(st.isEmpty()){
					matched[i] = false;
				}
				else {
					pop = (int)st.pop();
					if(match(array[pop]) == array[i]){
						matched[pop] = true;
						matched[i] = true;
					}
					else {
						matched[i] = false;
						while(!st.isEmpty()){
							pop = (int)st.pop();
							matched[pop] = false;
						}
					}
				}
			}
			else {
				st.push(i);
				matched[i] = false;
			}
		}
	}
	
	public static char match(char c){
		if(c == '(') {
			return ')';
		}
		else if(c == '{') {
			return '}';
		}
		else if(c == '[') {
			return ']';
		}
		else return 'x';
	}
}