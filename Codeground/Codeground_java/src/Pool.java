import java.io.FileInputStream;
import java.util.*;

public class Pool {

	static int Answer, temp;
	static int[] cost;
	static int[] plan;
	static int dayMax;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			cost = new int[4];
			plan = new int[12];
			temp = 0;
			
			for(int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			dayMax = cost[1] / cost[0];
			
			for(int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			
			Answer = cost[3];
			
			dfs(0);
			
			// Print the answer to standard output(screen).
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	
	public static void dfs(int month) {
		if(month >= 12) {
			Answer = Math.min(Answer, temp);
			return;
		}
		
		if(plan[month] == 0) dfs(month+1);
		else {
			temp += cost[2];
			dfs(month+3);
			temp -= cost[2];
			
			if(plan[month] > dayMax) {
				temp += cost[1];
				dfs(month+1);
				temp -= cost[1];
			}
			else {
				temp += (plan[month] * cost[0]);
				dfs(month+1);
				temp -= (plan[month] * cost[0]);
			}
		}
		
	}
}