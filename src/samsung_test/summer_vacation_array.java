package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Better than array list
public class summer_vacation_array {

	static int T;
	static int N;
	static int M;
	static int K;
	
	static int[][] adj;
	static int[][] distance;

	static int INF = Integer.MAX_VALUE;	
	
	static class City implements Comparable <City> {
		int index;
		int distance;
		int coupon;
		
		public City (int idx, int w, int d) {
			this.index = idx;
			this.coupon = w;
			this.distance = d;
		}
		
		@Override
		public int compareTo(City target) {
			// TODO Auto-generated method stub
			return this.distance > target.distance ? 1 : -1;
		}		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			System.setIn(new FileInputStream("C:\\Dev\\workspace\\Java_Pro2\\src\\samsung_test\\summer_vacation.txt"));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t < T + 1; t++  ) {
				 String[] Input = br.readLine().split(" ");
				 N = Integer.parseInt(Input[0]);
				 M = Integer.parseInt(Input[1]);
				 K = 0;
				 
				 adj = new int[N + 1][N + 1];
			 
				 
				 for (int i = 1; i < M+1; i ++) {
					 for (int j = 1; j < M+1; j ++) {
						 adj[i][j] = INF;
					 }
				 }
				 
				 StringTokenizer st3 = new StringTokenizer(br.readLine());				 
				 int C1 = Integer.parseInt(st3.nextToken());
				 int C2 = Integer.parseInt(st3.nextToken());	
				 
				 for (int m = 1; m < M+1; m ++) {
					 String[] Input2 = br.readLine().split(" ");
					 int fr = Integer.parseInt(Input2[0]);
					 int to = Integer.parseInt(Input2[1]);
					 int co = Integer.parseInt(Input2[2]);
					 
					 adj[fr][to] = co;
					 adj[to][fr] = co;
				 }
				 
//				 String[] Input3 = br.readLine().split(" ");
//				 int start = Integer.parseInt(Input3[0]);
//				 int end = Integer.parseInt(Input3[1]);
				 
				 int start = 1;
				 int end = 4;	
				 
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
				 
				PriorityQueue <City> pq = new PriorityQueue();
				distance[start][0] = 0;
				pq.offer(new City(start, 0, distance[start][0]));
				
			
				while (!pq.isEmpty()) {
					City current = pq.poll();
					
					if (current.distance > distance[current.index][current.coupon]) continue;

					for (int i = 1; i < N + 1; i ++) {
						System.out.println("wrap = " + current.coupon + " current index = " + current.index + " to (i) = " + i + 
								" distance = " + distance[i][current.coupon] + " potential shorten distance = " + adj[current.index][i]
										+ " to End = " + distance[end][K]);

						if (adj[current.index][i] != INF) {
							 
							if (distance[i][current.coupon] > distance[current.index][current.coupon] + adj[current.index][i]) {
								distance[i][current.coupon] = distance[current.index][current.coupon] + adj[current.index][i];
								pq.offer(new City(i, current.coupon, distance[i][current.coupon]));
							}
							
							
							if (current.coupon < K && distance[i][current.coupon + 1] > distance[current.index][current.coupon] + 1) {
								distance[i][current.coupon + 1] = distance[current.index][current.coupon] + 1;
								pq.offer(new City(i, current.coupon + 1, distance[i][current.coupon + 1]));
							}								
							
//							if (current.coupon < K && distance[i][current.coupon + 1] - C1 > distance[current.index][current.coupon]) {
//								distance[i][current.coupon + 1] = distance[current.index][current.coupon] + C1;
//								pq.offer(new City(i, current.coupon + 1, distance[i][current.coupon + 1]));
//							}							
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
