//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return func(arr,dp,n,0);
    }
    public static int func(int arr[],int dp[],int n,int ind)
    {
        if(ind>=n)
        return 0;
        if(dp[ind]!=-1)
        return dp[ind];
        if(ind==n-1)
        return arr[n-1];
        if(ind==n-2)
        return Math.max(arr[n-1],arr[n-2]);
        int val2=arr[ind]+func(arr,dp,n,ind+2);
        int val=func(arr,dp,n,ind+1);
        
        int max=Math.max(val,val2);
        dp[ind]=max;
        return max;
    }
}