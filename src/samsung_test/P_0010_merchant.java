package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class P_0010_merchant {

	static int T;
	static int N;
	static boolean[] visited;
	static int[] level;
	static int[][] dp;
	
	static LinkedList<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0010_merchant.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T + 1; t ++) {
			N = Integer.parseInt(br.readLine());
			
			adjList = new LinkedList[N+1];
			visited = new boolean[N+1];
			level = new int[N+1];
			dp = new int[N+1][(int)Math.log(N)+1];
			
			for (int i = 1; i < N+1; i ++) {
				adjList[i] = new LinkedList<Integer>();
			}
			
			
			for (int i = 1; i < N; i ++) {
				String Input[] = br.readLine().split(" ");
				adjList[Integer.parseInt(Input[0])].add(Integer.parseInt(Input[1]));
				adjList[Integer.parseInt(Input[1])].add(Integer.parseInt(Input[0]));
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			int curr;
			q.offer(1);
			
			while(!q.isEmpty()) {
				curr = q.poll();
				visited[curr] = true;
				
				Iterator<Integer> it = adjList[curr].iterator();
				
				while(it.hasNext()) {
					int next = it.next();
//					System.out.println("next = " + next);
					
					if(!visited[next]) {
						level[next] = level[curr] + 1;
						dp[next][0] = curr;
						
						for (int a = 1; a <= (int)Math.log(N); a++) {
							
//							System.out.println(dp[next][a-1]);
							
							dp[next][a] = dp[dp[next][a-1]][a-1];
						}
						
						visited[next] = true;
						q.add(next);
						
					}
				}
			}
			
			
			int result = 0;
			for (int i = 1; i < N; i++) {
				int j = i + 1;
				int lca = LCA(i, j);
				
				int dist = level[i] - level[lca] + level[j] - level[lca];
				result += dist;
			}
			
			System.out.println("#" + t + " " + result);

		}
		
//		for (int i = 1; i < N+1; i ++) {
//			System.out.println("Level : " + level[i]);
//			for (int j = 0; j <= Math.log(N); j++) {
//				System.out.println("DP : " + " i = " + i + " j = " + j + ",  " + dp[i][j]);
//			}
//		}
		
//		System.out.println("LCD = " + LCA(1,2));
		

	}
	
    public static int LCA(int a, int b){
		//b가 a보다 아래 레벨을 가지도록 레벨을 비교하여 교환
		if(level[a]>level[b])
		{
			int tmp = b;
			b=a;
			a=tmp;
		}
		
		//b를 a의 높이까지 끌어 올리기
		for(int i=(int) Math.log(N);i>=0;i--)
		{
			if(level[b]-level[a]>=(1<<i))
			{
				b=dp[b][i];
			}
		}
		
		//a노드가 b노드의 조상인 경우 a리턴
		if(a==b)
			return a;
		
		//동시에 양쪽 위로 올리기
		for(int i=(int) Math.log(N);i>=0;i--)
		{
			if(dp[a][i] != dp[b][i])
			{
				a=dp[a][i];
				b=dp[b][i];
			}
		}
		return dp[a][0];
		
	}

}
