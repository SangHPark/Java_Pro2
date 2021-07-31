package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class facility {

	static int T;
	static int N;
	static int K;
	static int[][] data;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] myarray;
		myarray = new int[5];
		
		myarray[1] = 5;
		myarray[2] = 8;
		myarray[3] = 17;
		myarray[4] = 20;
		
//		System.out.println(findPOS(0, myarray.length, 9, myarray));
		
		
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\facility.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t =1; t < T+1; t ++) {
			String input[] = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			
			data = new int[N+1][K+1];
			
			for (int i = 1; i < N+1; i++) {
				sc = new StringTokenizer(br.readLine());
				for (int j = 1; j < K+1; j++) {
					data[i][j] = Integer.parseInt(sc.nextToken());
				}
			}
			
//			for (int i = 1; i < N+1; i++) {
//				System.out.println("");
//				for (int j = 1; j < K+1; j++) {
//					System.out.print(data[i][j] + " ");
//				}
//			}	
			
//			for (int j = 1; j < K+1; j++) {
//				for (int i = 1; i < N+1; i++) {
//					int val = data[i][j];					
//					int[] t_array = data[i];
//
//					int pos = findPOS(0, myarray.length, val, t_array);
//					System.out.print(pos + " ");
//				}
//				System.out.println(" ");
//			}	
			
			
			for (int j = 1; j < K+1; j++) {
				System.out.println(" ");
				int datarow = 1;
//				
				for (int i = 2; i < N + 1; i ++) {
					int val = data[datarow][j];
					int[] t_array = data[i];
					int pos = findPOS(0, myarray.length, val, t_array);
					System.out.print(pos + " ");
					datarow ++;
				}
				
			}
		}
		
		
	}
	
	static int findPOS(int l, int r, int val, int[] target) {
		int ans = -1;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			if (mid >= target.length) {
				return target.length;
			}
			if (target[mid] < val) {
				l = mid + 1;
			} else {
				ans = mid;
				r = mid - 1;
			}
		}
		return ans;
	}

}


