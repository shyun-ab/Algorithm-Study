import java.io.FileInputStream;
import java.util.*;

public class SDS_A_2 {

	static int Answer;
	static int[] x = {-1, 0, 1};
	static int[] y = {-1, 0, 1};
	static int N;
	static int[][] map;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		boolean[][] check;
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			N = sc.nextInt();
			map = new int[N][N];
			check = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] > 0) check[i][j] = true;
					else check[i][j] = false;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(check[i][j]) {
						if(check(i, j)) Answer++;
					}
				}
			}
			
			// Print the answer to standard output(screen).
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	
	public static boolean check(int i, int j) {
		int curX, curY;
		boolean yellow = false, green = false, blue = false;
		for(int k = 0; k < 3; k++) {
			for(int l = 0; l < 3; l++) {
				curX = i + x[k];
				curY = j + y[l];
				if(curX >= 0 && curX < N && curY >= 0 && curY < N) {
					switch(map[curX][curY]) {
					case 0:
						return false;
					case 1:
						blue = true;
						break;
					case 2:
						green = true;
						break;
					case 3:
						yellow = true;
						break;
					}
				}
			}
		}
		if(blue && green && yellow) return true;
		else return false;
	}
}