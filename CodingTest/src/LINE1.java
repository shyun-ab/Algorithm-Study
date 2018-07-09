import java.io.FileInputStream;
import java.util.*;

public class LINE1 {

	static int N, count;
	static double conymin, brownmin;
	static ArrayList<Stone> cony;
	static ArrayList<Stone> brown;
	static String C = "Cony";
	static String B = "Brown";

	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		int X, Y;
		String team;
		
		for(int test_case = 0; test_case < T; test_case++) {
			X = 0;
			Y = 0;
			team = null;
			count = 0;
			cony = new ArrayList<>();
			brown = new ArrayList<>();
			N = sc.nextInt();
			
			for(int i = 0; i < N; i++){
				X = sc.nextInt();
				Y = sc.nextInt();
				team = sc.next();
				
				if(team.length() == 4) cony.add(new Stone(X, Y, distance(X, Y)));
				else if(team.length() == 5) brown.add(new Stone(X, Y, distance(X, Y)));
				else System.out.println("team name error");
			}
			
			conymin = most(cony);
			brownmin = most(brown);
			
			if(conymin > brownmin){ //brown ½Â¸®
				for(int i = 0; i < brown.size(); i++){
					if(brown.get(i).Dis < conymin){
						count++;
					}
				}
				System.out.println("Brown "+count);
			}
			else { //cony ½Â¸®
				for(int i = 0; i < cony.size(); i++){
					if(cony.get(i).Dis < brownmin){
						count++;
					}
				}
				System.out.println("Cony "+count);
			}
		}
	}
	
	public static double distance(int x, int y){
		return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
	}
	
	public static double most(ArrayList<Stone> list){
		double temp = 0, min = 200.0;
		
		for(int i = 0; i < list.size(); i++){
			temp = list.get(i).Dis;
			if(min > temp) min = temp;
		}
		
		return min;
	}
}

class Stone {
	int X, Y;
	double Dis;
	public Stone(int X, int Y, double Dis){
		this.X = X;
		this.Y = Y;
		this.Dis = Dis;
	}
}