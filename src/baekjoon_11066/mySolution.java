package baekjoon_11066;

//Not Even Close
public class mySolution {

	static int[][] d;
	static int[] chapter = {40,30,30,50};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		d = new int[5][5];
		
		System.out.println(dp(4, chapter));
	}

	static int dp(int i, int[] chapter) {
		if (i == 1) return chapter[0];
		
		int start = 1;
		int end = 150;
		
		for (int gap = 1;  gap < end-start; gap ++ )  {
			for (int mid = 1; mid < end; mid ++ ) {
				for (int p = 1; p < end; p ++) {
					
				}
			}
		}

		return -1;
	}
}
