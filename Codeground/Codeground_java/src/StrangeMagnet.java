import java.io.FileInputStream;
import java.util.*;

public class StrangeMagnet {

	static int Answer;
	static int K;
	static int[][] magnet;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			magnet = new int[4][8];
			
			K = sc.nextInt();
			
			
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}