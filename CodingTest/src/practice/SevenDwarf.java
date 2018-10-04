package practice;
import java.util.*;

public class Main {
	
	static int[] h;
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		list = new ArrayList<Integer>();
		h = new int[9];
		for(int i = 0; i < 9; i++) {
			h[i] = sc.nextInt();
		}
		
		Arrays.sort(h);
		for(int i = 0; i < 2; i++) {
			list.clear();
			list.add(h[i]);
			if(back(h[i], 1, i) == 1) break;
		}
		
		for(int i = 0; i < 7; i++) {
			System.out.println(list.get(i));
		}
	}
	
	static int back(int sum, int num, int last) {
		if(sum == 100 && num == 7) return 1;
		else if(sum >= 100) return 0;
		else if(num >= 7) return 0;
		
		for(int i = 0; i < 9; i++) {
			if(i > last) {
				list.add(h[i]);
				if(back(sum + h[i], num + 1, i) == 1) return 1;
				list.remove(list.size()-1);
			}
		}
		return 0;
	}
}
