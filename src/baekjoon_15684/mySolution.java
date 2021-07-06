package baekjoon_15684;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class mySolution {

	static final int RIGHT = 1;
	static final int LEFT = 2;
	static final int INF = 987654321;
	
	static int N, M, H, myAnswer;
	static int Ladder[][];
	
	static void travel () {

//		int row = pos / M;
//		int col = pos % M;

		for (int i = 0; i < N; i ++ ) {
			int row = 0;
			int col = i;
			
			do {
				if (Ladder[row][col] == RIGHT)
				{
					col ++ ;
				} else if (Ladder[row][col] == LEFT)
				{
					col --; 
				}
				row ++;
			}
			while (row < H);
			System.out.println("started at = " + i + " arrived = " + col);
		}
	}
	
	static boolean check() {
		for (int i = 0; i < N; i ++ ) {
			int row = 0;
			int col = i;
			do {
				if (Ladder[row][col] == RIGHT)
				{
					col ++ ;
				} else if (Ladder[row][col] == LEFT)
				{
					col --; 
				}
				row ++;
			} while (row != H);
			
			if (col != i) return false;
		}
		return true;

	}
	
	static int solve(int pos, int cnt) {
		
		if (cnt == 3 || (pos >= N * H)) {
			if (check()) return cnt;
			
			return INF;
		}
	
		int ret = INF;
		int row = pos / H;
		int col = pos % H;

		if (col < N-1 && Ladder[row][col] == 0 & Ladder[row][col+1] == 0) {
			Ladder[row][col] = RIGHT;
			Ladder[row][col + 1] = LEFT;
			int tmp = solve(pos + 2, cnt + 1);
			ret = Math.min(ret, tmp);
			Ladder[row][col] = 0;
			Ladder[row][col + 1] = 0;			
		}
			
		int tmp = solve(pos + 1, cnt);
		ret = Math.min(ret, tmp );
		
		return ret;
	}
	
	static void dfs (int x, int count) {
		if (count > 3)  return;

	
		if (myAnswer <= count) return;
		else {
			if (check()) {
				myAnswer = count;
				return;
			}
		}
		
		for (int i = x; i < H; i ++) {
			for (int j = 0; j < N - 1; j ++) {
				if (Ladder[i][j] == 0 && Ladder[i][j+1] == 0) {
					Ladder[i][j] = RIGHT;
					Ladder[i][j + 1] = LEFT;	
					dfs(i, count + 1);
					Ladder[i][j] = 0;
					Ladder[i][j+1] = 0;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_15684\\mySolution.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] input = br.readLine().split(" ");
			
			N = Integer.parseInt(input[0]); //# of Vertical Lines
			M = Integer.parseInt(input[1]); //# of Horizon Lines
			H = Integer.parseInt(input[2]); //# of Bar Lines
	
			Ladder = new int[H][N];
			
			for (int i = 0 ; i < M; i ++) {
				String[] input2 = br.readLine().split(" ");
				int a = Integer.parseInt(input2[0]); 
				int b = Integer.parseInt(input2[1]);
				Ladder[a - 1][b - 1] = RIGHT;
				Ladder[a - 1][b] = LEFT;
			}
			
			
//			int answer = solve(0, 0);
//			
//			if (answer == INF) System.out.println(-1);
//			else
//				System.out.println(answer);

			//Success after minor change
			myAnswer = INF;
			dfs(0,0);
			System.out.println(myAnswer != INF ? myAnswer : -1);
			
	
			
//			myAnswer = INF;
//			dfs(0,0);
//			System.out.println(myAnswer != INF ? myAnswer : -1);
//			for (int i = 0; i <= 3; i ++ ) {
//				myAnswer = i;
//			}			
			
//			travel();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
