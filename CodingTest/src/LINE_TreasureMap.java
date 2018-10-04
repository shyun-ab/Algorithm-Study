import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LINE_TreasureMap {
    static String[][] map;
    static int[][] path;
    static int[] answer;
    static int n;
	
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            int x = 0, y = 0;
            
            map = new String[n][n];
            path = new int[n*n][4];
            answer = new int[2];
            
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().split(" ");
            }
            for(int i = 0; i < n*n; i++) {
            	Arrays.fill(path[i], -1);
            }
            
            move(0, 0, 3);
            
            System.out.println(answer[0]+" "+answer[1]);
        }
    }
    
    public static void move(int x, int y, int beforeDir) {
    	int newDir, num, last = 0;
    	int number = y*n + x;
    	if(map[y][x].charAt(0) == 'L') newDir = 0;
    	else if(map[y][x].charAt(0) == 'F') newDir = 1;
    	else if(map[y][x].charAt(0) == 'R') newDir = 2;
    	else newDir = 3;
    	
    	if(beforeDir == 0) {
    		newDir -= 1;
    		if(newDir < 0) newDir = 3;
    	}
    	else if(beforeDir == 2) {
    		newDir += 1;
    		if(newDir > 3) newDir = 0;
    	}
    	else if(beforeDir == 3) {
    		if(newDir == 0) newDir = 2;
    		else if(newDir == 1) newDir = 3;
    		else if(newDir == 2) newDir = 0;
    		else newDir = 1;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		if(path[number][i] == newDir) {
    			answer[0] = x;
    			answer[1] = y;
    			return;
    		}
    		if(path[number][i] != -1) last++; 
    	}
    	
    	path[number][last] = newDir;
    	num = map[y][x].charAt(1) - '0';
    	
    	if(newDir == 0) move(x-num, y, newDir);
    	else if(newDir == 1) move(x, y-num, newDir);
    	else if(newDir == 2) move(x+num, y, newDir);
    	else move(x, y+num, newDir);
    }
}