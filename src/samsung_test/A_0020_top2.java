package samsung_test;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;


// NOT Completed
public class A_0020_top2 {

	static int T, nT;
	static int[] tops;
	static int answer;
	static int maxH, maxI;
	static int find_receptions(int nthT) {
		int r_top = 0;

		if (nthT == 0) return 0;
		
		if (nthT == maxI) return 0;
		
		int j = nthT - 1;
		
		do {
			if (tops[j] > tops [nthT]) {
				return j+1;
			}
			
			j --;
		} while ( j >= 0);

		return r_top;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\A_0020_top.txt"));
			Scanner sc = new Scanner(System.in);
			
			T = sc.nextInt();
			
			for (int t = 1; t < T + 1; t ++ ) {
				answer = 0;

				
				nT = sc.nextInt();
				tops = new int[nT];
				
				for (int i = 0; i < nT ; i ++) {
					tops[i] = sc.nextInt();
				}
			
				Stack<Integer> mystack = new Stack<Integer>();
				
				for (int j = 0; j < nT; j ++) {
//					while (!mystack.isEmpty() && ) {
//						
//					}
//					answer += find_receptions(j);
				}
				
						
			
				System.out.println("#" + t + " " + answer % 1000000007);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
