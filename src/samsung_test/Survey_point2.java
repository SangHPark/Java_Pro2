 package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Survey_point2 {
	static int T;
	static int N;
	static int X;
	static int Y;

	static LinkedList<Integer> llist; 
	static int[] array;
	static long[] partial_sum;
	
	static int max_point = 7; //1000000000;
	
	
	public static long set_partial_sum(int cnt, int diff) {
		if ( cnt == 1 ) {
			partial_sum[cnt] = diff;
			return diff;
		}
		partial_sum[cnt] = partial_sum[cnt - 1] + diff;
		
		return partial_sum[cnt];
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Survey_point.txt"));
//		System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\SWPRO Test\\Survey\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < 2 ; t++) {
			String input[] = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			X = Integer.parseInt(input[1]);
			Y = Integer.parseInt(input[2]);
			
			
			String input2[] = br.readLine().split(" ");
			
			long result = 0;

			llist = new LinkedList<Integer>();
			
//			int base = 1;
//			while (base < 1000000000) {
//				base *= 2;
//			}
//			
//			array = new int[base * 2];
			
			array = new int [max_point+1];
			partial_sum = new long [300001];
			
			
			int s_cnt = 0;
			for (int i = 0; i < N; i ++) {
				int point = Integer.parseInt(input2[i]);
				
				if (point >= 0) {
					s_cnt ++ ;
//					llist.add(point);
					array[point] ++;
					set_partial_sum(s_cnt, 1);
					
				} else {
					s_cnt -- ;
					array[Math.abs(point)] --;
					set_partial_sum(s_cnt, -1);
//					int k = -1;
//					for (int j : llist) {
//						k ++;
//						if (j == Math.abs(point)) {
//							llist.remove(k);
//							break;
//						}
//							
//					}
				}
				
				if (s_cnt > 0 && s_cnt % Y== 0) {
					System.out.println("HIA");
					int pos = (s_cnt / Y) * X - 1;
					
					result = result + array[pos];
				}
				//지금 입력되어 들어간 수자까지 포함된 갯수가 Y의배수일때, Y의배수에 가장 가까운 X배수에 위치한 값을 가져온다
//				if (s_cnt > 0 && s_cnt % Y== 0) {
//					Collections.sort(llist);
//					int pos = (s_cnt / Y) * X - 1;
//					
//					result = result + llist.get(pos);
//				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
