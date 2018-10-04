package practice;
import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A[] = new int[N];
		int B[] = new int[N];
		
		Answer = 0;
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i = 0; i < N; i++) {
			Answer += A[N-i-1]*B[i];
		}
		
		System.out.println(Answer);
	}
}
