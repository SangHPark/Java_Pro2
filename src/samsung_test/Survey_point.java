 package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Survey_point {
	static int T;
	static int N;
	static int X;
	static int Y;

	static LinkedList<Integer> llist; 
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
//		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Survey_point.txt"));
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\SWPRO Test\\Survey\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			String input[] = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			X = Integer.parseInt(input[1]);
			Y = Integer.parseInt(input[2]);
			
			
			String input2[] = br.readLine().split(" ");
			
			long result = 0;

			llist = new LinkedList<Integer>();
			
			int s_cnt = 0;
			for (int i = 0; i < N; i ++) {
				int point = Integer.parseInt(input2[i]);
				
				if (point >= 0) {
					s_cnt ++ ;
					llist.add(point);
				} else {
					s_cnt -- ;
					
					int k = -1;
					for (int j : llist) {
						k ++;
						if (j == Math.abs(point)) {
							llist.remove(k);
							break;
						}
							
					}
				}
				
				//���� �ԷµǾ� �� ���ڱ��� ���Ե� ������ Y�ǹ���϶�, Y�ǹ���� ���� ����� X����� ��ġ�� ���� �����´�
				if (s_cnt > 0 && s_cnt % Y== 0) {
					Collections.sort(llist);
					int pos = (s_cnt / Y) * X - 1;
					
					result = result + llist.get(pos);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}