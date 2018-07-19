import java.util.*;
 
public class SDS_A_3 {
 
    static int Answer;
 
    public static void main(String args[]) throws Exception {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int test_case = 0; test_case < T; test_case++) {
 
            Answer = 0;
            int N = sc.nextInt();
            int Start = sc.nextInt();
            int Jump = sc.nextInt();
            int K = sc.nextInt();
            int[] rest = new int[K];
             
            for(int i = 0; i < K; i++) {
                rest[i] = sc.nextInt();
                if(rest[i] - Start >= 0 && ((rest[i] - Start) % (Jump + 1)) == 0) Answer++;
            }
             
            System.out.println("#"+(test_case+1)+" "+Answer);
        }
    }
}