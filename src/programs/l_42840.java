package programs;

import java.util.regex.Pattern;

public class l_42840 {

	static int[][] spjs_answer;
	public static void main(String[] args) {
		
		
	}
	
	public int[] solution(int[] answers) {
		// TODO Auto-generated method stub
		
//		int[][] spjs_answer = new int[4][101];
//		int[][] spjs_patterns = new int[4][101];
//		
//		
//        for (int i = 0; i < pattern3.length ; i ++) {
//            for (int j = 0; j < 100 / pattern3.length + 1; j ++ ) {
//            	int newidx = i + j * (pattern3.length);
//            	if (newidx < 100) {
//                	spj3[newidx + 1] = pattern3[i];
//            	}
//            }
//        }		
	
		
        int[] spj1 = new int[100];
        int[] spj2 = new int[100];
        int[] spj3 = new int[101];
        
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        

        
        
        
        
        
        
        
        for (int i = 0; i < pattern1.length; i ++) {
            for (int j = 0; j < 100 / pattern1.length + 1 ; j ++ ) {
            	int newidx = i + j * (pattern1.length);
            	if (newidx < 100) {
            		spj1[newidx] = pattern1[i];
            	}
            }
        }
        
        for (int i = 0; i < 100; i ++) {
        	System.out.println("i = " + i +  " " + spj1[i]);
        }
        
        for (int i = 0; i < pattern2.length; i ++) {
            for (int j = 0; j < 100 / pattern2.length + 1; j ++ ) {
            	int newidx = i + j * (pattern2.length);
            	if (newidx < 100) {
                	spj2[newidx] = pattern2[i];
            	}
            }
        }
        
        for (int i = 0; i < 100; i ++) {
        	System.out.println("i = " + i +  " " + spj2[i]);
        }
        
        for (int i = 0; i < pattern3.length ; i ++) {
            for (int j = 0; j < 100 / pattern3.length + 1; j ++ ) {
            	int newidx = i + j * (pattern3.length);
            	if (newidx < 100) {
                	spj3[newidx + 1] = pattern3[i];
            	}
            }
        }
        
        for (int i = 1; i <= 100; i ++) {
        	System.out.println("i = " + i +  " " + spj3[i]);
        }
        
        
        int answer_cnt = answers.length;
        int correct_cnt = 0;
        
        for (int i = 0; i < answer_cnt; i++) {
           	if (answers[i] == pattern1[i]) {
           		correct_cnt ++;
           	}
        }
        
        
        return new int[1];
	}

}
