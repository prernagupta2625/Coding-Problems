//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x][y];
        for(int i=0;i<x;i++)
        Arrays.fill(dp[i],-1);
        return func(x,y,0,0,s1,s2,dp);
    }
    public static int func(int x,int y,int ind1,int ind2,String s1,String s2,int [][]dp)
    {
        if(ind1>=x || ind2>=y)
        return 0;
        if(dp[ind1][ind2]!=-1)
        return dp[ind1][ind2];
        int match=0,nomatch=0;
        if(s1.charAt(ind1)==s2.charAt(ind2))
        {
            dp[ind1][ind2]=1+func(x,y,ind1+1,ind2+1,s1,s2,dp);
        }
        else
        {
             dp[ind1][ind2]=Math.max(func(x,y,ind1+1,ind2,s1,s2,dp),func(x,y,ind1,ind2+1,s1,s2,dp));
        }
        
         return dp[ind1][ind2];
        
    }
    
}