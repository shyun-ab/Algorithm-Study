import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N, min;
		int[][] array;
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			N = sc.nextInt();
			array = new int[N][2];
			for(int i = 0; i < N; i++) {
				array[i][0] = sc.nextInt();
				array[i][1] = sc.nextInt();
			}

			Comparator<int[]> comp = new Comparator<int[]>() {
				@Override
				public int compare(int[] arg0, int[] arg1) {
					return arg0[0] - arg1[0];
				}
			};
			
			Answer = N;
			Arrays.sort(array, comp);
			min = array[0][1];
			for(int i = 0; i < N; i++) {
				if(array[i][1] > min) Answer--;
				if(array[i][1] < min) min = array[i][1];
			}
			
			System.out.println(Answer);
		}
	}
}
