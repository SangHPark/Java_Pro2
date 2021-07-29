package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
public class BoxPattern_1 {
	static int T, N, K;
	static int[] myArray;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Box_Pattern.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T + 1; t ++) {
			String[] Input = br.readLine().split(" ");
			
			N = Integer.parseInt(Input[0]);
			K = Integer.parseInt(Input[1]);
			
			myArray = new int[N];
			
			Input = br.readLine().split(" ");
			
			for (int i = 0; i < N; i ++) {
				myArray[i] = Integer.parseInt(Input[i]);
			}
			
//			System.out.println(" ");
//			for (int i = 0; i < N; i ++) {
//				System.out.print(myArray[i] + " ");
//			}
			
			
			int s = 0, e = 1;
			int length = 0;
			int[] ans = new int[N];
			int max = 0; 
			int min = 987654321;

			while (s<=N && s <= e) {
				if (K >= Math.abs(max - min)) {
					e ++;
					length++;
					ans[length] ++;
					if (myArray[e] > max) {
						max = myArray[e];
					}
					
					if (myArray[e] < min) {
						min = myArray[e];
					}					
				} else if (K < (max - min)) {
					s ++;
					length=0;
				} 
			}
			
			System.out.println("#" + t + " " + length);
		}

		
		
	}
}
