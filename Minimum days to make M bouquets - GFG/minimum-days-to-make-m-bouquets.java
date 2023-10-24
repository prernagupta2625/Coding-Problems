//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int k, int[] bloomDay) {
       int min=Integer.MAX_VALUE,max=-1;
       for(int i:bloomDay)
       {
           max=Math.max(max,i);
           min=Math.min(min,i);
       }
       int low=min,high=max,ans=-1;
       while(low<=high)
       {
           int mid=(low+high)/2;
           int n=func(bloomDay,mid,k);
           if(n>=M)
           {
               ans=mid;
               high=mid-1;
           }
           else
           low=mid+1;
       }
       return ans;
    }
    public static int func(int arr[],int mid,int k)
    {
        int count=0,f=0;
        for(int i:arr)
        {
           if(mid>=i)
           f++;
           else
           f=0;
           if(f==k)
           {
               count++;
               f=0;
           }
        }
        return count;
    }
}