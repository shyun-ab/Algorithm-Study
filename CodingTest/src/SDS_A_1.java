import java.io.FileInputStream;
import java.util.*;

public class SDS_A_1 {

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {

			int min = Integer.MAX_VALUE;
			int temp;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] src = new int[4][2];
			int[][] dst = new int[4][2]; 
			src[0][0] = sc.nextInt();
			src[0][1] = sc.nextInt();
			dst[0][0] = sc.nextInt();
			dst[0][1] = sc.nextInt();
			
			src[1][0] = src[0][0] + N;
			src[1][1] = src[0][1];
			src[2][0] = src[0][0];
			src[2][1] = src[0][1] + M;
			src[3][0] = src[0][0] + N;
			src[3][1] = src[0][1] + M;
			
			dst[1][0] = dst[0][0] + N;
			dst[1][1] = dst[0][1];
			dst[2][0] = dst[0][0];
			dst[2][1] = dst[0][1] + M;
			dst[3][0] = dst[0][0] + N;
			dst[3][1] = dst[0][1] + M;
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					temp = Math.abs(src[i][0] - dst[j][0]) + Math.abs(src[i][1] - dst[j][1]);
					if(temp < min) min = temp;
				}
			}
			
			// Print the answer to standard output(screen).
			System.out.println("#"+(test_case+1)+" "+min);
		}
	}
}