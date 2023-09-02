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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    Arrays.sort(coins);
	    for(int i=0;i<M/2;i++)
	    {
	       int tmp=coins[i];
	       coins[i]=coins[M-i-1];
	       coins[M-i-1]=tmp;
	    }
	    int dp[][]=new int[M][V+1];
	    for(int i=0;i<M;i++)
	    Arrays.fill(dp[i],-1);
	    int ans= func(coins,M,V,V,0,dp);
	    if(ans==100000000)
	    return -1;
	    else
	    return ans;
	} 
	public static int func(int coins[],int M,int V,int sum,int ind,int dp[][])
	{
	   
	    if(sum==0 )
	    return 0;
	    if(ind>=M)
	    return 100000000;
	    if(dp[ind][sum]!=-1)
	    return dp[ind][sum];
	    int take=100000000,notake=100000000,repeat=100000000;
	    if(sum>=coins[ind])
	    {
	        int num=sum/coins[ind];
	        take=num+func(coins,M,V,sum-coins[ind]*num,ind+1,dp);
	        repeat=1+func(coins,M,V,sum-coins[ind],ind,dp);
	    }
	    
	    notake=func(coins,M,V,sum,ind+1,dp);
	    int min=Math.min(repeat,Math.min(take,notake));
	    dp[ind][sum]=min;
	    return min;
	    
	}
}