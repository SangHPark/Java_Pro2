package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exercise_Binary {

	static int T, N, M;
//	static ArrayList<htool> htoolAL;
	static equipment[] A;
	static int newstart = 0;;
	static boolean isReset = false;
	public static class equipment implements Comparable<equipment>{
		int Left;
		int Right;
		
		int Max;
		
		public equipment (int L, int R) {
			this.Left = L;
			this.Right = R;
			Max = Math.max(this.Left, this.Right);
			
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
			
			equipment[] A = new equipment[M]; //수열 
			equipment[] LIS = new equipment[M]; //LIS 저장 
			equipment[] path = new equipment[M]; // 경로를 역추적하기 위해
			 
			int[] B = new int[M]; //LIS 순번 저장
			int[] LISB = new int[M]; //LIS 순번 저장			
			
//			A[0] = new equipment(0, 0); 
//			LIS[0] = new equipment(0, 0); 
			for (int i = 0; i < M; i ++ ) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());				
				
//				htoolAL.add(new htool(L, R));
				A[i] = new equipment(L, R);
//				LIS[i] = new equipment(0, 0);
//				P[i] = new equipment(0, 0);
				
			}
			
			Arrays.sort(A);
			
			for (int i = 0; i < M; i++) {
				B[i] = A[i].Right;
			}
			
	        int size = 0; // LIS의 개수를 관리할 변수
	        LISB[size++] = B[0]; // 첫번째 숫자는 바로 반영
	        for (int i = 1; i < M; i++) {
	        	
	            if(LISB[size-1] < B[i]){
	                LISB[size++] = B[i]; // 제일 뒤에 붙이기
	            } 
	            else{
	                int temp = Arrays.binarySearch(LISB, 0, size, B[i]); // 삽입할 위치
	                if(temp < 0) temp = -temp -1;
	                LISB[temp] = B[i];
	                
	            }
	        }
//	        System.out.println("LISB : " + Arrays.toString(LISB));

	        System.out.println("#" + t + " " + size);
	        
		}
			
			
		}
	


	
}
