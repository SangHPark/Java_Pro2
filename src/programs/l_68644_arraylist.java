package programs;

import java.util.ArrayList;
import java.util.Arrays;

public class l_68644_arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int[] numbers = {2,1,3,4,1};
		
		for (int i = 0; i < numbers.length; i ++ ) {
			for (int j = i + 1; j < numbers.length; j ++ ) {
				int a = numbers[i] + numbers[j];
				if (list.indexOf(a) < 0) {
					list.add(a);
				}
			}
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i ++ ) {
			answer[i] = list.get(i);
		}
		
		Arrays.sort(answer);
		 
		for (int i = 0; i < answer.length; i ++ ) {
			System.out.println(answer[i]);
		}
	}
}
