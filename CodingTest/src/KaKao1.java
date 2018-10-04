//카카오 2019 신입 공채 - 익명채팅방
import java.util.*;

public class KaKao1 {

	public static void main(String args[]) throws Exception	{
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234" , "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] output = solution(input.clone());
		
		System.out.println(output);
	}
	
	public static String[] solution(String[] record) {
        String[] answer = {};
        String[] temp = {};
        HashMap<String, String> idMap = new HashMap<String, String>();
        
        int num = record.length;
        int count = 0, count2 = 0;
        
        for(int i = 0; i < num; i++) {
        	temp = record[i].split(" ");
        	if(!temp[0].equals("Change")) count++;
        	if(!idMap.containsKey(temp[1])) idMap.put(temp[1], temp[2]);
        	else if(temp.length > 2) idMap.replace(temp[1], temp[2]);
        }
        
        answer = new String[count];
        
        for(int i = 0; i < num; i++) {
        	temp = record[i].split(" ");
        	if(temp[0].equals("Enter")) {
        		answer[count2] = idMap.get(temp[1]) + "님이 들어왔습니다.";
        		count2++;
        	}
        	else if(temp[0].equals("Leave")) {
        		answer[count2] = idMap.get(temp[1]) + "님이 나갔습니다.";
        		count2++;
        	}
        }
        
        return answer;
    }
}