package samsung_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P_0041_kheap_event {

	static int T;
	static int Q;
	static ArrayList<participant> plist;
	static ArrayList<Integer> alist;
	
	static class participant implements Comparable<participant>{
		int idx;
		int ticket_no;
		
		public participant (int idx, int t_no) {
			this.idx = idx;
			this.ticket_no = t_no;
		}

		@Override
		public int compareTo(participant target) {
			// TODO Auto-generated method stub
			return this.ticket_no > target.ticket_no ? 1 : -1;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0041_kheap_event.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		

		
		for (int t = 1; t < T+1; t++) {
			Q = sc.nextInt();
			plist = new ArrayList<participant>();
			alist = new ArrayList<Integer>();
			
			for (int i = 1; i < Q + 1; i ++) {
				int no = sc.nextInt();
				int t_no = sc.nextInt();
				
				if (no == 1) {
					plist.add(new participant(no, t_no));
				}
				
				if (no == 2) {
					alist.add(t_no);
				}
			}			
		
			Collections.sort(plist);
		  
			System.out.print("#" + t + " ");
			for (int i = 0; i < Q - plist.size(); i ++) {
//				System.out.println(" i = " + i + " annoce = " + alist.get(i) + " winner = " + plist.get(alist.get(i)-1).ticket_no);
				System.out.print(plist.get(alist.get(i)-1).ticket_no + " ");
			}
			
			System.out.println("");
		}

	}

}

