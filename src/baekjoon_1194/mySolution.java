package baekjoon_1194;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class mySolution {

	static int N, M;
	static char[][] maze;
	static boolean[][][] visited;
	
	static int sx, sy;
	static class myState {
		int x;
		int y;
		int keyset;
		int nSteps;
		
		myState (int x, int y, int keyset, int nSteps) {
			this.x = x;
			this.y = y;
			this.keyset = keyset;
			this.nSteps = nSteps;
		}
	}
	
	static int bfs() {
		Queue<myState> mq = new LinkedList<>();
		mq.add(new myState(sx, sy, 0, 0));
		visited[0][sx][sy] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = { 0, 0,-1, 1};
		
		while(!mq.isEmpty()) {
			myState state = mq.poll();
			int x = state.x ;
			int y = state.y ;
			int keyset = state.keyset ;
			int nSteps = state.nSteps ;
			
			if ( maze[x][y] == '1' ) return nSteps;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx > N || nx < 1 || ny > M || ny < 1) continue;
				
				char curr = maze[nx][ny];
				
				if (curr == '#') continue;
				else if (curr == '.' || curr == '0' || curr == '1') {
					if (!visited[keyset][nx][ny]) {
						visited[keyset][nx][ny] = true;
						mq.add(new myState(nx, ny, keyset, nSteps + 1));
					}
				}
				else if (curr >= 'a' && curr <= 'f') {
					int newKey = 1 << curr - 'a';
					newKey = keyset | newKey;
					
					if (!visited[newKey][nx][ny]) {
						visited[newKey][nx][ny] = true;
						mq.add(new myState(nx, ny, newKey, nSteps + 1));
					}
				}
				else if (curr >= 'A' && curr <= 'F') {
					if (!visited[keyset][nx][ny]) {
						int door = 1 << curr - 'A';
						if ((keyset & door) > 0) {
							visited[keyset][nx][ny] = true;
							mq.add(new myState(nx, ny, keyset, nSteps + 1));
						}						
					}

				}
				
				
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_1194\\baekjoon_1194.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			maze = new char[N+1][M+1];
			visited = new boolean[64][N+1][M+1];
			
			for (int n = 1; n < N+1; n++) {
				String str = br.readLine();
//				System.out.println(str);
				for (int m = 1; m < M+1; m++) {
					maze[n][m] = str.charAt(m - 1);
					if (maze[n][m] == '0') {
						sx = n; sy = m;	
					}
				}
			}
			
			
			for (int i = 1; i < N +1; i ++) {
				for (int j = 1; j < M + 1; j ++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println("");
			}
			
			
			
			
			System.out.println(bfs());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
