package practice;
import java.util.*;

public class Area {

	static int num;
	static int matrix[][];
	static boolean[][] isVisit;
	static int N, M, K;
	static int area;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int leftX, leftY, rightX, rightY;
		int[] Area;
		
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		matrix = new int[M][N];
		List<Integer> list = new ArrayList<Integer>();
		
		num = 0;
		for(int i = 0; i < M; i++) {
			Arrays.fill(matrix[i], 0);
		}
		
		for(int i = 0; i < K; i++) {
			leftX = sc.nextInt();
			leftY = sc.nextInt();
			rightX = sc.nextInt();
			rightY = sc.nextInt();
			for(int x = leftX; x < rightX; x++) {
				for(int y = leftY; y < rightY; y++) {
					matrix[y][x] = 1;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(matrix[i][j] == 0) {
					area = 0;
					num++;
					dfs(j, i, num);
					list.add(area);
				}
			}
		}

		Area = new int[num];
		for(int i = 0; i < list.size(); i++) {
			Area[i] = list.get(i);
		}
		Arrays.sort(Area);
		System.out.println(num);
		for(int i = 0; i < num; i++) {
			System.out.print(Area[i]+" ");
		}
	}
	
	static void dfs(int X, int Y, int num) {
		matrix[Y][X] = -1;
		area++;
		if(Y+1 < M && matrix[Y+1][X] == 0) {
			dfs(X, Y+1, num);
		}
		if(X+1 < N && matrix[Y][X+1] == 0) {
			dfs(X+1, Y, num);
		}
		if(Y-1 >= 0 && matrix[Y-1][X] == 0) {
			dfs(X, Y-1, num);
		}
		if(X-1 >= 0 && matrix[Y][X-1] == 0) {
			dfs(X-1, Y, num);
		}
	}

}
