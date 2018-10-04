//카카오 2019 신입 공채 - 실패율
import java.util.*;

public class KaKao2 {

	public static void main(String args[]) throws Exception	{
		int[] input = {4, 4, 4, 4, 4};
		int[] output = solution(4, input);
		
		System.out.println(output);
	}
	
	public static int[] solution(int N, int[] stages) {
        double[][] table = new double[2][N];
        double[] cal = new double[N];
        int[] answer = new int[N];
        
        for(int i = 0; i < stages.length; i++)
        {
        	int tmp = stages[i];
        	if(tmp <= N) table[0][tmp-1]++;
        	for(int j = 0; j < tmp; j++) {
        		if(j < N) table[1][j]++;
        	}
        }
        
        for(int i = 0; i < N; i++) {
        	if(table[1][i] != 0) {
        		table[1][i] = (table[0][i] / table[1][i]);
        	}
        	cal[i] = table[1][i];
        	table[0][i] = i+1;
        }
        
        Arrays.sort(cal);
        
        for(int i = N-1; i >= 0; i--) {
        	for(int j = 0; j < N; j++) {
        		if(cal[i] == table[1][j]) {
        			answer[N-i-1] = (int) table[0][j];
        			table[1][j] = -1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}