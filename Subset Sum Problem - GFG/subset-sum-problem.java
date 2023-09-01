//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][]=new int[N][sum+1];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        return func(sum,0,arr,N,dp);
    }
    public static boolean func(int sum,int ind, int arr[],int N,int dp[][])
    {
        if(ind>=N ||dp[ind][sum]==0 )
        return false;
        if(dp[ind][sum]==1)
        return true;
        if(sum==arr[ind])
        {
            dp[ind][sum]=1;
            return true;
        }
        boolean take=false,nottake=false;
       if(sum> arr[ind])
        {
            take=func(sum-arr[ind],ind+1,arr,N,dp);
         
        }
            nottake=func(sum,ind+1,arr,N,dp);
            if(nottake || take)
            {
                dp[ind][sum]=1;
                return true;
            }
            else
            {
            dp[ind][sum]=0;
            return false;
            }
        
        
    }
}