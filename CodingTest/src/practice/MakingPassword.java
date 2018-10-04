package practice;
import java.util.*;

public class Main {
	
	static int L, C;
	static char[] alpha;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		alpha = new char[C];
		
		for(int i = 0; i < C; i++) {
			alpha[i] = sc.next().charAt(0);
		}

		Arrays.sort(alpha);
		for(int i = 0; i <= C - L; i++) {
			int c = 0, v = 0;
			if(checkVowel(alpha[i]) == 1) v++;
			else c++;
			back(""+alpha[i], i, c, v);
		}
	}
	
	static void back(String pwd, int lastIndex, int c, int v) {
		if(pwd.length() == L && c >= 2 && v >= 1) {
			System.out.println(pwd);
			return;
		}
		else if(pwd.length() == L) return;
		else {
			for(int i = lastIndex + 1; i < C; i++) {
				if(checkVowel(alpha[i]) == 1) {
					v++;
					back(pwd + alpha[i], i, c, v);
					v--;
				}
				else {
					c++;
					back(pwd + alpha[i], i, c, v);
					c--;
				}
			}
		}
	}
	
	static int checkVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u') return 1;
		else return 0;
	}
}
