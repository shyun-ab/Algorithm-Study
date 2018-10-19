import java.io.*;
import java.util.*;

public class StemCell {
	
	static int Answer;
	static int N, M, K, base;
	static int[][] map;
	static boolean[][][] visit;
	
	static class Pair {
		int x, y, status, energy, stime, ntime, actime;
		
		public Pair(int x, int y, int status, int energy, int stime, int ntime, int actime) {
			this.x = x;
			this.y = y;
			this.status = status;
			this.energy = energy;
			this.stime = stime;
			this.ntime = ntime;
			this.actime = actime;
		}
	}
	
	static LinkedList<Pair> list;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int t = Integer.parseInt(br.readLine());
		list = new LinkedList<Pair>();
		
		for(int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list.clear();
			base = K/2;
			
			map = new int[N+K][M+K];
			visit = new boolean[K+1][N+K][M+K];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i+base][j+base] = Integer.parseInt(st.nextToken());
					if(map[i+base][j+base] != 0) list.add(new Pair(i+base, j+base, 1, map[i+base][j+base], 0, 0, 0));
				}
			}
			
			bfs();
			Answer = 0;
			
			for(int i = 0; i < N+K; i++) {
				for(int j = 0; j < M+K; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) Answer++;
				}
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
	
	public static void bfs() {
		while(!list.isEmpty()) {
			Pair p = list.remove();
			int x = p.x;
			int y = p.y;
			int status = p.status;
			int energy = p.energy;
			int stime = p.stime;
			int ntime = p.ntime;
			int actime = p.actime;
			
			ntime++;
			
			if(ntime <= K) {
				if(status == 1) {
					if(ntime == stime+energy) {
						list.add(new Pair(x, y, 2, energy, stime, ntime, ntime));
					} else { 
						list.add(new Pair(x, y, 1, energy, stime, ntime, 0));
					}
				}
					
				if(status == 2) {
					if(actime + 1 <= ntime && ntime < actime + energy) {
						list.add(new Pair(x, y, 2, energy, stime, ntime, actime));
					}
					
					if(actime + 1 == ntime) {
						for(int i = 0; i < 4; i++) {
							int nx = x + dx[i];
							int ny = y + dy[i];
							
							if(map[nx][ny] != 0) {
								if(visit[ntime][nx][ny]) {
									if(map[nx][ny] < energy) {
										map[nx][ny] = energy;
										for(int j = list.size()-1; j >= 0; j--) {
											Pair pp = list.get(j);
											if(pp.x == nx && pp.y == ny && pp.stime == ntime) {
												list.remove(j);
												break;
											}
										}
										list.add(new Pair(nx, ny, 1, energy, ntime, ntime, 0));
									}
								}
							} else {
								map[nx][ny] = energy;
								visit[ntime][nx][ny] = true;
								list.add(new Pair(nx, ny, 1, energy, ntime, ntime, 0));
							}
						}
					}
					
					if(actime + energy == ntime) {
						map[x][y] = -1;
					}
				}
			}
		}
	}
}