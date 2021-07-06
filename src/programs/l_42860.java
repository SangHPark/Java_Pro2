package programs;

import java.util.Scanner;

public class l_42860 {

	static int solution (String name) {
		int answer = 0;
		int distance = 0;
		int A_cnt = 0, A_effect = 0;
		
		int A_idx = Character.getNumericValue('A');
		int Z_idx = Character.getNumericValue('Z');
				
		for (int i = 0; i < name.length(); i ++) {
			char onechar = name.charAt(i);
			int pos = Character.getNumericValue(onechar);
			
			if (onechar == 'A') {A_cnt ++;}
			
			if (pos - A_idx <= 13) {
				distance += (pos - A_idx);
			} else {
				distance ++;
				distance += (Z_idx - pos); 
			}
			
			
//			System.out.println("Ch = " + onechar + " " + distance);
		}
		
		if (A_cnt == name.length()) {answer = 0;}
		else 
			answer = distance + name.length() - 1 - A_cnt;
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name =  sc.next();
		
		
		System.out.println(name);
		
		System.out.println("Answer = " + solution(name));
		
	}

}
