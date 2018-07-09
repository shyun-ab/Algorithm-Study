
public class LINE {


	static boolean preSucceed = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int N = 100;
		boolean[] click = new boolean[N+1];
		
		for(int k = 1; k <= N; k++){
			click[k] = false;
		}
		
		int n_click = 0;

		while (n_click < 90) {
			i++;
			for (int j = 1; j <= N; j++) {
				if (click[j] == false) {
					boolean succeed = clickSucceed();
				    click[j] = succeed;
				    if (succeed == true) {
				    	n_click++;
				    }
				}
		    }
		}
		
		System.out.println(i);
	}
	
	public static boolean clickSucceed() {
	    if (preSucceed == false) {
	        preSucceed = true;
	    } else {
	        preSucceed = false;
	    }

	    return preSucceed;
	}

}
