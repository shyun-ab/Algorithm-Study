import java.util.*;
import java.io.*;

public class Microbe {
	static int Answer;
	static int N, time, K;
	static int[][] map;
	static boolean[][][] visit;
	
	static class Colony {
		int x, y, num, dir;
		
		public Colony(int x, int y, int num, int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
	}
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static ArrayList<Colony> list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[time][N][N];
			Answer = 0;
			list.clear();
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				list.add(new Colony(x, y, num, Integer.parseInt(st.nextToken())));
				map[x][y] = num;
			}
			
			Arrays.fill(map[0], -1);
			Arrays.fill(map[N-1], -1);
			for(int i = 0; i < N; i++) {
				map[i][0] = -1;
				map[i][N-1] = -1;
			}
			
			for(int i = 0; i < time; i++) {
				bfs(i);
			}
			
			for(int i = 0; i < list.size(); i++) {
				Answer += list.get(i).num;
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}

	public static void bfs(int cur) {
		int turn = 0;
		while(turn < list.size()) {
			Colony c = list.get(turn);
			int x = c.x;
			int y = c.y;
			int num = c.num;
			int dir = c.dir;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(map[nx][ny] == -1) {
				if(num / 2 == 0) {
					list.remove(turn);
					if(!visit[cur][x][y] && map[x][y] != -1) map[x][y] = 0;
				}
				else {
					c.x = nx;
					c.y = ny;
					c.num = num / 2;
					if(dir == 1) c.dir = 2;
					else if(dir == 2) c.dir = 1;
					else if(dir == 3) c.dir = 4;
					else c.dir = 3;
					if(!visit[cur][x][y] && map[x][y] != -1) map[x][y] = 0;
					visit[cur][nx][ny] = true;
					turn++;
				}
			}
			else if(visit[cur][nx][ny] && map[nx][ny] > 0) {
				if(map[nx][ny] > num) {
					for(int i = 0; i < list.size(); i++) {
						Colony cc = list.get(i);
						if(cc.x == nx && cc.y == ny) {
							cc.num += num;
							break;
						}
					}
					if(!visit[cur][x][y] && map[x][y] != -1) map[x][y] = 0;
					list.remove(turn);
				}
				else {
					for(int i = 0; i < list.size(); i++) {
						Colony cc = list.get(i);
						if(cc.x == nx && cc.y == ny) {
							c.num += cc.num;
							c.x = nx;
							c.y = ny;
							map[nx][ny] = num;
							list.remove(cc);
							break;
						}
					}
					if(!visit[cur][x][y] && map[x][y] != -1) map[x][y] = 0;
				}
			}
			else if(!visit[cur][nx][ny] && map[nx][ny] != -1) {
				visit[cur][nx][ny] = true;
				map[nx][ny] = num;
				c.x = nx;
				c.y = ny;
				if(!visit[cur][x][y] && map[x][y] != -1) map[x][y] = 0;
				turn++;
			}
		}
	}
}
