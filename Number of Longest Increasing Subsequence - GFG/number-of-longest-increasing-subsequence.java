//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int arr[]){
        // Code here
        int dp[]=new int[N];
        int count[]=new int[N];
        int prev[]=new int[N];
        Arrays.fill(dp,1);
        Arrays.fill(count,0);
        int max=0,c=0;
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                if(dp[i]==dp[j]+1)
                {
                    count[i]=count[i]+count[j]+1;
                }else if(dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                     max=Math.max(dp[i],max);
                     count[i]=count[j];
                }
                }
            }
        }
        //for(int i=0;i<N;i++)
       // System.out.println(dp[i]+""+count[i]);
        for(int i=0;i<N;i++)
        {
            
            if(dp[i]==max)
        {c+=count[i];
        c++;
        }
        }
        return c;
    }
}