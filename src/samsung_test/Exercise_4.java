package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exercise_4 {

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
//			if (this.Left == target.Left ) {
//				return this.Right > target.Right? 1 : -1;
//			} else {
//				return this.Left > target.Left? 1 : -1;
//			}
			
//			return Math.max(this.Left, this.Right) > Math.max(target.Left, target.Right) ? 1 : -1;
			return this.Max - target.Max;

		}
		
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Exercise_temp.txt"));
		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\sample_input_exercise.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);	
			
			equipment[] A = new equipment[M]; //수열 
			equipment[] LIS = new equipment[M+1]; //LIS 저장 
			int[] P = new int[M+1]; //LIS 순번 저장
			
			
			for (int i = 0; i < M; i ++ ) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());				
				
//				htoolAL.add(new htool(L, R));
				A[i] = new equipment(L, R);
				LIS[i] = new equipment(0, 0);
//				P[i] = new equipment(0, 0);
				
			}
			
			LIS[M] = new equipment(0, 0);
//			P[M] = new equipment(0, 0);
//			Collections.sort(htoolAL);
			
			Arrays.sort(A);
			
//			Arrays.b

			int size = 0; 
			for (int i = 0; i < M; i++) { 
				if (LIS[size].Max < A[i].Max && LIS[size].Left < A[i].Left && LIS[size].Right < A[i].Right ) {
//					System.out.println("A.LEFT = " + A[i].Left + " " + " A.RIGHT = " + A[i].Right);
//					System.out.println("LIS.LEFT = " + LIS[size].Left + " " + " LIS.RIGHT = " + LIS[size].Right);					
					size++; 
					LIS[size].Left = A[i].Left; 
					LIS[size].Right = A[i].Right;
					LIS[size].Max = A[i].Max;
					P[i] = size;
					} 
				else if (LIS[size].Left == A[i].Left || LIS[size].Right == A[i].Right) { 
					continue; 
					} 
				else { 
					
					int idx, Lidx = 0, Ridx = 0;
//					if (LIS[size].Max > A[i].Max || LIS[size].Left > A[i].Left  || LIS[size].Right > A[i].Right) {
//						idx = lowerBoundMax2(LIS, 0, size, A[i].Max);
//						
//						LIS[idx].Left = A[i].Left;
//						LIS[idx].Right = A[i].Right;
//						LIS[idx].Max = A[i].Max;	
//						
//						P[i] = idx;
//					}
					
					
					
					if (LIS[size].Left > A[i].Left  ) {
						Lidx = lowerBound(LIS, 1, size, A[i].Left, "L");
					} else if (LIS[size].Right > A[i].Right ) {
						Ridx = lowerBound(LIS, 1, size, A[i].Right, "R");
					}
					
					idx = Math.max(Lidx,  Ridx);
					
					LIS[idx].Left = A[i].Left;
					LIS[idx].Right = A[i].Right;
					
					P[i] = idx;
					
					} 
				}
//			}
			
//			for (int i = 0; i < M; i ++) {
//				System.out.println("LIS.LEFT = " + LIS[i].Left + " LIS.RIGHT = " + LIS[i].Right + " P = " + P[i]);
//			}
			System.out.println("#" + t + " " + size);
//			System.out.println(max);

		}
			
			
		}

	static int lowerBoundMax2 (equipment[] L, int l, int r, int val) 
	{ 
		 int start = 0;
         int end = r;
         int mid;
         while(end>start)
         {
             mid = (start+end) /2;
             if(L[mid].Max < val)
             {
                 start = mid+1;
             }
             else
             {
                 end = mid;
             }
         }
         return end;
	}
	
	static int lowerBoundMax (equipment[] L, int l, int r, int val) 
	{ 
		int mid = 0; 
		int ans = 0;
		
		
		while(l <= r) 
		{ 
			mid = (l+r)/2; 
//			int tmp = (LorR.equals("L")) ? L[mid].Left : L[mid].Right;
			if (L[mid].Max < val) {
//			if (L[mid].Right < val) { 
				l = mid + 1; 
				} 
			else { 
				ans = mid; 
				r = mid - 1; 
				} 
			} 
		return ans; 
	}
	
	static int lowerBound (equipment[] L, int l, int r, int val, String LorR) 
	{ 
		int mid = 0; 
		int ans = 0;
		
		
		while(l <= r) 
		{ 
			mid = (l+r)/2; 
			int tmp = (LorR.equals("L")) ? L[mid].Left : L[mid].Right;
			if (tmp < val) {
//			if (L[mid].Right < val) { 
				l = mid + 1; 
				} 
			else { 
				ans = mid; 
				r = mid - 1; 
				} 
			} 
		return ans; 
	}
}
