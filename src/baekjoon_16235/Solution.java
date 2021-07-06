package baekjoon_16235;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
	
	static class Tree {
		int r, c, age;
		boolean alive;
		
		Tree (int r, int c, int age, boolean alive) {
			this.r = r;
			this.c = c;
			this.age = age;
			
			this.alive = alive;
		}
	}

	static int N, M, K;
	static int[][] A, F;
	static LinkedList<Tree> Treelist;
	static int[] dr = {-1, -1, -1,  0,  0, +1, +1, +1 };
	static int[] dc = {-1,  0, +1, -1, +1, -1,  0, +1 };
	
	static int solve() {
		
		for (int k = 1; k < K + 1; k ++ ) {
			
			//Spring
//			for (int i = 0; i < Treelist.size(); i ++) {
//				Tree mytree = Treelist.get(i);
			
			for (Tree mytree : Treelist) {
				if (F[mytree.r][mytree.c] >= mytree.age) {
					F[mytree.r][mytree.c] -= mytree.age;
					mytree.age ++;
				} else {mytree.alive = false;}
			}
			
			//Summer
			for (Iterator<Tree> it = Treelist.iterator(); it.hasNext();) {
				Tree mytree = it.next();
				if (mytree.alive == false) {
					F[mytree.r][mytree.c] += mytree.age / 2;
					it.remove();
				}			
			}
			
			//Fall
			LinkedList<Tree> newTree = new LinkedList<Tree>();
			
			for (Iterator<Tree> it = Treelist.iterator(); it.hasNext();) {
				Tree mytree = it.next();
				if (mytree.age % 5 == 0 ) {
					for (int i = 0; i < 8; i ++) {
						int nr = mytree.r + dr[i];
						int nc = mytree.c + dc[i];
						
						if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
						
						newTree.add(new Tree(nr, nc, 1, true)); 
					}
				}
			}
			
			Treelist.addAll(0, newTree);
			
			//Winter
			for (int i = 1; i < N + 1; i ++) {
				for (int j = 1; j < N + 1; j ++) {
					F[i][j] += A[i][j];
				}
			}
			
		}
		
		
		
		return Treelist.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_16235\\Solution.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] Input = br.readLine().split(" ");
			N = Integer.parseInt(Input[0]);
			M = Integer.parseInt(Input[1]);
			K = Integer.parseInt(Input[2]);
			
			A = new int[N + 1][N + 1];
			F = new int[N + 1][N + 1];
			
			for (int i = 1; i < N + 1; i ++  ) {
				String[] Input2 = br.readLine().split(" ");
				for (int j = 1; j < N + 1; j ++) {
					A[i][j] = Integer.parseInt(Input2[j-1]);
					F[i][j] = 5;  //Initial Fertilizer 5
				}
			}
			
			Treelist = new LinkedList<Tree>();
			
			for (int i = 1; i < M+1; i ++) {
				String[] Input3 = br.readLine().split(" ");
				int r = Integer.parseInt(Input3[0]);
				int c = Integer.parseInt(Input3[1]);
				int age = Integer.parseInt(Input3[2]);
				
				Treelist.add(new Tree(r, c, age, true));
			}
			
			System.out.println(solve());
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
