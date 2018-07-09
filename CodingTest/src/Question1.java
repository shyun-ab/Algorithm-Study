import java.io.FileInputStream;
import java.util.*;

/*
 * 정수 배열(int array)가 주어지면 가장 큰 이어지는 원소들의 합을 구하시오. 단, 시간복잡도는 O(n).
 */

public class Question1 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			Answer = 0;
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int maxSum = arr[0];
			int currentSum = arr[0];
			for(int i = 1; i < arr.length; i++) {
				currentSum = Math.max(currentSum + arr[i], arr[i]);
				maxSum = Math.max(currentSum, maxSum);
			}
			
			Answer = maxSum;
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}