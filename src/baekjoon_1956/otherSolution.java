package baekjoon_1956;


	import java.io.*;
	import java.util.Arrays;
	import java.util.StringTokenizer;

	public class otherSolution {
		
	    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    // ���Ѵ븦 ���Ѵ�. ��ΰ� ���ٴ� ��
	    // |V - 1| * �ִ� �Ÿ� �� �ִ� �Ÿ��� �ȴ�.
	    private static final int INF = 400 * 10_000;
	    static int v, e, result = INF;
	    static int arr[][];

	    public static void main(String[] args) throws IOException {
	    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\baekjoon_1956\\mySolution.txt"));
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        v = Integer.parseInt(st.nextToken());
	        e = Integer.parseInt(st.nextToken());
	        // �׷��� ������ �����Ѵ�.
	        arr = new int[v + 1][v + 1];
	        // �ʱ⿡�� ��ΰ� ���� ��ó�� ���Ѵ�� �����Ѵ�.
	        for(int i = 0; i <= v; i++)
	            Arrays.fill(arr[i], INF);

	        // �Է� ���� ���� �׷��� ����
	        for(int i = 0 ; i < e; i++){
	            st = new StringTokenizer(br.readLine());
	            int start = Integer.parseInt(st.nextToken());
	            int end = Integer.parseInt(st.nextToken());
	            int dist = Integer.parseInt(st.nextToken());

	            arr[start][end] = Math.min(arr[start][end], dist);
	        }

	        // �÷��̵� �ͼ�
	        for(int i = 1; i <= v; i++){
	            for(int j = 1; j <= v; j++){
	                for(int k = 1; k <= v; k++){
	                    if(arr[j][k] > arr[j][i] + arr[i][k]){
	                        arr[j][k] = arr[j][i] + arr[i][k];
	                    }
	                }
	            }
	        }

	        // �ּ� ����Ŭ �� �ּڰ��� ���Ѵ�.
	        for(int i = 1 ; i <= v; i++)
	            result = Math.min(arr[i][i], result);

	        // �ּڰ��� INF ��� ��ΰ� ���ٴ� ���̴�.
	        if(result == INF) bw.write("-1\n");
	        // �ּڰ��� INF�� �ƴ϶�� ��ΰ� �ִٴ� ���̹Ƿ� �ּڰ��� ����Ѵ�.
	        else bw.write(result + "\n");

	        bw.close();
	        br.close();
	    }
	}
	
