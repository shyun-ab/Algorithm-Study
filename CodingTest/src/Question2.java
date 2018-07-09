import java.io.FileInputStream;
import java.util.*;

/*
 * �Ǻ���ġ �迭�� 0�� 1�� �����ϸ�, ���� �Ǻ���ġ ���� �ٷ� ���� �� �Ǻ���ġ ���� ���� �ȴ�. 
 * ���� N�� �־�����, N���� ���� ��� ¦�� �Ǻ���ġ ���� ���� ���Ͽ���.
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