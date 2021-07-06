package pkg8;

public class fibonacci {
	int[] d = new int[100];
	
	
	public Integer DP (Integer data) {
		if (data == 1 ) return 1;
		if (data == 2 ) return 1;
		
//		return DP (data - 1) + DP (data - 2);
		
		if(d[data] !=0 ) return d[data];
		
		return d[data] = DP (data - 1) + DP (data - 2);
		
	}
	
	public static void main (String args[]) {
		fibonacci myDP = new fibonacci();
		
		System.out.println(myDP.DP(30));
	}
}
