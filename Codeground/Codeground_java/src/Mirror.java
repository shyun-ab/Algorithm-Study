//codeground 방속의 거울

import java.io.FileInputStream;
import java.util.*;

public class Mirror {

	static int Answer;
	static int[][] rooms;
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
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			N = sc.nextInt();
			rooms = new int[N+1][N+1];
			visited = new boolean[N+1][N+1];
			Arrays.fill(visited, false);
			x = 1;
			y = 1;
			
			for(int i = 1; i < N+1; i++){
				for(int j = 1; j < N+1; j++){
					rooms[i][j] = sc.nextInt();
					// '1' = /
					// '2' = \
				}
			}

			visit(0);
			
			
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
		int isMirror = rooms[y][x];
		
		if(isMirror == 0){
			move(curDir);
			visit(curDir);
		}
		else {
			visited[y][x] = true;
			//맵에서 이동하는 거 찾아보기!
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