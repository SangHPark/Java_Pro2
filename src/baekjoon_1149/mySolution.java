package baekjoon_1149;
//Another disappoint, after looking solution ...
public class mySolution {

	static int N = 3;
	static int[][] costs = 
			{
				{26, 40, 83},
				{49, 60, 57},
				{13, 89, 99}
			};
	
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp = new int[N][N];
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				if (i == 0)	dp[0][j] = costs[0][j];
				else dp[i][j] = 987654321;
			}
		}
		
		for (int i = 1; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				for (int k = 0; k < N; k ++) {
					if (j != k)	dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i-1][k]);
				}
			}
		}
		
		
//		for (int i = 0; i < N; i ++) {
//			for (int j = 0; j < N; j ++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println(" ");
//		}
	
		int answer = 987654321;
		
		for (int j = 0; j < N; j ++) {
			if (answer >= dp[N-1][j]) answer = dp[N-1][j];
		}
		
		System.out.println(answer);
	}
}
