package programs;

import java.util.Arrays;

public class l_42576_answer {

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
		Arrays.sort(participant);
		Arrays.sort(completion);
		int i = 0;
		for (i = 0; i < completion.length; i ++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		
		return participant[i];
	}
	
}
