//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int sum=0,count=0;
       HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
       for(int i=0;i<N;i++)
       {
           sum=sum+Arr[i];
           if(hm.containsKey(sum-k))
           {
               count+=hm.get(sum-k);
           }
           if(sum==k)
           count+=1;
           if(!hm.containsKey(sum))
           {
               hm.put(sum,1);
           }
           else
           {
               hm.put(sum,hm.get(sum)+1);
           }
           
           
       }
       return count;
    }
}