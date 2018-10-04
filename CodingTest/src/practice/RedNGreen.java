package practice;
import java.util.*;

public class Main {

	static int RGBarea, RBarea;
	static int N;
	static char[][] RGB;
	static boolean[][] isVisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		RGB = new char[N][N];
		RGBarea = 0;
		RBarea = 0;
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				RGB[i][j] = str.charAt(j);
			}
		}
		
		isVisited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					RGBcheck(i, j);
					RGBarea++;
				}
			}
		}
		
		isVisited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					RGBcheck(i, j);
					RBarea++;
				}
			}
		}
		
		System.out.println(RGBarea+" "+RBarea);
	}
	
	static void RGBcheck(int startX, int startY) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startX);
		q.add(startY);
		isVisited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int x = q.remove();
			int y = q.remove();
			
			if(x-1 >= 0 && !isVisited[x-1][y] && RGB[x][y] == RGB[x-1][y]) {
				isVisited[x-1][y] = true;
				q.add(x-1);
				q.add(y);
			}
			if(x+1 < N && !isVisited[x+1][y] && RGB[x][y] == RGB[x+1][y]) {
				isVisited[x+1][y] = true;
				q.add(x+1);
				q.add(y);
			}
			if(y-1 >= 0 && !isVisited[x][y-1] && RGB[x][y] == RGB[x][y-1]) {
				isVisited[x][y-1] = true;
				q.add(x);
				q.add(y-1);
			}
			if(y+1 < N && !isVisited[x][y+1] && RGB[x][y] == RGB[x][y+1]) {
				isVisited[x][y+1] = true;
				q.add(x);
				q.add(y+1);
			}
			
			if(RGB[x][y] == 'G') RGB[x][y] = 'R';
		}
	}
}
