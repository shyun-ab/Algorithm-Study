import java.util.*;

public class Main {

	static int Answer;
	static int map[][];
	static int N, max, rain, maxRain;
	static boolean isVisited[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		isVisited = new boolean[N][N];
		maxRain = 0;
		rain = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(maxRain < map[i][j]) maxRain = map[i][j];
			}
		}
		
		max = 0;
		while(rain < maxRain) {
			Answer = 0;
			isVisited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > rain && !isVisited[i][j]) {
						dfs(i, j);
						Answer++;
					}
				}
			}
			if(max < Answer) max = Answer;
			rain++;
		}
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y) {
		isVisited[x][y] = true;
		if(x-1 >= 0 && map[x-1][y] > rain && !isVisited[x-1][y]) {
			dfs(x-1, y);
		}
		if(y-1 >= 0 && map[x][y-1] > rain && !isVisited[x][y-1]) {
			dfs(x, y-1);
		}
		if(x+1 < N && map[x+1][y] > rain && !isVisited[x+1][y]) {
			dfs(x+1, y);
		}
		if(y+1 < N && map[x][y+1] > rain && !isVisited[x][y+1]) {
			dfs(x, y+1);
		}
	}

}
