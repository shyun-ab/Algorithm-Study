import java.util.*;

public class DFSnBFS {
	static boolean visited[];
	static ArrayList<Integer>[] adj;
	static Queue<Integer> Q;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		adj = (ArrayList<Integer>[])new ArrayList[N + 1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for(int i=1; i<=N; i++) Collections.sort(adj[i]);
		visited = new boolean[N + 1];
		Q = new LinkedList<Integer>();
		DFS(V);
		System.out.println();
		reset(N);
		BFS(V);
		System.out.println();
		sc.close();
	}
	
	public static void reset(int N){
		for(int i=1; i<=N; i++) visited[i] = false;
	}
	
	public static void DFS(int x){
		visited[x] = true;
		System.out.println(x + " ");
		for(int y : adj[x]) {
			if(!visited[y]) {
				DFS(y);
			}
		}
	}
	
	public static void BFS(int sx){
		Q.add(sx);
		visited[sx] = true;
		while(!Q.isEmpty()) {
			int x = Q.poll();
			System.out.println(x + " ");
			for(int y : adj[x]){
				if(!visited[y]) {
					visited[y] = true;
					Q.add(y);
				}
			}
		}
	}

}
