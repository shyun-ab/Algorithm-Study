import java.util.*;

public class Main {

	static int N, M, V;
	static int matrix[][];
	static boolean isVisited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		matrix = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		
		int start, end;
		for(int i = 1; i <= M; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			matrix[start][end] = 1;
			matrix[end][start] = 1;
		}
		
		dfs(V);
		System.out.println();
		isVisited = new boolean[N+1];
		bfs(V);
	}
	
	static void dfs(int node) {
		isVisited[node] = true;
		System.out.print(node + " ");
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i] && matrix[node][i] == 1) {
				dfs(i);
			}
		}
	}

	static void bfs(int startNode) {
		Queue<Integer> q = new LinkedList();
		q.add(startNode);
		isVisited[startNode] = true;
		while(!q.isEmpty()) {
			int node = q.remove();
			System.out.print(node + " ");
			for(int i = 1; i <= N; i++) {
				if(!isVisited[i] && matrix[node][i] == 1) {
					isVisited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
