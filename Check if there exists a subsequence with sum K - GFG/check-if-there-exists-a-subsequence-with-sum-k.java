//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here
     return check(arr,K,0,0);
  }
  public static boolean check(int arr[],int k,int sum,int ind)
  {   if(sum>k)
      return false;
      if(sum==k)
      return true;
      else if(ind==arr.length)
      return false;
      else
      return check(arr,k,sum+arr[ind],ind+1) || check(arr,k,sum,ind+1);
      
      
      
  }
}
     