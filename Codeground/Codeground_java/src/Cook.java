import java.io.FileInputStream;
import java.util.*;

public class Cook {

	static int Answer;
	static int[][] table;
	static int N;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			N = sc.nextInt();
			table = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	
	public static void choose() {
		
	}
}