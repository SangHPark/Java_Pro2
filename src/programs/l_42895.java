package programs;

public class l_42895 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(5, 12);
		
		dfs(0,0);
	}

	static int dfs(int i, int k) {
		if (i == 10) return -1;
				
		for (k = 0; k < 10; k++ ) {
			dfs(i + 2, k);
			dfs(i + 3, k);
		}
		
		return 1000;
	}
    static int solution(int N, int number) {
        int answer = 0;
        int nN = 0;
        boolean outloop = false;

        do {
        	number = number - N;
        	nN ++;
        	if (number < N ) {outloop = true;};
        	
        } while (!outloop);
        
        System.out.println(nN);        
//        12 - 5 = 7 - 5 = 2 - (5/5) = 1 - (5/5)
        
        String newN = Integer.toString(N) + Integer.toString(N);
        number = Integer.parseInt(newN);
        
        
        
        System.out.println(number);
        
        return answer;
    }	
}
