package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exercise_2 {

	static int T, N, M;
	static ArrayList<htool> htoolAL;
	static int newstart = 0;;
	static boolean isReset = false;
	public static class htool implements Comparable<htool>{
		int Left;
		int Right;
		
		public htool (int L, int R) {
			this.Left = L;
			this.Right = R;
		}
		@Override
		public int compareTo(htool target) {
			// TODO Auto-generated method stub
//			return this.Left > target.Left? 1 : -1;
			if (this.Left == target.Left ) {
				return this.Right > target.Right? 1 : -1;
			} else {
				return this.Left > target.Left? 1 : -1;
			}

		}
		
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Exercise_2.txt"));
		System.setIn (new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\sample_input_exercise.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);	
			
			htoolAL = new ArrayList<htool>();
			
			for (int i = 0; i < M; i ++ ) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());				
				
				htoolAL.add(new htool(L, R));
				
			}
			
			Collections.sort(htoolAL);
			
//			for (int i = 0; i < htoolAL.size(); i ++) {
//				System.out.println("Left = " + htoolAL.get(i).Left + " Right = " + htoolAL.get(i).Right);
//			}
			int i;
			int sorted_cnt;
			int max = 0;
			
			for (i = 0; i < M; i ++) {
				i = newstart;
				isReset = true;

				sorted_cnt = getSortRCnt(i);
				
				if (max < sorted_cnt ) {
					max = sorted_cnt;
				}
			}
			
			
			System.out.println("#" + t + " " + max);
			newstart = 0;
			
		}
	}

	public static int getSortRCnt(int start) {
		int hsize = htoolAL.size();
		
		int sorted_cnt = 0;
		int prevL = 0, currL = 0;
		int prevR = 0, currR = 0;
		int max = 0;
		boolean keepgrowing = true;
		
		for (int i = start; i < hsize; i ++) {
			int previ = (i - 1 == -1) ? i : i - 1;
			newstart = i;
			if (i == 0) {
				prevL = 0;
				prevR = 0;
				isReset = false;
			} else {
				if (isReset) {
					prevL = 0;
					prevR = 0;
					isReset = false;
				} else {
					prevL = htoolAL.get(previ).Left;
					prevR = htoolAL.get(previ).Right;
					isReset = false;
				}
			}
			
			currL = htoolAL.get(i).Left;
			currR = htoolAL.get(i).Right;
			
			if (prevL > currL || prevR > currR) {
				if (keepgrowing) {
					newstart = i;
					keepgrowing = false;
					continue;
				}
			} else {
				if (currR > max) {
					sorted_cnt ++;
					max = currR;
					if (keepgrowing) {
						if (i == (hsize -1)) {
							newstart = i;
						}
					}
				} else {
					continue;
				}
			}
			
			
			
//			System.out.println("Left = " + htoolAL.get(i).Left + " Next Right = " + prevR);
		}
		return sorted_cnt;
	}
}
