package baekjoon_15683;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class mySolution {

	static int N, M;
	static int[][] room;
	static int[][][] cctv_ed;
	
	static void mark_covered (int i, int j, int cctv_type) {
		int delta_x, delta_y;
		// No direction Change
		delta_x =  0;
		delta_y = +1;
		
//		// 90 D Change
//		delta_x = +1;
//		delta_y =  0;
//		
//		// 180 D Change
//		delta_x =  0;
//		delta_y = -1;		
//		
//		// 270 D Change
//		delta_x = -1;
//		delta_y =  0;		
//
		
		int x = i;
		int y = j;
		
		if (cctv_type == 1) {
			for (y = j; y < M+1; y++) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
		}
		
		
		
		if (cctv_type == 2) {
			for (y = j; y < M+1; y++) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
			
			for (y = j; y > 0; y--) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}			
		}		
		
		
		
		if (cctv_type == 3) {
			
			
			for (y = j; y < M+1; y++) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
			
			
			for (x = i; x > 0; x--) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
		}
			
		if (cctv_type == 4) {
			
			
			for (y = j; y < M+1; y++) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
			
			for (y = j; y > 0; y--) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
			
			for (x = i; x > 0; x--) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}			
			
			
		}
		
		if (cctv_type == 5) {
			
			
			for (y = j; y < M+1; y++) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
			
			for (y = j; y > 0; y--) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}
			
			for (x = i; x > 0; x--) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}			
			
			for (x = i; x < N + 1; x++) {
				if (room[x][y] == 6) return;
				
				cctv_ed[0][x][y] = 9;
			}				
			
		}		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_15683\\mySolution.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);
	
			room = new int[N+1][M+1];
			cctv_ed = new int[8281][N+1][M+1];
			
			for (int i = 1; i < N + 1; i ++) {
				String[] Input1 = br.readLine().split(" ");
				for (int j = 1; j < M + 1; j ++) {
					room[i][j] = Integer.parseInt(Input1[j-1]);
					cctv_ed[0][i][j] = room[i][j];
					
					if (room[i][j] != 0 && room[i][j] != 6) {
						mark_covered(i,j,room[i][j]);
					}
				}
			}

			System.out.println("Room" );
			
			for (int i = 1; i < N + 1; i ++) {
				for (int j = 1; j < M + 1; j ++) {
					System.out.print(room[i][j] + " ");
				}
				System.out.println(" " );
			}
			
			System.out.println("CCTV-ed" );
			for (int i = 1; i < N + 1; i ++) {
				for (int j = 1; j < M + 1; j ++) {
					System.out.print(cctv_ed[0][i][j] + " ");
				}
				System.out.println(" " );
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	

}
