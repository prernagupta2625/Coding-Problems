//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        int dp[][]=new int[N][3];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
       return Math.max(func(points,N,0,2,dp),
       Math.max(func(points,N,0,0,dp),
       func(points,N,0,1,dp))) ;
        
    }
    public static int func(int points[][],int N,int ind,int c,int dp[][])
    {
        if(ind==N)
        return 0;
        if(dp[ind][c]!=-1)
        return dp[ind][c];
        int a,b;
        if(c==0)
        {
            a=1;
            b=2;
        }
        else if(c==1)
        {
            a=0;
            b=2;
        }
        else
        {
            a=0;
            b=1;
        }
        int max=Math.max(points[ind][c]+func(points,N,ind+1,a,dp),points[ind][c]+
        func(points,N,ind+1,b,dp));
        dp[ind][c]=max;
        //System.out.println("ind "+ind+" c"+c+" "+dp[ind][c]);
        return dp[ind][c];
        
    }
}