import java.util.*;
import java.io.*;

public class LunchTime {
	static int Answer;
	static int N;
	static int[][] map;
	static int[][] stair;
	static Stack<Integer> list1;
	static Stack<Integer> list2;
	static LinkedList<Integer> people;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		list1 = new Stack<Integer>();
		list2 = new Stack<Integer>();
		people = new LinkedList<Integer>();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			Answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			stair = new int[2][2];
			Arrays.fill(stair[0], -1);
			Arrays.fill(stair[1], -1);
			list1.clear();
			list2.clear();
			people.clear();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						people.add(i);
						people.add(j);
					}
					else if(map[i][j] >= 2 && stair[0][0] == -1) {
						stair[0][0] = i;
						stair[0][1] = j;
					}
					else if(map[i][j] >= 2 && stair[0][0] != -1) {
						stair[1][0] = i;
						stair[1][1] = j;
					}
				}
			}
			
			dfs();
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
	
	public static void dfs() {
		if(people.isEmpty()) {
			cal();
			return;
		}
		
		int x = people.remove();
		int y = people.remove();
		
		//first stair
		list1.push(x);
		list1.push(y);
		dfs();
		list1.pop();
		list1.pop();
		
		//second stair
		list2.push(x);
		list2.push(y);
		dfs();
		list2.pop();
		list2.pop();
		
		people.add(x);
		people.add(y);
	}
	
	public static void cal() {
		int time = 0;
		int[][] stair1 = new int[list1.size() / 2][2];
		int[][] stair2 = new int[list2.size() / 2][2];
		int num = stair1.length + stair2.length;
		int st1_num = 0, st2_num = 0;
		
		for(int i = 0; i < stair1.length; i++) {
			stair1[i][0] = Math.abs(list1.get(2*i) - stair[0][0]) + Math.abs(list1.get(2*i+1) - stair[0][1]);
		}
		
		Arrays.sort(stair1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0; i < stair2.length; i++) {
			stair2[i][0] = Math.abs(list2.get(2*i) - stair[1][0]) + Math.abs(list2.get(2*i+1) - stair[1][1]);
		}
		Arrays.sort(stair2, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		while(num > 0) {
			time++;
			for(int i = 0; i < stair1.length; i++) {
				if(time < stair1[i][0]) break;
				if(time == stair1[i][0] && st1_num < 3) {
					st1_num++;
					stair1[i][1] = time + map[stair[0][0]][stair[0][1]];
				}
				else if(time == stair1[i][0] && st1_num == 3) {
					stair1[i][0] = time + 1;
				}
				if(time == stair1[i][1]) {
					st1_num--;
					num--;
				}
			}
			for(int i = 0; i < stair2.length; i++) {
				if(time < stair2[i][0]) break;
				if(time == stair2[i][0] && st2_num < 3) {
					st2_num++;
					stair2[i][1] = time + map[stair[1][0]][stair[1][1]];
				}
				else if(time == stair2[i][0] && st2_num == 3) {
					stair2[i][0] = time + 1;
				}
				if(time == stair2[i][1]) {
					st2_num--;
					num--;
				}
			}
		}
		
		Answer = Math.min(Answer, time+1);
	}
}
