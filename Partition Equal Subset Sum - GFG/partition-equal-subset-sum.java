//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(Integer t: arr)
        sum+=t;
        int dp[][]=new int[N][sum/2+1];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        if(sum%2!=0)
        return 0;
        else
        return func(N,arr,sum/2,0,dp);
    }
    public static int func(int N,int arr[],int s,int ind,int dp[][])
    {
        if(ind>=N || dp[ind][s]==0)
        return 0;
        if(s==arr[ind])
        {
            dp[ind][s]=1;
            return 1;
        }
        if(dp[ind][s]!=-1)
        {
            return 1;
        }
        int take=0,notake=0;
        if(s> arr[ind])
        {
            take=func(N,arr,s-arr[ind],ind+1,dp);
        }
        notake=func(N,arr,s,ind+1,dp);
        if(take==1 || notake==1)
        {
            dp[ind][s]=1;
            return 1;
        }
        else
        {
            dp[ind][s]=0;
            return 0;
        }
        
    }
}
