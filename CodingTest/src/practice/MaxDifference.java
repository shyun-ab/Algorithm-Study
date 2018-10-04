package practice;
import java.util.*;

public class Main {
	
	static int[] A;
	static int N;
	static List<Integer> list;
	static boolean isVisited[];
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		list = new ArrayList<Integer>();
		Answer = 0;
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			list.clear();
			isVisited[i] = true;
			list.add(A[i]);
			back(1);
		}
		
		System.out.println(Answer);
	}
	
	static void back(int num) {
		if(num == N) {
			int sum = calculate(list);
			if(Answer < sum) {
				Answer = sum;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				list.add(A[i]);
				back(num + 1);
				isVisited[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	
	static int calculate(List<Integer> l) {
		int sum = 0;
		for(int i = 0; i < N-1; i++) {
			sum += Math.abs(list.get(i) - list.get(i+1));
		}
		
		return sum;
	}
	
}
