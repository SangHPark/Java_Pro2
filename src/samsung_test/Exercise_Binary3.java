package samsung_test;

// Wow! It works
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise_Binary3 {

	static int T, N, M;

	static equipment[] A;
	
	public static class equipment implements Comparable<equipment>{
		int Left;
		int Right;
		
		public equipment (int L, int R) {
			this.Left = L;
			this.Right = R;
		}
		@Override
		public int compareTo(equipment target) {
			// TODO Auto-generated method stub
			if (this.Left == target.Left ) {
				return target.Right - this.Right; //Key Point
			} else {
				return this.Left - target.Left;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Exercise_temp_6.txt"));
		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\sample_input_exercise.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);	
			
			equipment[] A = new equipment[M]; //수열 
 
			int[] B = new int[M]; //Right Equipment
			int[] LISB = new int[M]; //LIS 순번 저장			
			
			for (int i = 0; i < M; i ++ ) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());				
				
				A[i] = new equipment(L, R);
				
			}
			
			Arrays.sort(A);
			
			for (int i = 0; i < M; i++) {
				B[i] = A[i].Right;
			}
			
	        int size = 0; // LIS의 개수를 관리할 변수
	        LISB[size++] = B[0]; // 첫번째 숫자는 바로 반영
	        for (int i = 1; i < M; i++) {
	        	if (A[i-1].Left == A[i].Left ) {
	                int temp = Arrays.binarySearch(LISB, 0, size, B[i]); // 삽입할 위치
	                if(temp < 0) temp = -temp -1;
	                LISB[temp] = B[i];
	        		continue;
	        	}
	            if(LISB[size-1] < B[i]){
	                LISB[size++] = B[i]; // 제일 뒤에 붙이기
	            } 
	            else{
	                int temp = Arrays.binarySearch(LISB, 0, size, B[i]); // 삽입할 위치
	                if(temp < 0) temp = -temp -1;
	                LISB[temp] = B[i];
	            }
	        }

	        System.out.println("#" + t + " " + size);
	        
		}
	}
}
