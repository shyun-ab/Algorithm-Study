import java.io.*;
import java.util.*;

class NHN_NeonSign {
	static String[][] neon;
	static int N;
	static int numbering;
	static List<String> list;
	
	public static void main(String[] args) throws Exception {
		try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			int W = Integer.parseInt(temp[1]);
			neon = new String[N][N];
			list = new ArrayList<String>();
			
			for(int i = 0; i < N; i++) {
				neon[i] = br.readLine().split(" ");
			}
			
			numbering = 0;
			for(int i = 0; i < N-1; i++) {
				int tempW = W % (4*(N-i) - 4);
				if(W > 0) move(i, tempW, 1);
				else if(W < 0) move(i, tempW, -1);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					neon[i][j] = list.get(Integer.parseInt(neon[i][j]));
					System.out.print(neon[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static void move(int num, int cnt, int dir) {
		
		
		for(int i = num; i < N-num; i++) {
			list.add(neon[num][i]);
			if(dir > 0) {
				neon[num][i] = Integer.toString(Math.abs(numbering - cnt));
				numbering++;
			}
		}
		for(int i = num+1; i < N-num; i++) {
			list.add(neon[i][N-1-num]);
			if(dir > 0) {
				neon[i][N-1-num] = Integer.toString(Math.abs(numbering - cnt));
				numbering++;
			}
		}
		for(int i = N-num-2; i >= num; i--) {
			list.add(neon[N-1-num][i]);
			if(dir > 0) {
				neon[N-1-num][i] = Integer.toString(Math.abs(numbering - cnt));
				numbering++;
			}
		}
		for(int i = N-num-2; i > num; i--) {
			list.add(neon[i][num]);
			if(dir > 0) {
				neon[i][num] = Integer.toString(Math.abs(numbering - cnt));
				numbering++;
			}
		}
	}
}