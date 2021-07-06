package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_0041_kheap_event4 {

	static int T;
	static int Q;
	static int arry_size = 100001;
	
	static int[] arry;
	static int[] answer;
	static int[] idxtree;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0041_kheap_event.txt"));
//		System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\sample_input_kheap.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t =1 ; t < 2; t++) {
			st = new StringTokenizer(br.readLine());
			Q = Integer.parseInt(st.nextToken());
			
//			arry_size = Q;
			
			arry = new int[arry_size];
			answer = new int[arry_size];
			idxtree = new int[arry_size];
			int j = 0;
//			System.out.print("#" + t + " ");
			for (int q = 1; q < Q + 1; q ++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				
				if (op == 1) {
					int x = Integer.parseInt(st.nextToken());
					arry[x] ++;
					update(x, 1);
				} else {
					int k = Integer.parseInt(st.nextToken());
//					System.out.println("Prefix Sum for " + k + " is " + prefix_sum(k));
					System.out.println("Find K = " + findK(k));
//					answer[j++] = findK(k); 
//					System.out.print(findK(k) + " ");
				}
			}
			
//			System.out.println(" ");
			for (int i = 1; i < 11; i ++) {
//				if (arry[i] != 0)
				System.out.print(arry[i] + " ");
				
			}
			System.out.println(" ");
			for (int i = 1; i < 11; i ++) {
//				if (idxtree[i] != 0)
				System.out.print(idxtree[i] + " ");
			}
			
//			for (int i = 0; i < answer.length; i ++) {
//				System.out.println("#"+ t + " " + answer[i]);
//			}
		}
	}
	
	static void update(int x, int dif) {
		while (x < arry_size) {
			idxtree[x] += dif;
			x += (x & -x);
//			System.out.println("x = " + x);
		}
	}
	
	static long prefix_sum(int i) {
		long result = 0;
		while (i > 0) {
			result += idxtree[i];
			i -= (i & -i);
		}
		return result;
	}
	
	static int findK(int k) {
		int max = arry_size;
		
		int start = 1;
		int end = arry_size;
		int mid = end / 2;
		
		while (start < end) {
			long temp = prefix_sum(mid);
			
			 if (k < temp) {
				 start = mid;
			 } else if (k > temp) {
				 end = mid;
			 } else {
				 return mid;
			 }
		}
		
		 return -1;
	}	

}
