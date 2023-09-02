//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int len) {
        //code here
        int dp[][]=new int[price.length][len+1];
        for(int i=0;i<price.length;i++)
         Arrays.fill(dp[i],-1);
         return func(price,price.length,0,len,dp);
    }
    public static int func(int price[],int n,int ind,int len,int dp[][])
    {
        if(len==0)
        return 0;
        if(len<0)
        return -100000000;
        if(ind>=n)
        return -100000000;
        if(dp[ind][len]!=-1)
        return dp[ind][len];
        int take=0,notake=0;
        if(len>=ind+1)
        take=price[ind]+func(price,n,ind,len-ind-1,dp);
        notake=func(price,n,ind+1,len,dp);
        dp[ind][len]=Math.max(take,notake);
        return dp[ind][len];
    }
    
}