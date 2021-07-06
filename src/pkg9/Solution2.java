package pkg9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	
	static int T, M, N;
	static int[][] city_map;
	static int result;
	
	static class myPOS {
		int x, y;
		int value;
		boolean onlyRight = false;
		boolean onlyDown = false;
		
		public myPOS(int x, int y, int value, boolean onlyRight, boolean onlyDown) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.onlyRight = onlyRight;
			this.onlyDown = onlyDown;
		}
	}
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\pkg9\\Solution.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t < T + 1; t ++ ) {
				String[] input = br.readLine().split(" ");
				M = Integer.parseInt(input[0]);
				N = Integer.parseInt(input[1]);
				
				city_map = new int[M][N];
				
				for (int i = 0; i < M ; i ++ ) {
					String[] rows = br.readLine().split(" ");
					for (int j = 0; j < N ; j ++ ) {
						city_map[i][j] = Integer.parseInt(rows[j]);
					}
				}
				
				
				
				result = 0;
				System.out.println("result : " + solution(M, N, city_map));

			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	
	
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        answer = myDFS(new myPOS(0, 0, 0, false, false), cityMap);
        return answer;
    }
    
    
	static int myDFS(myPOS curr, int[][] city_map) {
		if (curr.x == (M -1) && curr.y == (N - 1)) return result ++ ;
		
		int newX, newY;
		
		//Move Down
		newX = curr.x + 1;
		newY = curr.y;
		
		if (curr.x + 1 < M && !curr.onlyRight) {
			if (city_map[curr.x + 1][curr.y] == 0) {
				myDFS(new myPOS(curr.x + 1, curr.y, city_map[curr.x + 1][curr.y], false, false), city_map);
			} else if(city_map[curr.x + 1][curr.y] == 2) {
				myDFS(new myPOS(curr.x + 1, curr.y, city_map[curr.x + 1][curr.y], false, true), city_map);
			}
		}
		
		//Move Right
		if (curr.y + 1 < N && !curr.onlyDown) {
			if (city_map[curr.x][curr.y + 1] == 0) {
				myDFS(new myPOS(curr.x, curr.y + 1 , city_map[curr.x][curr.y + 1], false, false), city_map);
			} else if(city_map[curr.x][curr.y + 1] == 2) {
				myDFS(new myPOS(curr.x, curr.y + 1, city_map[curr.x][curr.y + 1], true, false), city_map);
			}
		}
		
		return result;
	}

}
