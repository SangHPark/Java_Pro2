package programs;

import java.util.Arrays;

public class l_42576 {
	static boolean[] isUsed;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
		
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
//		String[] participant = {"mislav", "stanko", "mislav", "ana"};
//		String[] completion = {"stanko", "ana", "mislav"};		
		
		System.out.println(solution(participant, completion));

	}
	
	static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		isUsed = new boolean[completion.length];
		
        Arrays.fill(isUsed, false);
        
        for (int i = 0; i < participant.length; i ++) {
//        	isUsed[i] = true;    
            
            if (!find(i, participant, completion)) {
            	return participant[i];
            } else {
            	continue;
            }
        }
        
		return answer;
	}
	
	static boolean find(int i, String[] p, String[] c) {
        for (int j = 0; j < c.length; j ++) {
            if (p[i].equals(c[j]) && !isUsed[j]) { 
            	isUsed[j] = true;
                return true;
            };
        }
        return false;
	}

}
