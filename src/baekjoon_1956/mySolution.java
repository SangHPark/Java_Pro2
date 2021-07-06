package baekjoon_1956;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mySolution {

	static int V, E;
	static int[][] map;
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_1956\\mySolution.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
				
		String[] Input = br.readLine().split(" ");
		V = Integer.parseInt(Input[0]);
		E = Integer.parseInt(Input[1]);
		
		map = new int[V+1][V+1];
		
		for (int i = 1; i < V+1; i++) {
			for (int j = 1; j < V+1; j++) {
				map[i][j] = INF;
			}
		}
//		
		for (int i = 1; i < E+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			map[start][end] = distance;
		}
		
//		for (int i = 1; i < V+1; i++ ) {
//			for (int j = 1; j < V+1; j ++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}		
		
		for (int k = 1; k < V+1; k ++) {
			for (int i = 1; i < V+1; i++ ) {
				for (int j = 1; j < V+1; j ++) {
//					if (i == j) continue;
					
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		
		for (int i = 1; i < V+1; i++ ) {
			for (int j = 1; j < V+1; j ++) {
//				if (i == j) continue;
				
				if (map[i][j] != INF && map[j][j] != INF) {
					ans = Math.min(ans, map[i][j] + map[j][i]);
				}
			}
		}
		

//		for (int i = 1; i < V+1; i++ ) {
//			for (int j = 1; j < V+1; j ++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}
		ans = (ans == INF) ? -1 : ans;
		
		System.out.println(ans);
		
	}
}
