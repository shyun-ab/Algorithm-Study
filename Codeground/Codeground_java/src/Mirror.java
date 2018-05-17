//codeground 방속의 거울

import java.io.FileInputStream;
import java.util.*;

public class Mirror {

	static int Answer;
	static char[][] rooms;
	static boolean[][] visited;
	static int x, y, N;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		String str;
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			N = sc.nextInt();
			rooms = new char[N+1][N+1];
			visited = new boolean[N+1][N+1];
			x = 1;
			y = 1;
			
			for(int i = 1; i < N+1; i++){
				str = sc.next();
				for(int j = 1; j < N+1; j++){
					rooms[i][j] = str.charAt(j-1);
					visited[i][j] = false;
					// '1' = /
					// '2' = \
				}
			}

			visit(0);
			
			for(int i = 1; i < N+1; i++){
				for(int j = 1; j < N+1; j++){
					if(visited[i][j]) Answer++;
				}
			}
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static void visit(int curDir){
		// '1' = /
		// '2' = \
		if(x == 0 || y == 0 || x > N || y > N){
			return;
		}
		char isMirror = rooms[y][x];
		
		if(isMirror == '0'){
			move(curDir);
			visit(curDir);
		}
		else {
			visited[y][x] = true;
			if(isMirror == '1'){
				switch(curDir) {
				case 0:
					y--;
					curDir = 3;
					break;
				case 1:
					x--;
					curDir = 2;
					break;
				case 2:
					y++;
					curDir = 1;
					break;
				case 3:
					x++;
					curDir = 0;
					break;
				}
			}
			else if(isMirror == '2'){
				switch(curDir) {
				case 0:
					y++;
					curDir = 1;
					break;
				case 1:
					x++;
					curDir = 0;
					break;
				case 2:
					y--;
					curDir = 3;
					break;
				case 3:
					x--;
					curDir = 2;
					break;
				}
			}
			else { System.out.println("error"); }
			
			visit(curDir);
		}
	}
	
	public static void move(int curDir){
		if(curDir == 0) x++;
		else if(curDir == 1) y++;
		else if(curDir == 2) x--;
		else if(curDir == 3) y--;
		else System.out.println("error");
	}
}