package practice;
import java.util.*;

public class Main {

	static int Answer;
	static int N;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Answer = 0;
		
		for(int i = 0; i < N; i++) {
			board = new int[N][N];
			attack(0, i);
			back(1);
		}
		
		System.out.println(Answer);
	}
	
	static void back(int num) {
		if(num == N) Answer++;
		else {
			for(int i = 0; i < N; i++) {
				if(board[num][i] == 0) {
					attack(num, i);
					back(num+1);
					remove(num, i);
				}
			}
		}
	}
	
	static void attack(int x, int y) {
		for(int i = 0; i < N; i++) {
			if(i > x) board[i][y]++;
			if(x+i < N && y-i >= 0) board[x+i][y-i]++;
			if(x+i < N && y+i < N) board[x+i][y+i]++;
		}
	}
	
	static void remove(int x, int y) {
		for(int i = 0; i < N; i++) {
			if(i > x) board[i][y]--;
			if(x+i < N && y-i >= 0) board[x+i][y-i]--;
			if(x+i < N && y+i < N) board[x+i][y+i]--;
		}
	}
}
