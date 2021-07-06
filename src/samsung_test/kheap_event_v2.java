package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kheap_event_v2 {
	static int T;
	static int Q;
	static int arry_size = 10;
	
	static int[] arry;
	
	static int[] nArray;
	
	static Node[] tree = new Node[21];
	
	static class Node {
		Node left;
		Node right;
		
		int value;
		int index;
		
		Node(int v, int idx) {
			this.value = v;
			this.index = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0041_kheap_event.txt"));
//		System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\sample_input_kheap.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t =1 ; t < 2; t++) {
			st = new StringTokenizer(br.readLine());
			Q = Integer.parseInt(st.nextToken());
			
			arry = new int[arry_size];
			nArray = new int[arry_size * 2];
			
			for (int q = 1; q < Q + 1; q ++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				
				if (op == 1) {
					int x = Integer.parseInt(st.nextToken());
					arry[x] ++;

				} else {
					int k = Integer.parseInt(st.nextToken());
					makingArraywithSum(arry);					
//					makingTree(arry);
					
					
					int Answer = Search(k);
					System.out.print("Answer: " + Answer + " ");
					
				}
			}
			
//			System.out.println(" ");
//			for (int i = 1; i < arry.length; i ++) {
////				if (arry[i] != 0)
//				System.out.print(arry[i] + " ");
//				
//			}
//			System.out.println(" ");
		}
	}
	
	static void makingArraywithSum(int[] array) {
		int S = array.length;
		
		for (int i = 1; i < array.length; i++) {
			nArray[i + array.length] = array[i];
//			System.out.println("i = " + i + " " + array[i]);
		}
		
        for (int i = S; i <= S *2 - 1; i++) {
            int P = i / 2;
            if (P == 2) {System.out.println("LMK");}
            		
            while (P != 0) {
            	nArray[P] = nArray[P] + nArray[i];
                P /= 2;
            }
        }		
		
	}
	static void makingTree(int[] array) {
		
		for (int i = 1; i < array.length; i ++) {
			tree[i] = new Node(array[i],i);
		}

		
		tree[10] = new Node(2,10);
		tree[10].left = tree[1];
		tree[10].right = tree[2];
		
		tree[11] = new Node(1,11);
		tree[11].left = tree[3];
		tree[11].right = tree[4];
		
		
		tree[12] = new Node(1,12);
		tree[12].left = tree[5];
		tree[12].right = tree[6];
		
		
		tree[13] = new Node(2,13);
		tree[13].left = tree[7];
		tree[13].right = tree[8];
		
		
		tree[14] = new Node(1,14);
		tree[14].left = tree[9];
		
		
		tree[15] = new Node(3,15);
		tree[15].left = tree[10];
		tree[15].right = tree[11];
		
		
		tree[16] = new Node(3,16);
		tree[16].left = tree[12];
		tree[16].right = tree[13];
		
		tree[17] = new Node(1,17);
		tree[17].left = tree[14];
		
		tree[18] = new Node(6,18);
		tree[18].left = tree[15];
		tree[18].right = tree[16];
		
		tree[19] = new Node(1,19);
		tree[19].left = tree[17];
		
		tree[20] = new Node(7,20);
		tree[20].left = tree[18];
		tree[20].right = tree[19];		
		
//		for (int i = 10; i < tree.length; i ++) {
//			System.out.println("index= " + tree[i].index + " value= " + tree[i].value + "left child index= " + tree[i].left.index  + "right child index= " + tree[i].right.index); 
//		}
	}	
	
	static int Search(int k) {
		Node current = tree[20];
		
		while ((current.right != null) || (current.right != null)) {
			if (current.left.value >= k) {
				current = current.left;
			} else {
				k = k - current.left.value;				
				current = current.right;
			}
			
//			System.out.println(current.index);
		}
		
		return current.index;
	}

}
