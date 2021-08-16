package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//Completed
public class P_0005_interstella3 {

	static int T;
	static int N;
	static int M;
	static int K;
	
	static int[][] adj;
	static int[][] distance;
//	static int INF = Integer.MAX_VALUE;
	static int INF = 987654321;	
	
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
		try {
//			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			System.setIn(new FileInputStream("C:\\Dev\\workspace\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t < T + 1; t++  ) {
				 String[] Input = br.readLine().split(" ");
				 N = Integer.parseInt(Input[0]);
				 M = Integer.parseInt(Input[1]);
				 K = Integer.parseInt(Input[2]);
				 
				 adj = new int[N + 1][N + 1];
			 
				 
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
				 }
				 
				 String[] Input3 = br.readLine().split(" ");
				 int start = Integer.parseInt(Input3[0]);
				 int end = Integer.parseInt(Input3[1]);
				 
				 distance = new int[M+1][K+1];
				 for (int i = 1; i < M+1; i ++) {
					 for (int k = 0; k < K+1; k ++ ) {
						 distance[i][k] =  INF;
					 }
				 }
				 
				 
//				 for (int i = 1; i < M+1; i ++) {
//					 for (int j = 1; j < M+1; j ++) {
//						 System.out.print(adj[i][j] + " ") ;
//					 }
//					 System.out.println("");
//				 }
				 
				PriorityQueue <Element> pq = new PriorityQueue();
				distance[start][0] = 0;
				pq.offer(new Element(start, 0, distance[start][0]));
				
			
				while (!pq.isEmpty()) {
					Element current = pq.poll();
					
					if (current.distance > distance[current.index][current.warp]) continue;

					for (int i = 1; i < N + 1; i ++) {
						System.out.println("wrap = " + current.warp + " current index = " + current.index + " to (i) = " + i + " distance = " + distance[i][current.warp]);						
						if (adj[current.index][i] != INF) {
							if (distance[i][current.warp] > distance[current.index][current.warp] + adj[current.index][i]) {
								distance[i][current.warp] = distance[current.index][current.warp] + adj[current.index][i];
								pq.offer(new Element(i, current.warp, distance[i][current.warp]));
							}
							
							
							if (current.warp < K && distance[i][current.warp + 1] > distance[current.index][current.warp] + 1) {
								distance[i][current.warp + 1] = distance[current.index][current.warp] + 1;
								pq.offer(new Element(i, current.warp + 1, distance[i][current.warp + 1]));
							}							
						}
					}
					

				}
				

				
//				for (int i = 1; i < N +1; i ++ ) {
//					System.out.println("i = " + i + " Distance = "	+ distance[i]);
//				}
//				
				System.out.println("#" + t + " " + distance[end][K]);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
