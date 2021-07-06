package baekjoon_2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class mySolution2 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static boolean new_danji = false;
	
	
	static ArrayList<DANJI> mydanji;
	
	static class DANJI implements Comparable<DANJI> {
		String d_Name;
		int d_uCnt;
		
		DANJI (String d_No, int d_uCnt ) {
			this.d_Name = d_No;
			this.d_uCnt = d_uCnt;
		}

		@Override
		public int compareTo(DANJI target) {
			// TODO Auto-generated method stub
			return this.d_uCnt > target.d_uCnt ?  1 : -1;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Dev\\workspace\\Java_Pro2\\Java_Pro2\\src\\baekjoon_2667\\baekjoon_2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		mydanji = new ArrayList<DANJI>();
		
		for (int i = 1; i < N+1 ; i ++) {
			String str = br.readLine();
			for (int j = 1; j < N+1; j ++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		

		for (int i = 1; i < N+1 ; i ++) {
			for (int j = 1; j < N+1; j ++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					new_danji = true;
					mydanji.add(new DANJI(String.valueOf(i) + String.valueOf(j), 1));
					dfs(i,j);
					new_danji = false;
				}
			}
		}
		
		
		Collections.sort(mydanji);
		

		System.out.println(mydanji.size());
		
		for (DANJI d : mydanji) {
			System.out.println(d.d_uCnt);
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
			
			if (map[nx][ny] == '1') {
				int current_size = mydanji.size();
				mydanji.get(current_size - 1).d_uCnt ++;
				dfs(nx, ny);
			}
		}
	}
}
