package programs;

public class l_68644 {
    static int[] myarray;
    static int k;
	public static void main(String[] args) {

	   int[] mytest = {2,1,3,4,1};
//	   int[] mytest = {5,0,2,7};
	   
	   solution(mytest);

	}
	
    static int[] solution(int[] numbers) {
        int[] answer = {};
        k = 0;
        
        myarray = new int[numbers.length * (numbers.length - 1) + 1];
        
        for (int i = 0; i < myarray.length; i ++) {
            myarray[i] = 999;
        }
        
        
        for (int i = 0; i < numbers.length  ; i ++) {
            for (int j = 0; j < numbers.length ; j ++ ) {
                if ( i != j) {
                	System.out.println(" i = " + i + " j = " + j + " new val = " + (numbers[i] + numbers[j]));
                	insert_array(numbers[i] + numbers[j]);
                }
            }
        }
        
        for (int i = 0; i < myarray.length; i ++) {
        	System.out.println(" " + myarray[i]);
        }
        
        for (int i = 0; i < myarray.length; i ++) {
        	for (int j = 0; j <  myarray.length -1; j++ ) {
        		if (myarray[j] > myarray[j+1]) {
        			int tmp = myarray[j];
        			myarray[j] = myarray[j+1];
        			myarray[j+1]= tmp;
        		}
        	}
        	
        }        

        int answer_idx = 0;
        
        for (int i = 0; i < myarray.length; i ++) {
        	if (myarray[i] != 999) {
        		answer_idx ++;
        	}
        }
        
        answer = new int[answer_idx];
        
        for (int i = 0; i < myarray.length; i ++) {
        	if (myarray[i] != 999) {
        		answer[i] = myarray[i];
        	}
        }
        
        for (int i = 0; i < answer.length; i ++) {
        	System.out.println(	answer[i]);

        }
        
        return answer;
    }
	
    static void insert_array(int newval) {
        if (!find(newval)) {
	            myarray[k] = newval;
	            k ++;
       }
    }
    
    static boolean find(int newval) {
    	for (int i = 0; i < myarray.length; i ++) {
    		if (myarray[i] == newval) return true;
    	}
    	
    	return false;
    }
}
