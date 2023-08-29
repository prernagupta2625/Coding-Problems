//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int totalWays(int n, int m, int grid[][]) {
        // Code here
         int dp[][]=new int[n][m];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(dp[i],-1);
            return func(n,m,grid,0,0,dp);
    }
     public static int func(int n,int m, int [][] grid,int r,int c,int dp[][])
    {
        if(grid[r][c]==1)
        return 0;
        if(r==n-1 && c==m-1)
        return 1;
        if(dp[r][c]!=-1)
        return dp[r][c];
        int down=0,right=0;
        if(r+1<n )
        down =func(n,m,grid,r+1,c,dp);
        if(c+1<m )
        right= func(n,m,grid,r,c+1,dp);
        dp[r][c]=(down+right)%1000000007;
        //System.out.println(dp[r][c]+" r "+r+" c "+c);
        return dp[r][c];
        
    }
}