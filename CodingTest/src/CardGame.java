import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int R = 0, G = 0, B = 0, Y = 0;
		int[] num = new int[9];
		int[] max;
		char[][] cards = new char[2][5];
		
		for(int i = 0; i < 5; i++) {
			cards[0][i] = sc.next().charAt(0);
			cards[1][i] = sc.next().charAt(0);
			num[(cards[1][i] - '0') - 1]++;
			switch(cards[0][i]) {
			case 'R':
				R++;
				break;
			case 'G':
				G++;
				break;
			case 'B':
				B++;
				break;
			case 'Y':
				Y++;
				break;
			}
		}
		
		max = num.clone();
		Arrays.sort(max);
		
		if(R == 5 || G == 5 || B == 5 || Y == 5) {
			char[] tmp = cards[1].clone();
			boolean check = true;
			Arrays.sort(tmp);
			for(int i = 1; i < 5; i++) {
				if(tmp[i] != tmp[i-1] + 1) {
					check = false;
					break;
				}
			}
			if(check) {
				Answer = 900 + tmp[4] - '0';
			}
			else {
				Answer = 600 + tmp[4] - '0';
			}
		}
		else if(max[8] == 4) {
			int maxNum = 0;
			for(int i = 0; i < 9; i++) {
				if(num[i] == 4) maxNum = i + 1;
			}
			Answer = 800 + maxNum;
		}
		else if(max[8] == 3 && max[7] == 2) {
			int first = 0, second = 0;
			for(int i = 0; i < 9; i++) {
				if(num[i] == 3) first = i + 1;
				if(num[i] == 2) second = i + 1;
			}
			Answer = 700 + first*10 + second;
		}
		else if(max[8] == 3) {
			int maxNum = 0;
			for(int i = 0; i < 9; i++) {
				if(num[i] == 3) maxNum = i + 1;
			}
			Answer = 400 + maxNum;
		}
		else if(max[8] == 2 && max[7] == 2) {
			int big = 0, small = 0;
			for(int i = 0; i < 9; i++) {
				if(num[i] == 2) {
					if(small == 0) small = i + 1;
					else big = i + 1;
				}
			}
			Answer = 300 + big*10 + small;
		}
		else if(max[8] == 2) {
			int maxNum = 0;
			for(int i = 0; i < 9; i++) {
				if(num[i] == 2) maxNum = i + 1;
			}
			Answer = 200 + maxNum;
		}
		else {
			char[] tmp = cards[1].clone();
			boolean check = true;
			Arrays.sort(tmp);
			for(int i = 1; i < 5; i++) {
				if(tmp[i] != tmp[i-1] + 1) {
					check = false;
					break;
				}
			}
			if(check) Answer = 500 + tmp[4] - '0';
			else Answer = 100 + tmp[4] - '0';
		}
		
		System.out.println(Answer);
	}

}
