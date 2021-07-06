package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P_0007_highway_construction {

	static int T;
	static int N;
	static int M;
	
	static int[][] map;
	static int MAX_C = 10000;
	
	static int[] parent;
	
	static ArrayList<Highway> myArrayList;
	
	
	public static class Highway implements Comparable<Highway>{
		public int f_city;
		public int t_city;
		
		public int cost;

		public Highway (int fr, int to, int co) {
			this.f_city = fr;
			this.t_city = to;
			this.cost = co;
		}
		
		@Override
		public int compareTo(Highway target) {
			// TODO Auto-generated method stub
			return this.cost > target.cost ? 1 : -1;
		}
	}
	
	public static int getParent(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = getParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		
		if (pa < pb) parent[pb] = a;
		else parent[pa] = b;
	}
	
	public static boolean hasSameParent(int a, int b) {
		if (getParent(a) == getParent(b)) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0007_highway_construction.txt"));
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\highway.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());

		
		for (int t = 1; t < T + 1; t ++ ) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			myArrayList = new ArrayList<Highway>();
			parent = new int[N+1];
			

			for (int i = 1; i < N + 1; i++) {
				parent[i] = i;
			}

			
			for (int i = 0; i < M; i ++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				myArrayList.add(new Highway(s,e,c));
			}
			
			Collections.sort(myArrayList);
			
			int sum = 0;
			for (int i  = 0; i < M; i ++) {
				int from = myArrayList.get(i).f_city;
				int to = myArrayList.get(i).t_city;
				
				
				if (!hasSameParent(from, to)) {
					sum += myArrayList.get(i).cost;
					
					unionParent(from, to);
					
					System.out.println("from = " + from + " to = " + to + " cost = " + myArrayList.get(i).cost + " sum = " + sum);
					
				}
			}
			
			System.out.println("#" + t + " " + sum);
			
		}
		
	}

}
