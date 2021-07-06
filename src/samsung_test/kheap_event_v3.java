package samsung_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class kheap_event_v3 {

    private static int [] tree;
    private static int root;
    private static int T;
    private static int Q;
    private static int base;
    
    public static void main(String args []) throws NumberFormatException, IOException
    {
    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0041_kheap_event.txt"));   
//    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\Downloads\\sample_input_kheap.txt"));
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
           base=1;
           while(base<9)
           {
                 base*=2;
           }
           int answer;
           
//           base = 15;
           T = Integer.parseInt(bf.readLine()); //cases
           for(int i=1;i<2;i++)
           {
                 tree = new int[base*2];
                 String result="";
                 StringBuilder sb = new StringBuilder();
                 
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
                             Update(node);
                       }
                       else
                       {
                             answer=Search(k);
                             System.out.print(" " + answer);
//                             sb.append(answer + " ");
//                             result += answer + " ";
//                             if (j >= 250000) 
//                             {
//                            	 System.out.println("LMK");
//                             }
//                             System.out.println("Q = "+j + " result " + result);
//                             System.out.println("#"+i+" " + sb.toString().trim());                             
                       }
                 }
//                 System.out.println("#"+i+" " + result.trim());
//                 System.out.println("#"+i+" " + sb.toString().trim());
                 System.out.println(" ");
           }
           
    }
    
    private static void Update(int node)
    {
//           tree[node] +=1;
           while(node!=1)
           {
                 //System.out.println(node + ":" + tree[node]);
                 node /=2; //parent of node
                 tree[node] +=1;
                 //System.out.println(node + ":" + tree[node]);
           }
    }
    
    private static int Search(int k)
    {
           int node=1; //root
           //tree[node] -=1;
           while(node<base)
           {
                 int left = node*2;
                 int right = left+1;

                 if(tree[left]>=k)
                 {
                       node = left;
                 }
                 else
                 {
                       k -= tree[left];
                       node = right;
                 }
//                 tree[node]--;
           }

           return node-base;
    }
}


