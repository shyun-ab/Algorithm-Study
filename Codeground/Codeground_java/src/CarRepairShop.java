import java.io.FileInputStream;
import java.util.*;

public class CarRepairShop {

	static int Answer, time;
	static int N, M, K, A, B;
	static int[] timeN;
	static int[] timeM;
	static int[][] reach;
	static int[][] use;
	static Queue<Integer> q1;
	static Queue<Integer> q2;
	static boolean[] useN;
	static boolean[] useM;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int total;
			Answer = 0;
			q1 = new LinkedList<Integer>();
			q2 = new LinkedList<Integer>();
			
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			
			timeN = new int[N];
			timeM = new int[M];
			reach = new int[K][3];
			use = new int[K][2];
			useN = new boolean[N];
			Arrays.fill(useN, false);
			useM = new boolean[M];
			Arrays.fill(useM, false);
			
			for(int i = 0; i < N; i++) {
				timeN[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				timeM[i] = sc.nextInt();
			}
			for(int i = 0; i < K; i++) {
				reach[i][0] = sc.nextInt();
			}
			
			total = K;
			time = reach[0][0];
			
			while(total != 0) {
				int cur;
				for(int i = 0; i < K; i++) {
					if(time == reach[i][0]) q1.add(i);
					if(time == reach[i][2] && time != 0) {
						useM[use[i][1]] = false;
						total--;
					}
				}
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < K; j++) {
						if(use[j][0] == i && time == reach[j][1] && time != 0) {
							useN[i] = false;
							q2.add(j);
						}
					}
					if(!useN[i] && !q1.isEmpty()) {
						cur = q1.poll();
						use[cur][0] = i;
						useN[i] = true;
						reach[cur][1] = time+timeN[i];
					}
				}
				for(int i = 0; i < M; i++) {
					if(!useM[i] && !q2.isEmpty()) {
						cur = q2.poll();
						use[cur][1] = i;
						useM[i] = true;
						reach[cur][2] = time+timeM[i];
					}
				}
				
				time++;
			}
			
			for(int i = 0; i < K; i++) {
				if(use[i][0] == A-1 && use[i][1] == B-1) {
					Answer += (i + 1);
				}
			}
			if(Answer == 0) Answer = -1;
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
}