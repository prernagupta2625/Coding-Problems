//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n=nums.length;
        int dp[]=new int[n];
        int dp2[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                if(dp[j]+1>dp[i])
                dp[i]=dp[j]+1;
                }
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(nums[i]>nums[j])
                {
                    dp2[i]=Math.max(dp2[i],dp2[j]+1);
                }
            }
        } 
        int max=0,maxind=-1;
        for(int i=0;i<n;i++)
        {
            
            //System.out.println(i+" "+dp[i]+" "+dp[2]);
            if(dp[i]+dp2[i]-1>max)
            {
                 max=Math.max(max,dp[i]+dp2[i]-1);
                 maxind=i;
            }
           
        }
        //System.out.println(maxind);
        return max;
    }
}