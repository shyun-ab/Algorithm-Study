import java.io.FileInputStream;
import java.util.*;

public class Runway {

	static int Answer;
	static int N, X;
	static int[][] ground;
	static boolean[] put;
	static int[] line;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			N = sc.nextInt();
			X = sc.nextInt();
			ground = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					ground[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < N; i++) {
				line = new int[N];
				for(int j = 0; j < N; j++) {
					line[j] = ground[i][j];
				}
				put = new boolean[N];
				Arrays.fill(put, false);
				fly();
			}
			for(int j = 0; j < N; j++) {
				line = new int[N];
				for(int i = 0; i < N; i++) {
					line[i] = ground[i][j];
				}
				put = new boolean[N];
				Arrays.fill(put, false);
				fly();
			}
			
			// Print the answer to standard output(screen).
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	
	public static void fly() {
		for(int j = 0; j < N-1; j++) {
			int cur = line[j];
			int next = line[j+1];
			
			if(Math.abs(cur-next) > 1) return;
			
			if(cur < next) {
				int cnt = 0;
				while(cnt != X) {
					if(j-cnt < 0 || cur != line[j-cnt] || put[j-cnt]) return;
					put[j-cnt] = true;
					cnt++;
				}
			}
			else if(cur > next) {
				int cnt = 0;
				while(cnt != X) {
					if(j+cnt+1 > N-1 || next != line[j+cnt+1]) return;
					put[j+cnt+1] = true;
					cnt++;
				}
			}
		}
		
		Answer++;
	}
}