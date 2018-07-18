import java.util.*;

/*
 * ���� �迭�� Ÿ�� ���ڰ� �־�����, ���� Ÿ�ٰ��� �Ǵ� �� ������ �ε����� ã���ÿ�.
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