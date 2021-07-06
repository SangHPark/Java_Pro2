package baekjoon_15683;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
	static int N, M;
	static int min = 0;
	static int[][] room;
	static List<int[]> list = new ArrayList<>();
	
	static class Node {
		int num;
		int[][] map;
		
		Node(int num, int[][] map) {
			this.num = num;
			this.map = map;
		}
	}
	
	static void bfs(int[][] room, int n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n, room));
		
		for(int i =0; i < list.size(); i++) {
			
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
	
			room = new int[N][M];
			
			for (int i = 0; i < N; i ++) {
				String[] Input1 = br.readLine().split(" ");
				for (int j = 0; j < M; j ++) {
					room[i][j] = Integer.parseInt(Input1[j]);
					if (room[i][j] == 0) min ++;
					if (room[i][j] >= 1 && room[i][j] <= 5) {
						list.add(new int[] {i,j});
					}
				}
			}	
			
			bfs(room, min);
			System.out.println(min);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
