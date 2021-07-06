package samsung_test;

import java.io.*;
import java.util.*;

////////
// You can add and modify values and implementations if needed.
// Professional 검정에서는 입출력 코드를 '문제의 조건에 맞게' 직접 작성하셔야 합니다.
// 입출력은 표준 입출력을 사용하여야 합니다.
// 단, 여러분의 PC에서 작업하실 때 필요한 System.setIn 구문은 아래 제시된 것을 이용하시면 됩니다.
// 입력은 BufferedReader, StringTokenizer 를 사용하는 것을 권장합니다. 
// 예) 한 줄에 있는 int형 정수 N 개를 입력받는 경우 (공백 구분)
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 최초 1회 설정
//     ...
//     StringTokenizer st = new StringTokenizer(br.readLine());
//     for(int i=0; i<N; i++) myvalue[i] = Integer.parseInt(st.nextToken());
////////

class Exercise_1 {
	public static void main(String args[]) throws Exception {
    	
		// 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터
		// 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를 테스트 할 때, 편의를 위해서
		// sample_input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 
		// 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		// 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		// 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석처리 하셔야 합니다.
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

