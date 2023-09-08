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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int len1=str1.length(),len2=str2.length();
	    int dp[][]=new int[len1][len2];
	    char ch=str1.charAt(0);
	   
	    for(int i=0;i<len1;i++)
	    {
	        for(int j=0;j<len2;j++)
	        {
	            if(str1.charAt(i)==str2.charAt(j))
	            {
	                if(i>0 && j>0)
	                dp[i][j]=1+dp[i-1][j-1];
	                else
	                dp[i][j]=1;
	            }
	            else
	            { 
	                if(i>0)
	                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
	                if(j>0)
	                dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
	            }
	        }
	    }
	    return len1+len2-2*dp[len1-1][len2-1];
	} 
}