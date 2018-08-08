import java.util.*;

public class Main {
	
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		int[] num = new int[300000];
		
		Answer = 0;
		
		q.add(N);
		
		while(!q.isEmpty()) {
			int now = q.remove();
			
			if(now == K) break;
			if(now-1 >= 0 && num[now-1] == 0) {
				num[now-1] = num[now] + 1;
				q.add(now-1);
			}
			if(now+1 <= 100000 && num[now+1] == 0) {
				num[now+1] = num[now] + 1;
				q.add(now+1);
			}
			if(now*2 <= 200000 && num[now*2] == 0) {
				num[now*2] = num[now] + 1;
				q.add(now*2);
			}
		}
		
		Answer = num[K];
		System.out.println(Answer);
	}
}
