package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class summer_vacation {

	static int T;
	static int N;
	static int M;
	static int K;
	
	static ArrayList<City>[] alist;
	static int[][] distance;
	
	static int INF = Integer.MAX_VALUE;
	
	static long _start = 0;
	static void printElapse() {
		System.out.println(">> " + (System.currentTimeMillis() - _start) + "ms");
	}
	
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
		_start = System.currentTimeMillis(); // set application start time for test which do not mandatory for exam.
		
		try {
//			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0005_interstella.txt"));
			System.setIn(new FileInputStream("C:\\Dev\\workspace\\Java_Pro2\\src\\samsung_test\\summer_vacation.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			T = Integer.parseInt(st.nextToken());
			
			
			for (int t = 1; t < T + 1; t++  ) {
				
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st1.nextToken());
				M = Integer.parseInt(st1.nextToken());
				K = 2;
				
				 alist = new ArrayList[N+1];
				 
				 for (int i = 1; i < N + 1; i ++) {
						 alist[i] = new ArrayList<City>();
				 }

				 StringTokenizer st3 = new StringTokenizer(br.readLine());				 
				 int Q1 = Integer.parseInt(st3.nextToken());
				 int Q2 = Integer.parseInt(st3.nextToken());	
				 
				 for (int m = 1; m < M+1; m ++) {

					 StringTokenizer st2 = new StringTokenizer(br.readLine());
					 int fr = Integer.parseInt(st2.nextToken());
					 int to = Integer.parseInt(st2.nextToken());
					 int co = Integer.parseInt(st2.nextToken());				 
				 
					 alist[fr].add(new City(to, 0, co));
					 alist[to].add(new City(fr, 0, co));
				 }
				 

				 
				 int start = 1;
				 int end = N;	
				 
				 distance = new int[N+1][K+1];
				 for (int i = 1; i < N+1; i ++) {
					 Arrays.fill(distance[i], INF);
				 }
				 
				 PriorityQueue <City> pq = new PriorityQueue();
				 distance[start][0] = 0;
				 pq.offer(new City(start, 0, distance[start][0]));

				 boolean isArrived = false;

				 while (!pq.isEmpty() && (!isArrived)) {
					 City current = pq.poll();

					 if (current.distance > distance[current.index][current.coupon]) continue;

					 if (current.index == end) continue;


					 for (City e : alist[current.index]) {
						 if (e.index == end && (current.coupon + 1) == K) {
							 isArrived = true;
							 break;
						 }
						 
						 if (distance[e.index][current.coupon] > distance[current.index][current.coupon] + e.distance) {
							 distance[e.index][current.coupon] = distance[current.index][current.coupon] + e.distance;
							 pq.offer(new City(e.index, current.coupon, distance[e.index][current.coupon]));
						 }

						 if (current.coupon < K && distance[e.index][current.coupon + 1] > distance[current.index][current.coupon] + 1) {
							 distance[e.index][current.coupon + 1] = distance[current.index][current.coupon] + 1;
							 pq.offer(new City(e.index, current.coupon + 1, distance[e.index][current.coupon + 1]));
						 }	
					 }
				 }

				 System.out.println("#" + t + " " + distance[end][K]);
			}

			printElapse(); // Display program running time. This line of code has to be removed from submitted code.
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
