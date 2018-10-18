import java.io.FileInputStream;
import java.util.*;

public class MakeNumber {

	static int Answer, min, max;
	static int N;
	static int[] numbers;
	static int[] op;
	static ArrayList<Integer> list;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			list = new ArrayList<Integer>();
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			N = sc.nextInt();
			numbers = new int[N];
			op = new int[4];
			
			for(int i = 0; i < 4; i++) {
				op[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			dfs(0);
			
			Answer = Math.abs(max-min);
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	
	public static void dfs(int turn) {
		list.add(numbers[turn]);
		
		if(turn == N-1) {	
			cal();
			list.remove(list.size()-1);
			return;
		}
		
		if(op[0] != 0) {
			op[0]--;
			list.add(0); 
			dfs(turn+1);
			list.remove(list.size()-1);
			op[0]++;
		}
		if(op[1] != 0) {
			op[1]--;
			list.add(1); 
			dfs(turn+1);
			list.remove(list.size()-1);
			op[1]++;
		}
		if(op[2] != 0) {
			op[2]--;
			list.add(2); 
			dfs(turn+1);
			list.remove(list.size()-1);
			op[2]++;
		}
		if(op[3] != 0) {
			op[3]--;
			list.add(3);
			dfs(turn+1);
			list.remove(list.size()-1);
			op[3]++;
		}
		
		list.remove(list.size()-1);
	}
	
	public static void cal() {
		int temp = list.get(0);
		int operator, next;
		
		for(int i = 1; i <= N-1; i++) {
			operator = list.get(2*i - 1);
			next = list.get(2*i);
			
			if(operator == 0) temp = temp + next;
			else if(operator == 1) temp = temp - next;
			else if(operator == 2) temp = temp * next;
			else temp = temp / next;
		}
		
		if(temp < min) min = temp;
		if(temp > max) max = temp;
	}
}