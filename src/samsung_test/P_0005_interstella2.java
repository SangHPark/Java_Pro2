package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//NOT Completed
public class P_0005_interstella2 {

	static int T;
	static int N;
	static int M;
	static int K;
	
	static int[][] adj, b_adj;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	
	static boolean PKG1, PKG2;
	static class Element implements Comparable <Element> {
		int index;
		int distance;
		
		public Element (int idx, int d) {
			this.index = idx;
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
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t < T + 1; t++  ) {
				 String[] Input = br.readLine().split(" ");
				 N = Integer.parseInt(Input[0]);
				 M = Integer.parseInt(Input[1]);
				 K = Integer.parseInt(Input[2]);
				 
				 adj = new int[N + 1][N + 1];
				 b_adj = new int[N + 1][N + 1];
				 
				 
				 for (int i = 1; i < M+1; i ++) {
					 for (int j = 1; j < M+1; j ++) {
						 adj[i][j] = INF;
					 }
				 }
				 
				 for (int m = 1; m < M+1; m ++) {
					 String[] Input2 = br.readLine().split(" ");
					 int fr = Integer.parseInt(Input2[0]);
					 int to = Integer.parseInt(Input2[1]);
					 int co = Integer.parseInt(Input2[2]);
					 
					 adj[fr][to] = co;
					 adj[to][fr] = co;
					 
					 b_adj[fr][to] = co;
					 b_adj[to][fr] = co;					 
					 
					 
				 }
				 
				 String[] Input3 = br.readLine().split(" ");
				 int start = Integer.parseInt(Input3[0]);
				 int end = Integer.parseInt(Input3[1]);
				 
				 distance = new int[M+1];
				 for (int i = 1; i < M+1; i ++) {
					 distance[i] =  INF;
				 }
				 
				 
//				 for (int i = 1; i < M+1; i ++) {
//					 for (int j = 1; j < M+1; j ++) {
//						 System.out.print(adj[i][j] + " ") ;
//					 }
//					 System.out.println("");
//				 }
				 
				PriorityQueue <Element> pq = new PriorityQueue();
				distance[start] = 0;
				pq.offer(new Element(start, distance[start]));
				
				int USED_PKG = 0;
				
				while (!pq.isEmpty()) {
					Element current = pq.poll();
					
					if (current.distance > distance[current.index]) continue;
					
					for (int i = 1; i < N + 1; i ++) {
						System.out.println("current index = " + current.index + " current distance = " + current.distance);						
						if (adj[current.index][i] != Integer.MAX_VALUE) {
//							if (K > 0 && USED_PKG < K+1) {
//								adj[current.index][i] = 1;
//								USED_PKG ++;
//							}
							
							if (distance[i] > distance[current.index] + adj[current.index][i]) {
//								System.out.println("from " + current.index + "  to " + i + " Distance " + adj[current.index][i]);
								distance[i] = distance[current.index] + adj[current.index][i];
								pq.offer(new Element(i, distance[i]));
							}
						}
					}
					
//					USED_PKG = 0;
//					for (int i = 1; i < N + 1; i ++) {
//						adj[current.index][i] = b_adj[current.index][i];
//					}
				}
				

				
//				for (int i = 1; i < N +1; i ++ ) {
//					System.out.println("i = " + i + " Distance = "	+ distance[i]);
//				}
//				
				System.out.println("#" + t + " " + distance[end]);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
