package practice;
import java.util.*;

public class Main {

	static int Answer;
	static int ground[][];
	static boolean[][] isVisit;
	static int N, M, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int X, Y;
		for(int test_case = 0; test_case < T; test_case++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			ground = new int[N+2][M+2];
			isVisit = new boolean[N+2][M+2];
			
			Answer = 0;
			for(int i = 0; i <= N+1; i++) {
				Arrays.fill(ground[i], 0);
				Arrays.fill(isVisit[i], false);
			}
			
			for(int i = 0; i < K; i++) {
				X = sc.nextInt();
				Y = sc.nextInt();
				ground[Y+1][X+1] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(ground[i][j] != 0 && !isVisit[i][j]) {
						dfs(i, j);
						Answer++;
					}
				}
			}
			
			System.out.println(Answer);
		}
	}
	
	static void dfs(int Y, int X) {
		isVisit[Y][X] = true;
		if(ground[Y+1][X] != 0 && !isVisit[Y+1][X]) {
			dfs(Y+1, X);
		}
		if(ground[Y-1][X] != 0 && !isVisit[Y-1][X]) {
			dfs(Y-1, X);
		}
		if(ground[Y][X+1] != 0 && !isVisit[Y][X+1]) {
			dfs(Y, X+1);
		}
		if(ground[Y][X-1] != 0 && !isVisit[Y][X-1]) {
			dfs(Y, X-1);
		}
	}

}
