import java.io.FileInputStream;
import java.util.*;

/*
 * 피보나치 배열은 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다. 
 * 정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.
 */

public class Question2 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] f = new int[N];
		int sum = 0;
		int i = 1;
		
		Arrays.fill(f, -1);
		f[0] = 0;
		f[1] = 1;
		
		while(f[i] < N) {
			i++;
			f[i] = f[i-1] + f[i-2];
			if((f[i] < N) && (i%3 == 0)) sum += f[i];
		}
		
		Answer = sum;
		
		System.out.println(Answer);
	}
}