import java.io.*;
import java.util.*;

class NHN_Coin {
	static int Answer;
	static int days;
	static int[] price;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		days = sc.nextInt();
		price = new int[days];
		Answer = 0;
		
		for(int i = 0; i < days; i++) {
			price[i] = sc.nextInt();
		}
		
		dfs(0, 0, 0);
		System.out.println(Answer);
	}
	
	public static void dfs(int coin, int date, int total) {
		if(date >= days) {
			if(total > Answer) Answer = total;
			return;
		}
		
		//������ ���
		dfs(coin+1, date+1, total - price[date]);
		//������ �� ���
		dfs(coin, date+1, total);
		//������ �ȸ�
		dfs(0, date+1, total + price[date]*coin);
	}
}