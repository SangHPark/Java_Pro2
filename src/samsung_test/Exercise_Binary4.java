package samsung_test;

//Per UnKoo's Proposal
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exercise_Binary4 {

	static int T, N, M;
	
	
	public static class equipment implements Comparable<equipment>{
		int Left;
		int Right;
		
//		int Max;
		
		public equipment (int L, int R) {
			this.Left = L;
			this.Right = R;
//			Max = Math.max(this.Left, this.Right);
			
		}
		@Override
		public int compareTo(equipment target) {
			// TODO Auto-generated method stub
//			return this.Left > target.Left? 1 : -1;
			if (this.Left == target.Left ) {
				return this.Right - target.Right;
			} else {
				return this.Left - target.Left;
			}
//			}
			
//			return Math.max(this.Left, this.Right) > Math.max(target.Left, target.Right) ? 1 : -1;
//			return this.Max - target.Max;
			
//			if (this.Max == target.Max ) {
//			return this.Left - target.Left;
//		} else {
//			return this.Max - target.Max;
//		}			

		}
		
		
	}
	

	 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Exercise_temp_5.txt"));
		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\sample_input_exercise.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);	
			
// Left 기준 변수			
			equipment[] EQA = new equipment[M]; //수열 
			int[] B = new int[M]; //LIS 순번 저장
			int[] LISB = new int[M]; //LIS 순번 저장			
			

// Right 기준 변수			
			equipment[] EQB = new equipment[M]; //수열 
			int[] A = new int[M]; //LIS 순번 저장
			int[] LISA = new int[M]; //LIS 순번 저장			
			
			for (int i = 0; i < M; i ++ ) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());				
				
				EQA[i] = new equipment(L, R);
				EQB[i] = new equipment(R, L);				
				
			}
			
			Arrays.sort(EQA);
			Arrays.sort(EQB);
			
			for (int i = 0; i < M; i++) {
				B[i] = EQA[i].Right;
				A[i] = EQB[i].Right;				
			}
			
// 왼쪽 기준으로 먼저 정렬된 기준으로 오른쪽 기준으로 순서를 찾아가는 로직			
	        int size = 0; // LIS의 개수를 관리할 변수
	        
	        LISB[size++] = B[0]; // 첫번째 숫자는 바로 반영
	        for (int i = 1; i < M; i++) {
	        	if (EQA[i-1].Left == EQA[i].Left ) {
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
	        
	        
// 오른쪽 기준으로 먼저 정렬된 기준으로 왼쪽 기준으로 순서를 찾아가는 로직
	        size = 0; // LIS의 개수를 관리할 변수
	        
	        LISA[size++] = A[0]; // 첫번째 숫자는 바로 반영
	        for (int i = 1; i < M; i++) {
	        	if (EQB[i-1].Left == EQB[i].Left ) {
	                int temp = Arrays.binarySearch(LISA, 0, size, A[i]); // 삽입할 위치
	                if(temp < 0) temp = -temp -1;
	                LISA[temp] = A[i];	        		
	        		continue;
	        	}
	            if(LISA[size-1] < A[i]){
	                LISA[size++] = A[i]; // 제일 뒤에 붙이기
	            } 
	            else{
	                int temp = Arrays.binarySearch(LISA, 0, size, A[i]); // 삽입할 위치
	                if(temp < 0) temp = -temp -1;
	                LISA[temp] = A[i];
	            }
	        }

	        System.out.println("#" + t + " " + size);	        
	        
		}
			
			
		}
	


	
}
