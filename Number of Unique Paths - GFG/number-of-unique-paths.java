//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int n, int m) 
    {
        //Your code here
         int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
            return func(n,m,0,0,dp);
    }
     public static int func(int n,int m,int r,int c,int dp[][])
    {
        
        if(r==n-1 && c==m-1)
        return 1;
        if(dp[r][c]!=-1)
        return dp[r][c];
        int down=0,right=0;
        if(r+1<n )
        down =func(n,m,r+1,c,dp);
        if(c+1<m )
        right= func(n,m,r,c+1,dp);
        dp[r][c]=(down+right)%1000000007;
        //System.out.println(dp[r][c]+" r "+r+" c "+c);
        return dp[r][c];
        
    }
    
}