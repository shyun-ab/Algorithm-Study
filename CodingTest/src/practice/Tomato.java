package practice;
import java.util.*;

public class Main {
	
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] box = new int[N][M];
		int max = 0;
		
		Answer = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1) {
					q.add(i);
					q.add(j);
				}
			}
		}
		
		while(!q.isEmpty()) {
			if(q.size() == 2 * M * N) break;
			int x = q.remove();
			int y = q.remove();
			
			if(x > 0 && box[x-1][y] == 0) {
				box[x-1][y] = box[x][y] + 1;
				q.add(x-1);
				q.add(y);
			}
			if(y > 0 && box[x][y-1] == 0) {
				box[x][y-1] = box[x][y] + 1;
				q.add(x);
				q.add(y-1);
			}
			if(x < N-1 && box[x+1][y] == 0) {
				box[x+1][y] = box[x][y] + 1;
				q.add(x+1);
				q.add(y);
			}
			if(y < M-1 && box[x][y+1] == 0) {
				box[x][y+1] = box[x][y] + 1;
				q.add(x);
				q.add(y+1);
			}
		}
		
		if(q.isEmpty()) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(box[i][j] == 0) q.add(0);
					else max = Math.max(max, box[i][j]);
				}
			}
		}
		if(q.isEmpty()) Answer = max - 1;
		else Answer = -1;
		
		System.out.println(Answer);
	}
}
