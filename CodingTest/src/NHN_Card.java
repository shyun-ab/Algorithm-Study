import java.io.*;
import java.util.*;

class NHN_Card {
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int P = sc.nextInt();
		list = new ArrayList<Integer>();
		
		for(int i = 0; i < C; i++) {
			list.add(i+1);
		}
		
		for(int i = 0; i < P; i++) {
			int N = sc.nextInt();
			mix(C, N);
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void mix(int C, int N) {
		int check = C - 2*N;
		
		for(int i = 0; i < check; i++) {
			list.add(i, list.remove(N+i));
		}
		
		if(check > 2*N) {
			mix(check, N);
		}
	}
}