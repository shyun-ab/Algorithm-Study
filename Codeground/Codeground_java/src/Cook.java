import java.io.FileInputStream;
import java.util.*;

public class Cook {

	static int Answer;
	static int[][] table;
	static int N;
	static boolean[] choice;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = Integer.MAX_VALUE;
			N = sc.nextInt();
			table = new int[N][N];
			choice = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			choose(0, 0);
			
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	
	public static void choose(int count, int num) {
		if(count == N/2) {
			int tmp = cal();
			if(tmp < Answer) Answer = tmp;
			return;
		}
		if(num > N/2 && count == 0) return;
		if(num == N) return;
		
		choice[num] = true;
		choose(count+1, num+1);
		choice[num] = false;
		choose(count, num+1);
	}
	
	public static int cal() {
		int A=0, B=0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(choice[i] == true && choice[j] == true) {
					A += table[i][j];
				}
				if(choice[i] == false && choice[j] == false) {
					B += table[i][j];
				}
			}
		}
		
		return Math.abs(A-B);
	}
}