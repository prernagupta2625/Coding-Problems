//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int dp[][]=new int[N][N];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        int maxsum=-1;
        for(int i=0;i<N;i++)
        maxsum=Math.max(maxsum,func(N,Matrix,0,i,dp));
        return maxsum;
    }
    public static int func(int N,int Matrix[][],int r,int c,int[][]dp)
    {
        if(r==N-1)
        return Matrix[r][c];
        if(dp[r][c]!=-1)
        return dp[r][c];
        int dl=0,dd=0,dr=0;
        if(c-1>=0)
        dl=func(N,Matrix,r+1,c-1,dp);
        if(c+1<N)
        dr=func(N,Matrix,r+1,c+1,dp);
        dd=func(N,Matrix,r+1,c,dp);
        int max= Matrix[r][c]+Math.max(dl,Math.max(dd,dr));
        dp[r][c]=max;
        return max;
        
    }
}