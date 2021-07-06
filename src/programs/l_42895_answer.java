package programs;

import java.util.HashSet;
import java.util.Iterator;

public class l_42895_answer {

	static HashSet<Integer>[] dp = new HashSet[9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(5, 12));
		
//		
	}

	
    static int solution(int N, int number) {
    	
    	if (N == number) return 1;
    	
    	String n_ = String.valueOf(N);
    	
    	for (int i = 0; i <= 8; i++) {
    		dp[i] = new HashSet<Integer>();
    		if (i == 1) dp[1].add(Integer.parseInt(n_));
    		if (i < 2) continue;
    		
    		n_ += String.valueOf(N);
    		dp[i].add(Integer.parseInt(n_));
    		
    		for (int j =1; j < i; j++) {
    			calc (j, i);
    			
    			if (dp[i].contains(number)) {
    				return i;
    			}
    		}
    		
    	}
        
//        System.out.println(number);
        
        return -1;
    }	
    
    static void calc(int a, int b) {
    	Iterator<Integer> listA = dp[a].iterator();
    	Iterator<Integer> listB = dp[b-a].iterator();
    	
    	while(listA.hasNext()) {
    		int numA = listA.next();
    		while(listB.hasNext()) {
    			int numB = listB.next();
    			dp[b].add(numA + numB);
    			dp[b].add(numA - numB);
    			dp[b].add(numA * numB);
    			if (numB != 0) {
    				dp[b].add(numA / numB);
    			}
    		}
    		listB = dp[b-a].iterator();
    	}
    	
    }
}
