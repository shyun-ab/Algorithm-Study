import java.util.*;

public class Main {
	
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q;
		int[][] board;
		int l, nowX, nowY, finalX, finalY;
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			l = sc.nextInt();
			nowX = sc.nextInt();
			nowY = sc.nextInt();
			finalX = sc.nextInt();
			finalY = sc.nextInt();
			
			q = new LinkedList<Integer>();
			board = new int[l][l];
			
			q.add(nowX);
			q.add(nowY);
			
			while(!q.isEmpty()) {
				int x = q.remove();
				int y = q.remove();
				if(x == finalX && y == finalY) break;
				
				if(x-2 >= 0 && y+1 < l && board[x-2][y+1] == 0) {
					board[x-2][y+1] = board[x][y] + 1;
					q.add(x-2);
					q.add(y+1);
				}
				if(x-1 >= 0 && y+2 < l && board[x-1][y+2] == 0) {
					board[x-1][y+2] = board[x][y] + 1;
					q.add(x-1);
					q.add(y+2);
				}
				if(x+1 < l && y+2 < l && board[x+1][y+2] == 0) {
					board[x+1][y+2] = board[x][y] + 1;
					q.add(x+1);
					q.add(y+2);
				}
				if(x+2 < l && y+1 < l && board[x+2][y+1] == 0) {
					board[x+2][y+1] = board[x][y] + 1;
					q.add(x+2);
					q.add(y+1);
				}
				if(x+2 < l && y-1 >= 0 && board[x+2][y-1] == 0) {
					board[x+2][y-1] = board[x][y] + 1;
					q.add(x+2);
					q.add(y-1);
				}
				if(x+1 < l && y-2 >= 0 && board[x+1][y-2] == 0) {
					board[x+1][y-2] = board[x][y] + 1;
					q.add(x+1);
					q.add(y-2);
				}
				if(x-1 >= 0 && y-2 >= 0 && board[x-1][y-2] == 0) {
					board[x-1][y-2] = board[x][y] + 1;
					q.add(x-1);
					q.add(y-2);
				}
				if(x-2 >= 0 && y-1 >= 0 && board[x-2][y-1] == 0) {
					board[x-2][y-1] = board[x][y] + 1;
					q.add(x-2);
					q.add(y-1);
				}
			}
			
			Answer = board[finalX][finalY];
			System.out.println(Answer);
		}
		
	}
}
