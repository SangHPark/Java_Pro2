package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

//NOT Completed
public class P_0005_interstella {

	static int T;
	static int N;
	static int M;
	static int K;
	
	static ArrayList<Element>[] alist;
	static int[][] distance;
	
//	static int INF = 987654321;	
	static int INF = Integer.MAX_VALUE;
	
	static long _start = 0;
	static void printElapse() {
		System.out.println(">> " + (System.currentTimeMillis() - _start) + "ms");
	}
	
	static class Element implements Comparable <Element> {
		int index;
		int distance;
		int warp;
		
		public Element (int idx, int w, int d) {
			this.index = idx;
			this.warp = w;
			this.distance = d;
		}
		
		@Override
		public int compareTo(Element target) {
			// TODO Auto-generated method stub
			return this.distance > target.distance ? 1 : -1;
		}		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_start = System.currentTimeMillis(); // set application start time for test which do not mandatory for exam.
		
		try {
//			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			System.setIn(new FileInputStream("C:\\Dev\\workspace\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
//			T = Integer.parseInt(br.readLine());
//			T = sc.nextInt();
			T = Integer.parseInt(st.nextToken());
			
			
			for (int t = 1; t < T + 1; t++  ) {
//				 String[] Input = br.readLine().split(" ");
//				 N = Integer.parseInt(Input[0]);
//				 M = Integer.parseInt(Input[1]);
//				 K = Integer.parseInt(Input[2]);
			
				
//				N = sc.nextInt();
//				M = sc.nextInt();
//				K = sc.nextInt();
				
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st1.nextToken());
				M = Integer.parseInt(st1.nextToken());
				K = Integer.parseInt(st1.nextToken());
				
				 alist = new ArrayList[N+1];
			 
				 
				 for (int i = 1; i < N + 1; i ++) {
						 alist[i] = new ArrayList<Element>();
				 }
				 
				 for (int m = 1; m < M+1; m ++) {
//					 String[] Input2 = br.readLine().split(" ");
//					 int fr = Integer.parseInt(Input2[0]);
//					 int to = Integer.parseInt(Input2[1]);
//					 int co = Integer.parseInt(Input2[2]);
					 
//					 int fr = sc.nextInt();
//					 int to = sc.nextInt();
//					 int co = sc.nextInt();
					 
					 StringTokenizer st2 = new StringTokenizer(br.readLine());
					 int fr = Integer.parseInt(st2.nextToken());
					 int to = Integer.parseInt(st2.nextToken());
					 int co = Integer.parseInt(st2.nextToken());				 
				 
					 alist[fr].add(new Element(to, 0, co));
					 alist[to].add(new Element(fr, 0, co));
				 }
				 

				 
//				 String[] Input3 = br.readLine().split(" ");
//				 int start = Integer.parseInt(Input3[0]);
//				 int end = Integer.parseInt(Input3[1]);

				 StringTokenizer st3 = new StringTokenizer(br.readLine());				 
				 int start = Integer.parseInt(st3.nextToken());
				 int end = Integer.parseInt(st3.nextToken());	
				 
				 distance = new int[N+1][K+1];
				 for (int i = 1; i < N+1; i ++) {

					 Arrays.fill(distance[i], INF);
				 }
				 
//				 Arrays.fill(distance, INF);
			 
				PriorityQueue <Element> pq = new PriorityQueue();
				distance[start][0] = 0;
				pq.offer(new Element(start, 0, distance[start][0]));
				
				boolean isArrived = false;
			
				while (!pq.isEmpty() && (!isArrived)) {
					Element current = pq.poll();
					
					if (current.distance > distance[current.index][current.warp]) continue;
					
					if (current.index == end) continue;
					
					
					for (Element e : alist[current.index]) {
						System.out.println("current index(from) = " + current.index + " e.index(to) = " + e.index + " e.distance = " + e.distance);

						if (e.index == end && (current.warp + 1) == K) {
//							System.out.println("Checking " + t +  " e.index = " + e.index );
							isArrived = true;
							break;
						}			
						if (distance[e.index][current.warp] > distance[current.index][current.warp] + e.distance) {
							
							distance[e.index][current.warp] = distance[current.index][current.warp] + e.distance;
							pq.offer(new Element(e.index, current.warp, distance[e.index][current.warp]));
						}
						
						if (current.warp < K && distance[e.index][current.warp + 1] > distance[current.index][current.warp] + 1) {
							distance[e.index][current.warp + 1] = distance[current.index][current.warp] + 1;
							pq.offer(new Element(e.index, current.warp + 1, distance[e.index][current.warp + 1]));
						}	

						

					}
				}
				

				
//				for (int i = 1; i < N +1; i ++ ) {
//					System.out.println("i = " + i + " Distance = "	+ distance[i]);
//				}
//				

					System.out.println("#" + t + " " + distance[end][K]);
			}
			
			printElapse(); // Display program running time. This line of code has to be removed from submitted code.
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
