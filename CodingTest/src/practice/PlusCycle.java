package practice;
import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num, tmp_num, new_num = 0, temp;
		
		Answer = 0;
		num = sc.nextInt();
		tmp_num = num;

		while(true) {
			temp = tmp_num / 10 + tmp_num % 10;
			new_num = (tmp_num % 10)*10 + (temp % 10);
			Answer++;
			tmp_num = new_num;
			if(num == new_num) break;
		}
		
		System.out.println(Answer);
	}
}
