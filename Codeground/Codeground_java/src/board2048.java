import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class board2048 {

	static int Answer;
	static int N, MAX;
	static int[][] board;
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			MAX = 0;
			N = sc.nextInt();
			board = new int[N][N];
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					board[i][j] = sc.nextInt();
					if(MAX < board[i][j]) MAX = board[i][j];
				}
			}
			
			play(0, 0, board.clone());
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static void play(int dir, int count, int[][] temp){
		int index;
		if(count <= 5){
			if(dir == 1){ //left
				for(int i = 0; i < N; i++){
					for(int j = 1; j < N; j++){
						index = j - 1;
						if(temp[i][j] != 0){
							while(temp[i][index] == 0 && index > 0) index--;
							if(temp[i][index] == 0){
								temp[i][index] = temp[i][j];
								temp[i][j] = 0;
							}
							else if(temp[i][index] == temp[i][j]){
								temp[i][index] *= 2;
								temp[i][j] = 0;
								if(MAX < temp[i][index]) MAX = temp[i][index];
							}
							else {
								temp[i][index+1] = temp[i][j];
								temp[i][j] = 0;
							}
						}
					}
				}
			}
			else if(dir == 2){ //right
				for(int i = 0; i < N; i++){
					for(int j = N - 2; 0 <= j; j++){
						index = j + 1;
						if(temp[i][j] != 0){
							while(temp[i][index] == 0 && index < N-1) index++;
							if(temp[i][index] == 0){
								temp[i][index] = temp[i][j];
								temp[i][j] = 0;
							}
							else if(temp[i][index] == temp[i][j]){
								temp[i][index] *= 2;
								temp[i][j] = 0;
								if(MAX < temp[i][index]) MAX = temp[i][index];
							}
							else {
								temp[i][index-1] = temp[i][j];
								temp[i][j] = 0;
							}	
						}
					}
				}
			}
			else if(dir == 3){ //up
				for(int i = 1; i < N; i++){
					for(int j = 0; j < N; j++){
						index = i - 1;
						if(temp[i][j] != 0){
							while(temp[index][j] == 0 && index > 0) index--;
							if(temp[index][j] == 0){
								temp[index][j] = temp[i][j];
								temp[i][j] = 0;
							}
							else if(temp[index][j] == temp[i][j]){
								temp[index][j] *= 2;
								temp[i][j] = 0;
								if(MAX < temp[i][index]) MAX = temp[i][index];
							}
							else {
								temp[index+1][j] = temp[i][j];
								temp[i][j] = 0;
							}
						}
					}
				}
			}
			else if(dir == 4){ //down
				for(int i = N - 2; 0 <= i; i++){
					for(int j = 0; j < N; j++){
						index = i + 1;
						if(temp[i][j] != 0){
							while(temp[index][j] == 0 && index < N - 1) index++;
							if(temp[index][j] == 0){
								temp[index][j] = temp[i][j];
								temp[i][j] = 0;
							}
							else if(temp[index][j] == temp[i][j]){
								temp[index][j] *= 2;
								temp[i][j] = 0;
								if(MAX < temp[i][index]) MAX = temp[i][index];
							}
							else {
								temp[index-1][j] = temp[i][j];
								temp[i][j] = 0;
							}
						}
					}
				}
			}
			else {
				for(int i = 0; i < 4; i++){
					play(i, count++, temp.clone());
				}
			}
			
			for(int i = 0; i < 4; i++){
				play(i, count++, temp.clone());
			}
		}
		else {
			Answer = MAX;
		}
	}
}
