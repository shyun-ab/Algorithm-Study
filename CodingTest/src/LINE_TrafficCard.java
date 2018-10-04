import java.util.Scanner;
import java.util.StringTokenizer;

public class LINE_TrafficCard {

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        int total = 20000;
        int current = 0;
        
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            if(distance >= 4 && distance <= 178) {
            	current = 720;
            	if(distance > 40) {
            		distance = distance - 40;
            		if(distance % 8 > 0) current += (distance / 8 + 1)*80;
            		else current += (distance / 8)*80;
            	}
            	
            	if(current > total) break;
            	else {
            		total = total - current;
            	}
            }
            else break;
        }
        
        System.out.println(total);
    }
}