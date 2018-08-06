import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String sRoom[] = new String[N];
		int[][] room = new int[N+2][N+2];
		int count = 0, width = 0, height = 0;
		
		Arrays.fill(room[0], 0);
		for(int i = 0; i < N+2; i++) {
			room[i][0] = 0;
		}
		
		for(int i = 0; i < N; i++) {
			sRoom[i] = sc.next();
			for(int j = 0; j < N; j++) {
				if(sRoom[i].charAt(j) == '.') room[i+1][j+1] = 1;
				else room[i+1][j+1] = 0;
			}
		}
		
		for(int i = 0; i < N+2; i++) {
			for(int j = 0; j < N+2; j++) {
				if(room[i][j] == 1) count++;
				else {
					if(count >= 2) width++;
					count = 0;
				}
			}
			count = 0;
		}
		
		for(int j = 0; j < N+2; j++) {
			for(int i = 0; i < N+2; i++) {
				if(room[i][j] == 1) count++;
				else {
					if(count >= 2) height++;
					count = 0;
				}
			}
			count = 0;
		}
		
		System.out.println(width + " " + height);
	}

}
