package programs;

import java.util.ArrayList;
import java.util.Arrays;

public class l_42840_answer {

	static int[][] spjs_answer;
	static int answer_cnt1;
	static int answer_cnt2;
	static int answer_cnt3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] answers = {1,3,2,4,2};
		
		
		solution(answers);
		
	}
	
	static int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};		
	
        int[] answer_cnt = new int[4];
        
		for (int i = 0; i < answers.length; i ++ ) {
			if (pattern1[i % pattern1.length] == answers[i]) answer_cnt[1] ++;
			if (pattern2[i % pattern2.length] == answers[i]) answer_cnt[2] ++;
			if (pattern3[i % pattern3.length] == answers[i]) answer_cnt[3] ++;
		}
		
		int MaxScore = Math.max(answer_cnt[1], Math.max(answer_cnt[2], answer_cnt[3]));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (MaxScore == answer_cnt[1]) list.add(1);
		if (MaxScore == answer_cnt[2]) list.add(2);
		if (MaxScore == answer_cnt[3]) list.add(3);
		
		
		int[] answer = new int[list.size()];
		
		
		for (int i = 0; i < answer.length; i ++ ) {
			answer[i] = list.get(i);
			System.out.println(answer[i]);
		}
		
		return answer;
		
	}

}
