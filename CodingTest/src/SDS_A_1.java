import java.io.FileInputStream;
import java.util.*;

public class SDS_A_1 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();
			
			
			
			// Print the answer to standard output(screen).
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
}