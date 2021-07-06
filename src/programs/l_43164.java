package programs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class l_43164 {

	static boolean[] isUsed;
	static String[][] tickets = {
//			{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
			{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ICN"}
//			{"ICN", "SFO"}, {"SFO", "ICN"}
		};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream(""));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			
		solution(tickets);
	}
	
	static String[] solution(String[][] tickets) {
		
		String from = "ICN";
		String nextstop;
		ArrayList<String> answer_list;
		
		
//		Arrays.sort(tickets[0]);
		
//		answers[0] = "ICN";
		isUsed = new boolean[tickets.length];
		
		
		answer_list = new ArrayList<String>();
		answer_list.add(from);
		
		int k = 1;
		for (int i = 0; i < tickets.length; i ++) {
			nextstop = findnextstop(from, tickets);
			answer_list.add(nextstop);
//			answers[k++] = nextstop;
			from = nextstop;
		}
		
//		System.out.println("Answer = " + answers);
		int answer_size = answer_list.size();
		String[] answers = new String [answer_size];
		for (int i = 0; i < answer_size; i++) {
			answers[i] = answer_list.get(i);
			System.out.println(answers[i]);
		}
		
		return answers;
	}

	static String findnextstop(String from, String[][] tickets) {
//		System.out.println(tickets.length);
		
		ArrayList<destination> myalist;
		
		myalist = new ArrayList<>();
		
		for (int i = 0; i < tickets.length; i ++) {
			if(tickets[i][0] == from && !isUsed[i]) {
//				System.out.println(tickets[i][1]);

				myalist.add(new destination(i, tickets[i][1] ));

			}
		}
		
		if (myalist.size() > 0) {
			Collections.sort(myalist);
			
			isUsed[myalist.get(0).idx] = true;
			return myalist.get(0).name;			
		}
		
		return null;
		

		
	}
	
	static class destination implements Comparable<destination> {
		int idx;
		String name;
		int sortable_name;
		
		destination(int i, String N) {
			String temp = "" ;
			
			this.idx = i;
			this.name = N;
			
			for (int k =0; k < name.length(); k ++) {
				temp += String.valueOf((int) name.charAt(k));

			}
			
//			sortable_name = temp;
			
			this.sortable_name = Integer.parseInt(temp);
		}

		@Override
		public int compareTo(destination target) {
			// TODO Auto-generated method stub
			return this.sortable_name > target.sortable_name ? 1 : -1;
		}
	}

}
