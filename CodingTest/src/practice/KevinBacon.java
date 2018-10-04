package practice;
import java.util.*;

public class Main {
	
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] friend = new int[N+1][N+1];
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			friend[A][B] = 1;
			friend[B][A] = 1;
		}
		
		Answer = 5000;
		
		for(int i = 1; i <= N; i++) {
			int num = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			boolean isVisited[] = new boolean[N+1];
			int[] f = new int[N+1];
			
			q.add(i);
			isVisited[i] = true;
			while(!q.isEmpty()) {
				int node = q.remove();
				for(int j = 1; j <= N; j++) {
					if(!isVisited[j] && friend[node][j] == 1) {
						isVisited[j] = true;
						f[j] = f[node] + 1;
						q.add(j);
					}
				}
			}
			
			for(int k = 1; k <= N; k++) {
				num += f[k];
			}
			
			list.add(num);
			Answer = Math.min(num, Answer);
		}
		
		Answer = list.indexOf(Answer) + 1;
		System.out.println(Answer);
	}
}
