package practice;
import java.util.*;

public class Main {

	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		do {
			if(isPrime(N) && isPalindrom(N)) {
				Answer = N;
				break;
			}
			N++;
		} while(true);
		
		System.out.println(Answer);
	}
	
	static boolean isPrime(int num) {
		if(num == 1) return false;
		if(num == 2) return true;
		if(num % 2 == 0) return false;
		
		for(int i = 3; i <= Math.sqrt(num); i+=2) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	static boolean isPalindrom(int num) {
		int tmp, num2 = 0;
		
		tmp = num;
		while(tmp > 0) {
			num2 = num2 * 10;
			num2 += tmp % 10;
			tmp = tmp / 10;
		}
		
		return (num == num2);
	}

}
