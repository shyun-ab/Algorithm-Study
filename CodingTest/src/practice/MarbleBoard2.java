package practice;

import java.util.*;

public class MarbleBoard2 {
	
	static int Answer;
	static char[][] board;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		board = new char[N][M];
		int redX=0, redY=0, blueX=0, blueY=0;
		
		for(int i = 0; i < N; i++) {
			String temp = sc.next();
			for(int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'R') {
					redX = i;
					redY = j;
				}
				else if(board[i][j] == 'B') {
					blueX = i;
					blueY = j;
				}
			}
		}
		
		dfs(1, redX, redY, blueX, blueY);
	}
	
	public static void dfs(int step, int redX, int redY, int blueX, int blueY) {
		if(step > 10) return;
		if(board[redX][redY] == 'O' && board[blueX][blueY] != 'O') {
			Answer = step;
			return;
		}
		
		
	}
}
