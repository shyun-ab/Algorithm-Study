package practice;
import java.io.FileInputStream;
import java.util.*;

/*
 * 정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오. 
 * 팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다. 단, 정수를 문자열로 바꾸면 안됩니다.
 */

public class Question4 {

	static boolean Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		
		int N = sc.nextInt();
		int num = 0;
		int[] index = new int[2];
		
		if(N < 0) {
			Answer = false;
		}
		else if(N == 0) {
			Answer = true;
		}
		else {
			Answer = true;
			while (N > 0) {
				num = N % 10;
				N = N / 10;
				list.add(num);
			}
			
			index[0] = 0;
			index[1] = list.size() - 1;
			
			while(Answer == true) {
				Answer = (list.get(index[0]) == list.get(index[1]));
				if(index[0] == index[1]) break;
				if(index[0] + 1 == index[1]) break;
				index[0]++;
				index[1]--;
			}
		}
		
		System.out.println(Answer);
	}
}