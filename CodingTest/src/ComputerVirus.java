import java.util.*;

public class Main {

	static int Answer;
	static int graph[][];
	static boolean[] isVisit;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start, end;
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N+1][N+1];
		isVisit = new boolean[N+1];
		
		Answer = 0;
		for(int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], 0);
		}
		
		for(int i = 1; i <= M; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		
		dfs(1);
		
		System.out.println(Answer);
	}
	
	static void dfs(int node) {
		isVisit[node] = true;
		if(node != 1) Answer++;
		for(int i = 1; i <= N; i++) {
			if(!isVisit[i] && graph[node][i] != 0) {
				dfs(i);
			}
		}
	}

}
