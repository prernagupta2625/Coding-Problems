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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
   // Your code goes here
	    int c[]=new int[1];
	    int dp[][]=new int[sum+1][n];
	    for(int[] row: dp)
	    Arrays.fill(row,-1);
	    return count(arr,sum,n-1,dp);
	   
	} 
	public static int count(int arr[],int sum,int ind,int dp[][])
	{
	  
	   if(ind==0)
	   {
	       if(sum==arr[0] && arr[0]==0)
	       return 2;
	       if(sum==0 || sum==arr[0])
	       return 1;
	       return 0;
	   }
	   if(dp[sum][ind]!=-1)
	   return dp[sum][ind];
	   int np=count(arr,sum,ind-1,dp);
	   int pick=0;
	   if(arr[ind]<=sum)
	   pick=count(arr,sum-arr[ind],ind-1,dp);
	   int ans=(pick%1000000007+np%1000000007)%1000000007;
	   /* if(sum==0)
	   {
	       if(arr[ind]==0)
	       ans=ans+ 2;
	       else
	       ans=ans+1;
	   }*/
	   ans%=1000000007;
	   dp[sum][ind]=ans;
	   //System.out.println("Ans"+ans+ " ind"+ind);
	   return ans;
	   
	   
	   
	}
}