import java.util.*;

public class Main {

	static int N, sum, Answer;
	static int[] num;
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sum = sc.nextInt();
		num = new int[N];
		list = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		Answer = 0;
		
		list.add(num[0]);
		back(1, num[0]);
		list.remove(list.size()-1);
		back(1, 0);
		
		System.out.println(Answer);
	}
	
	static void back(int n, int tmpSum) {
		if(n == N && tmpSum == sum && !list.isEmpty()) Answer++;
		else if(n < N) {
			list.add(num[n]);
			back(n+1, tmpSum + num[n]);
			list.remove(list.size()-1);
			back(n+1, tmpSum);
		}
	}
}
