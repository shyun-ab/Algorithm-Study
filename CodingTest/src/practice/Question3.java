package practice;
import java.io.FileInputStream;
import java.util.*;

/*
 * 정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 만들 수 있는 괄호 조합을 모두 구하시오.
 */

public class Question3 {

	static int N;
	static List<String> list = new ArrayList();
	
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		recurse(list, "", 0, 0);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	static void recurse(List<String> list, String str, int open, int close) {
		if(str.length() == N*2) {
			list.add(str);
			return;
		}
		
		if(open < N) recurse(list, str + "(", open + 1, close);
		if(close < open) recurse(list, str + ")", open, close + 1);
	}
}