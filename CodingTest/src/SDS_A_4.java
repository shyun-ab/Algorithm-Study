import java.io.FileInputStream;
import java.util.*;

public class SDS_A_4 {

	static int Answer;
	static int[][] info;
	//static int[] score;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			int N = sc.nextInt();
			int min = sc.nextInt();
			int time = sc.nextInt();
			int num = 1;
			int score = 0;
			int subTime;
			info = new int[N][2];
			//score = new int[N];
			
			for(int i = 0; i < N; i++) {
				info[i][0] = sc.nextInt();
				info[i][1] = sc.nextInt();
				//score[i] = calculate(i+1, min, time);
				//if(score[i] > Answer) Answer = score[i];
			}
			
			subTime = time - min * num;
			while(subTime >= 0) {
				score += (10 - info[num-1][0]*info[num-1][1]);
				if(subTime - info[num-1][0])
				
				num++;
				subTime = time - min * num;
			}
			
			// Print the answer to standard output(screen).
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
	}
	/*
	public static int calculate(int num, int min, int time) {
		int temp = time;
		int[] Q = new int[3];
		int[] tmpTime = new int[3];
		
		if((time / min) < num) return 0;
		for(int i = 0; i < num; i++) {
			temp = temp - info[i][0];
		}
		if(temp >= min) return 0;
		
		temp = 10*num;
		Arrays.fill(Q, 0);
		Arrays.fill(tmpTime, 0);
		for(int i = 0; i < num; i++) {
			temp = temp - info[i][0]*info[i][1];
			if(info[i][1] == 3) {
				Q[2] += (info[i][0] - min);
				tmpTime[2] += min;
			}
			else if(info[i][1] == 2) {
				Q[1] += (info[i][0] - min);
				tmpTime[1] += min;
			}
			else {
				Q[0] += (info[i][0] - min);
				tmpTime[0] += min;
			}
		}
		
		time = time - min * num;
		for(int i = 3; i > 0; i--) {
			if(time > 0 && Q[i-1] != 0) {
				if(Q[i-1] - time >= 0) {
					tmpTime[i-1] += time;
					time = 0;
				}
				else {
					tmpTime[i-1] += Q[i-1];
					time -= Q[i-1];
				}
				
				temp = temp + tmpTime[i-1]*i;
			}
		}
		
		return temp;
	}
	*/
}