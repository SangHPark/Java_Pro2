package baekjoon_15683;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static final int INF = 987654321;
	static int N, M;
	static int[][] room;
	static int[][] bk_room;
	static int[][] cv_room;
	static boolean oneturn = false;	
	
	static final int MaxCamCnt = 8;
	
	static int CamCnt;
	
	static int[] CamType;
	static int[] CamRow;
	static int[] CamCol;
	
	static int[] Dr = {0, -1,  0,  1};
	static int[] Dc = {1,  0, -1,  0};
	
	
	static int[][] DCam = {
			{1, 0, 0, 0, 4},
			{1, 0, 1, 0, 2},
			{1, 1, 0, 0, 3},
			{1, 1, 1, 0, 3},
			{1, 1, 1, 1, 1}
	};
	
	
	static void copyRoom(int[][] dest, int[][] src) {
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j ++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	
	static void watch(int r, int c, int dir) {
		int srow = r, scol = c;
		for (;;) {
			int nr = srow + Dr[dir];
			int nc = scol + Dc[dir];
			if (nr < 0 || nr > N - 1|| nc < 0 || nc > M - 1) return;
			if (room[nr][nc] == 6) return;
			
			room[nr][nc] = 9;
			srow = nr;
			scol = nc;
		}
	}
	
	static int solve (int pos) {

		if (pos == CamCnt) {
			int sum = 0;
			for (int i = 0; i < N ; i ++) {
				for (int j = 0; j < M ; j ++) {
					if (room[i][j] == 0) sum ++;
				}
			}
			oneturn = true;
			return sum;
		}
		
		int ret = INF;
		
		int type = CamType[pos] - 1;
		
		for (int i= 0; i < DCam[type][4]; i ++) {
			copyRoom(cv_room, room);			

			for (int j = 0; j < 4; j ++ ) {
				if (DCam[type][j] == 1) {
					watch(CamRow[pos], CamCol[pos], (i+j)%4);
				}
				

			}
			
			System.out.println("CCTV-ed = " + pos +  " dir = " + i);
			for (int k = 0; k < N; k ++) {
				for (int l = 0; l < M; l ++) {
					System.out.print(room[k][l] + " ");
				}
				System.out.println(" " );
			}
			
			int tmp = solve(pos + 1);
			ret = Math.min(ret, tmp);
			
			if (oneturn) {
				copyRoom(room, bk_room);
				oneturn = false;
			} else {
				copyRoom(room, cv_room);
			}
			

		}
		
	
		
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_15683\\mySolution.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);
	
			room = new int[N][M];
			bk_room = new int[N][M];
			cv_room = new int[N][M];
			
			CamCnt = 0;
			CamType = new int[MaxCamCnt];
			CamRow = new int[MaxCamCnt];
			CamCol = new int[MaxCamCnt];
			
			for (int i = 0; i < N; i ++) {
				String[] Input1 = br.readLine().split(" ");
				for (int j = 0; j < M; j ++) {
					room[i][j] = Integer.parseInt(Input1[j]);
					bk_room[i][j] = room[i][j];
					if (room[i][j] >= 1 && room[i][j] <= 5) {
						
						CamType[CamCnt] = room[i][j];
						CamRow[CamCnt] = i;
						CamCol[CamCnt] = j;
						CamCnt ++;
					}
				}
			}
			
//			System.out.println("Room" );
//			
//			for (int i = 0; i < N; i ++) {
//				for (int j = 0; j < M ; j ++) {
//					System.out.print(room[i][j] + " ");
//				}
//				System.out.println(" " );
//			}			
			
			System.out.println(solve(0));
			
		
			System.out.println("CCTV-ed" );
			for (int i = 0; i < N; i ++) {
				for (int j = 0; j < M; j ++) {
					System.out.print(room[i][j] + " ");
				}
				System.out.println(" " );
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
