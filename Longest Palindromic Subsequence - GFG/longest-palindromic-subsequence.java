//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        int len=S.length();
        int dp[][]=new int[len][len];
        for(int i=0;i<len;i++)
        Arrays.fill(dp[i],0);
        for(int i=len-1;i>=0;i--)
            {
        for(int j=0;j<len;j++)
        {
                if(i>j)
                continue;
                else
                {
                    if(S.charAt(j)!=S.charAt(i))
                    {
                        if(i<len-1)
                        dp[i][j]=Math.max(dp[i][j],dp[i+1][j]);
                        if(j>0)
                        dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
                        
                    }
                    else
                    {
                        if(j>0 && i<len-1)
                        dp[i][j]=dp[i+1][j-1];
                        if(j==i)
                        dp[i][j]+=1;
                        else
                        dp[i][j]+=2;
                        
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}