import java.util.*;

/*
 * 정수 배열과 타겟 숫자가 주어지면, 합이 타겟값이 되는 두 원소의 인덱스를 찾으시오.
 */

public class Question5 {

	public static void main(String args[]) throws Exception	{
		
		int[] arr = {2, 5, 6, 1, 10};
		int target = 8;
		boolean solution = false;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			int comp = target - arr[i];
			if(map.containsKey(comp)) {
				System.out.println(map.get(comp) + " " + i);
				solution = true;
			}
			map.put(arr[i], i);
		}
		
		if(solution == false) System.out.println("No solution");
	}
}