package practice;
import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] time = new int[N];
		int[] total = new int[N];
		
		for(int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time);
		
		total[0] = time[0];
		Answer = total[0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				total[i] = time[i] + total[i-1];
			}
			Answer += total[i];
		}

		System.out.println(Answer);
	}

}
