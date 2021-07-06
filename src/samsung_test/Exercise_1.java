package samsung_test;

import java.io.*;
import java.util.*;

////////
// You can add and modify values and implementations if needed.
// Professional ���������� ����� �ڵ带 '������ ���ǿ� �°�' ���� �ۼ��ϼž� �մϴ�.
// ������� ǥ�� ������� ����Ͽ��� �մϴ�.
// ��, �������� PC���� �۾��Ͻ� �� �ʿ��� System.setIn ������ �Ʒ� ���õ� ���� �̿��Ͻø� �˴ϴ�.
// �Է��� BufferedReader, StringTokenizer �� ����ϴ� ���� �����մϴ�. 
// ��) �� �ٿ� �ִ� int�� ���� N ���� �Է¹޴� ��� (���� ����)
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ���� 1ȸ ����
//     ...
//     StringTokenizer st = new StringTokenizer(br.readLine());
//     for(int i=0; i<N; i++) myvalue[i] = Integer.parseInt(st.nextToken());
////////

class Exercise_1 {
	public static void main(String args[]) throws Exception {
    	
		// �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� sample_input.txt ���Ϸκ���
		// �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ�
		// sample_input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� 
		// ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		// ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		// ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�ó�� �ϼž� �մϴ�.
		//System.setIn(new FileInputStream("sample_input.txt"));

		//////// Your algorithm is implemented here. ////////
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\Exercise_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			Athletic[] aa = new Athletic[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				aa[i] = new Athletic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(aa);
			int max = 1;
            Athletic tmp = new Athletic(0, 0);
			for(int i = N-2; i>=0; i--) {
                if (i<0) break;
				else {
                    tmp = new Athletic(0, 0);
					for (int j = i; j<=N-1; j++) {
						if (aa[i].left < aa[j].left && aa[i].right < aa[j].right) {
                            if (aa[i].remain < aa[j].remain + 1) {
                                aa[i].remain = aa[j].remain + 1;
                            	if (aa[i].remain > max) {
	                                max = aa[i].remain;
									if (tmp.left == 0 && tmp.right == 0) {
                                        tmp = aa[j];
                                    } else {
                                        if (aa[j].left > tmp.left && aa[j].right > tmp.right){
                                            break;
                                        }
                                    }
                                }
                            }
						}
                        if (tmp.left != 0 && tmp.right != 0 && aa[j].left > tmp.left && aa[j].right > tmp.right){
                            break;
                        }
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
    
    private static class Athletic implements Comparable<Athletic>{
		int left;
		int right;
		int remain = 1;

		public Athletic(int l, int r) {
			this.left = l;
			this.right = r;
		}

		@Override
		public int compareTo(Athletic arg0) {
			// TODO Auto-generated method stub
			return Math.max(this.left, this.right) - Math.max(arg0.left, arg0.right);
		}	
	}
}
