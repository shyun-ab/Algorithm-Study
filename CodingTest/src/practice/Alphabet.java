package practice;
import java.util.*;

public class Main {

	static int Answer;
	static char map[][];
	static int R, C, max;
	static Stack<Character> st;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		st = new Stack<Character>();
		
		for(int i = 0; i < R; i++) {
			String str = sc.next();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		Answer = 0;
		max = 0;
		dfs(0, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y) {
		Answer++;
		if(max < Answer) max = Answer;
		st.push(map[x][y]);
		if(x-1 >= 0 && !st.contains(map[x-1][y])) {
			dfs(x-1, y);
		}
		if(y-1 >= 0 && !st.contains(map[x][y-1])) {
			dfs(x, y-1);
		}
		if(x+1 < R && !st.contains(map[x+1][y])) {
			dfs(x+1, y);
		}
		if(y+1 < C && !st.contains(map[x][y+1])) {
			dfs(x, y+1);
		}
		Answer--;
		st.pop();
	}

}
