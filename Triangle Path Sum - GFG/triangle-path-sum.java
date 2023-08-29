//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return func(n,grid,0,0,dp);
    }
    public static int func(int n,ArrayList<ArrayList<Integer> > grid,int r,int c,int[][] dp)
    {
        if(r==n-1)
        return grid.get(r).get(c);
        
        if(dp[r][c]!=-1)
        return dp[r][c];
        
        int dd=0,dr=0;
        dd=func(n,grid,r+1,c,dp);
        dr=func(n,grid,r+1,c+1,dp);
        int min= grid.get(r).get(c)+Math.min(dd,dr);
        dp[r][c]=min;
        return dp[r][c];
        
    }
}