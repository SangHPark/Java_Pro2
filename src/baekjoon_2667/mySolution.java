package baekjoon_2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mySolution {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int danji_cnt = 0;
	static boolean new_danji = false;
	static int[] danji;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_2667\\baekjoon_2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][N+1];
		danji = new int[N*N];
		visited = new boolean[N+1][N+1];
		
		for (int i = 1; i < N+1 ; i ++) {
			String str = br.readLine();
			for (int j = 1; j < N+1; j ++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		
//		for (int i = 1; i < N+1 ; i ++) {
//			for (int j = 1; j < N+1; j ++) {
//				System.out.print(map[i][j] +" ");
//			}
//			System.out.println("");
//		}
		

		for (int i = 1; i < N+1 ; i ++) {
			for (int j = 1; j < N+1; j ++) {
				if (map[i][j] == '1' && !visited[i][j]) {
//					System.out.println("start from " + i + "," + j );
					
					if (i== 5 && j == 5) {
						System.out.println("LMK");
					}
					new_danji = true;
//					danji_cnt ++;
					danji[danji_cnt] ++;
					
					dfs(i,j);
					if (new_danji) {
						danji_cnt ++ ;
					}
					new_danji = false;
				}
			}
		}
		
		
		System.out.println(danji_cnt);
		
		Arrays.sort(danji);
		
		for (int i = 0; i < N*N; i ++) {
			if (danji[i] > 0) {
				System.out.println(danji[i]);
			}
		}

		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = { 0, 0,-1, 1};
		
		for (int i = 0; i < 4; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
			
			if (visited[nx][ny]) continue;
			
			if (map[nx][ny] == '0') continue;
			
//			System.out.println(" from (x,y) " + x + "," + y + " to (nx, ny) " + nx + "," + ny);
			

			if (map[nx][ny] == '1') {
				danji[danji_cnt] ++;
				dfs(nx, ny);
			}
		}
	}
}
