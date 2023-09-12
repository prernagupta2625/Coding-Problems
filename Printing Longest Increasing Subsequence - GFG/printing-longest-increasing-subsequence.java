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
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int a[]){
        // Code here
            int dp[]=new int[n];
              int prev[]=new int[n];
               int maxind=0,max=1;
              Arrays.fill(dp,1);
              Arrays.fill(prev,-1);
              
                  for(int j=1;j<n;j++)
                  {
                      for(int i=0;i<j;i++)
              {
                      if(a[j]>a[i])
                      {
                          if(dp[i]+1>dp[j])
                          {
                              dp[j]=dp[i]+1;
                              prev[j]=i;
                          }
                           if(dp[j]>max)
                  {
                      max=dp[j];
                      maxind=j;
                  }
                      }
                  }
              }
            //  for(int i=0;i<n;i++)
            //  System.out.print(prev[i]+" ");
             
              ArrayList<Integer> list=new ArrayList<>();
              while(maxind!=-1)
              {
                  list.add(0,a[maxind]);
                  maxind=prev[maxind];
              }
              return list;
    }
}
