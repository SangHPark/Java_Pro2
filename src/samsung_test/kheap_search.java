package samsung_test;

public class kheap_search {

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
	
	static void makingTree(int[] array) {
		
		for (int i = 0; i < array.length; i ++) {
			tree[i+1] = new Node(array[i],i+1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int[] array = {1, 1, 0, 1, 1, 0, 0, 2, 1};
		
		
		
		makingTree(array);
		System.out.println(Integer.MAX_VALUE);
		
//		tree[1] = new Node(1,1);
//		tree[2] = new Node(1,2);
//		tree[3] = new Node(0,3);
//		tree[4] = new Node(1,4);
//		tree[5] = new Node(1,5);
//		tree[6] = new Node(0,6);
//		tree[7] = new Node(0,7);
//		tree[8] = new Node(2,8);
//		tree[9] = new Node(1,9);
		
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
		
		
		
//		Node root = new Node(7);
//		
//		Node leaf = new Node(1);
		
		Node current = tree[20];
		int K = 6;
		
		while ((current.right != null) || (current.right != null)) {
			if (current.left.value >= K) {
				current = current.left;
			} else {
				K = K - current.left.value;				
				current = current.right;
			}
			
			System.out.println(current.index);
		}
	}

}
