import java.util.*;

public class Main {
	
	static int N, M, count;
	static int[][] com;
	static boolean isVisited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<Integer>();
		int max = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		com = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			com[B][A] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			count = 0;
			isVisited = new boolean[N+1];
			dfs(i);
			if(max < count) {
				list = new ArrayList<Integer>();
				max = count;
				list.add(i);
			}
			else if(max == count) {
				list.add(i);
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	static void dfs(int num) {
		isVisited[num] = true;
		count++;
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i] && com[num][i] == 1) {
				dfs(i);
			}
		}
	}
}
