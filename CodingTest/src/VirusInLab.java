import java.util.*;

public class Main {
	
	static int Answer;
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		Answer = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(1);
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(Answer);
	}
	
	static void dfs(int count) {
		if(count == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(count + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		int tmp = 0;
		int[][] tmpmap = new int[N][M];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmpmap[i][j] = map[i][j];
				if(tmpmap[i][j] == 2) {
					q.add(i);
					q.add(j);
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.remove();
			int y = q.remove();
			
			if(x-1 >= 0 && tmpmap[x-1][y] == 0) {
				tmpmap[x-1][y] = 2;
				q.add(x-1);
				q.add(y);
			}
			if(x+1 < N && tmpmap[x+1][y] == 0) {
				tmpmap[x+1][y] = 2;
				q.add(x+1);
				q.add(y);
			}
			if(y-1 >= 0 && tmpmap[x][y-1] == 0) {
				tmpmap[x][y-1] = 2;
				q.add(x);
				q.add(y-1);
			}
			if(y+1 < M && tmpmap[x][y+1] == 0) {
				tmpmap[x][y+1] = 2;
				q.add(x);
				q.add(y+1);
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int l = 0; l < M; l++) {
				if(tmpmap[k][l] == 0) tmp++;
			}
		}
		
		Answer = Math.max(tmp, Answer);
	}
}
