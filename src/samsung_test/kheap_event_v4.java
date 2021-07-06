package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//Lastest Version
public class kheap_event_v4 {

    private static int [] tree;
    private static int T;
    private static int Q;
    private static int base;
    
    public static void main(String args []) throws NumberFormatException, IOException
    {
//    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0041_kheap_event.txt"));   
    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\sample_input_kheap.txt"));
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
           base=1;
           while(base<100000)
           {
                 base*=2;
           }
           int answer;
           
           T = Integer.parseInt(bf.readLine()); //cases
           for(int i=1;i<T+1;i++)
           {
                 tree = new int[base*2];
                 
                 Q = Integer.parseInt(bf.readLine()); //Query
                 System.out.print("#" + i);
                 for(int j=0;j<Q;j++)
                 {
                       String [] qry = bf.readLine().split(" ");
                       int act = Integer.parseInt(qry[0]);
                       int k = Integer.parseInt(qry[1]);
                       if(act== 1)
                       {
                             int node = base + k;
                             tree[node]++;
                             Update(node, 1);
                       }
                       else
                       {
                    	   answer=Search(k);
                           System.out.print(" " + answer);
                           tree[base+answer] --;
                           Update(base + answer , -1);
                       }
                 }
                 System.out.println(" ");
           }
    }
    
    private static void Update(int node, int diff)
    {
           while(node!= 1)
           {
                 node /=2; //parent of node
                 tree[node] += diff;
           }
    }
    
    private static int Search(int k)
    {
           int node=1; //root
           while(node < base)
           {
                 int left = node*2;
                 int right = left+1;

                 if(tree[left]>=k)
                 {
                       node = left;
                 }
                 else
                 {
                       k = k - tree[left];
                       node = right;
                 }
           }

           return node-base;
    }
}


