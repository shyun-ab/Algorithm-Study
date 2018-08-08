import java.util.*;

public class Main {

	static int Answer;
	static int map[][];
	static boolean[][] isVisit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w, h;
		
		w = sc.nextInt();
		h = sc.nextInt();
		while(!(w == 0 && h == 0)) {
			map = new int[h+2][w+2];
			isVisit = new boolean[h+2][w+2];
			Answer = 0;
			for(int i = 0; i <= h+1; i++) {
				Arrays.fill(map[i], 0);
				Arrays.fill(isVisit[i], false);
			}
			
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) {
					if(map[i][j] != 0 && !isVisit[i][j]) {
						dfs(i, j);
						Answer++;
					}
				}
			}
			
			System.out.println(Answer);
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}
	
	static void dfs(int Y, int X) {
		isVisit[Y][X] = true;
		if(map[Y+1][X] == 1 && !isVisit[Y+1][X]) {
			dfs(Y+1, X);
		}
		if(map[Y-1][X] == 1 && !isVisit[Y-1][X]) {
			dfs(Y-1, X);
		}
		if(map[Y][X+1] == 1 && !isVisit[Y][X+1]) {
			dfs(Y, X+1);
		}
		if(map[Y][X-1] == 1 && !isVisit[Y][X-1]) {
			dfs(Y, X-1);
		}
		//´ë°¢¼±
		if(map[Y-1][X-1] == 1 && !isVisit[Y-1][X-1]) {
			dfs(Y-1, X-1);
		}
		if(map[Y+1][X+1] == 1 && !isVisit[Y+1][X+1]) {
			dfs(Y+1, X+1);
		}
		if(map[Y-1][X+1] == 1 && !isVisit[Y-1][X+1]) {
			dfs(Y-1, X+1);
		}
		if(map[Y+1][X-1] == 1 && !isVisit[Y+1][X-1]) {
			dfs(Y+1, X-1);
		}
	}

}
