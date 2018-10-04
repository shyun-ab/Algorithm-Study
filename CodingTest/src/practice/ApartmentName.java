package practice;
import java.util.*;

public class Main {

	static int num;
	static char map[][];
	static boolean[][] isVisit;
	static int N;
	static int area;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] Area;
		
		N = sc.nextInt();
		map = new char[N][N];
		isVisit = new boolean[N][N];
		List<Integer> list = new ArrayList<Integer>();
		
		num = 0;
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1' && !isVisit[i][j]) {
					area = 0;
					num++;
					dfs(i, j, num);
					list.add(area);
				}
			}
		}

		Area = new int[num];
		for(int i = 0; i < list.size(); i++) {
			Area[i] = list.get(i);
		}
		Arrays.sort(Area);
		System.out.println(num);
		for(int i = 0; i < num; i++) {
			System.out.println(Area[i]);
		}
	}
	
	static void dfs(int i, int j, int num) {
		isVisit[i][j] = true;
		area++;
		if(i+1 < N && map[i+1][j] == '1' && !isVisit[i+1][j]) {
			dfs(i+1, j, num);
		}
		if(j+1 < N && map[i][j+1] == '1' && !isVisit[i][j+1]) {
			dfs(i, j+1, num);
		}
		if(i-1 >= 0 && map[i-1][j] == '1' && !isVisit[i-1][j]) {
			dfs(i-1, j, num);
		}
		if(j-1 >= 0 && map[i][j-1] == '1' && !isVisit[i][j-1]) {
			dfs(i, j-1, num);
		}
	}

}
