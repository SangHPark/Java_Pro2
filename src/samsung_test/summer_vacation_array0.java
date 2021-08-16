package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Better than array list
public class summer_vacation_array0 {

	static int T;
	static int N;
	static int M;
	static int K;
	
	static int[][] adj;
	static int[] distance;

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
			 
				 
				 for (int i = 1; i < N+1; i ++) {
					 for (int j = 1; j < N+1; j ++) {
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
				 
				 distance = new int[M+1];
				 for (int i = 1; i < M+1; i ++) {
						 distance[i] =  INF;
				 }
				 
				 
				PriorityQueue <City> pq = new PriorityQueue();
				distance[start] = 0;
				pq.offer(new City(start, 0, distance[start]));
				
			
				while (!pq.isEmpty()) {
					City current = pq.poll();
					
					if (current.distance > distance[current.index]) continue;

					for (int i = 1; i < N + 1; i ++) {
//						System.out.print ("current index = " + current.index);
						System.out.print (" i = " + i);
//						System.out.print (" distanace[i] = " + distance[i]);
//						System.out.print (" distance[current.index] = " + distance[current.index]);
//						System.out.print (" adj[current.index][i] = " + adj[current.index][i]);
						
						if (adj[current.index][i] != INF) {
							int nextDistance = distance[current.index] + adj[current.index][i];
							if (distance[i] > nextDistance) {
								distance[i] = nextDistance;
								pq.offer(new City(i, current.coupon, distance[i]));
							}
						}
						System.out.println("");

					}
					for (int j = 1; j < N +1; j ++ ) {
						System.out.print(" , j  = " + j + " Distance = "	+ distance[j]);
					}
					System.out.println("");

				}
				

				
				for (int i = 1; i < N +1; i ++ ) {
					System.out.println("i = " + i + " Distance = "	+ distance[i]);
				}
//				
//				System.out.println("#" + t + " " + distance[end][K]);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
