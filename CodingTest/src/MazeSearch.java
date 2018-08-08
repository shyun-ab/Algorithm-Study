import java.util.*;

public class Main {
	
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] maze = new int[N][M];
		
		Answer = 0;
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		q.add(0);
		q.add(0);
		
		while(!q.isEmpty()) {
			int x = q.remove();
			int y = q.remove();
			if(x == N-1 && y == M-1) break;
			
			if(x > 0 && maze[x-1][y] == 1) {
				maze[x-1][y] = maze[x][y] + 1;
				q.add(x-1);
				q.add(y);
			}
			if(y > 0 && maze[x][y-1] == 1) {
				maze[x][y-1] = maze[x][y] + 1;
				q.add(x);
				q.add(y-1);
			}
			if(x < N-1 && maze[x+1][y] == 1) {
				maze[x+1][y] = maze[x][y] + 1;
				q.add(x+1);
				q.add(y);
			}
			if(y < M-1 && maze[x][y+1] == 1) {
				maze[x][y+1] = maze[x][y] + 1;
				q.add(x);
				q.add(y+1);
			}
		}
		
		Answer = maze[N-1][M-1];
		
		System.out.println(Answer);
	}
}
