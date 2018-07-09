import java.io.FileInputStream;
import java.util.*;

public class LINE2 {
	
	static int width, height;
	static int color;
	static int number;
	static int alpha;
	static String str;
	static String[] tmp;

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		str = sc.nextLine();
		tmp = str.split("\\s");
		
		width = Integer.parseInt(tmp[2]);
		height = Integer.parseInt(tmp[4]);
		System.out.println(width);
		System.out.println(height);
		
		str = sc.nextLine();
		tmp = str.split("\\s");
		tmp = tmp[2].split("x");
		
		color = Integer.parseInt(tmp[1], 16);
		System.out.println(color);
		
		str = sc.nextLine();
		tmp = str.split("\\s");
		
		number = Integer.parseInt(tmp[3]);
		System.out.println(number);
		str = sc.nextLine();
		
		for(int i = 0; i < number; i++){
			str = sc.nextLine();
			tmp = str.split("\\s");
			if(tmp[3].length() == 3) alpha = 1;
			else if(tmp[3].length() == 2) alpha = 0;
			else System.out.println("alpha error");
			
			System.out.println(Integer.parseInt(tmp[1])+"x"+Integer.parseInt(tmp[2])+", "+Integer.parseInt(tmp[4])+", "+alpha);
		}
	}
}
