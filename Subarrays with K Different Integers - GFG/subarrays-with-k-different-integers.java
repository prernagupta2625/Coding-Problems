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
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int subarrayCount(int arr[], int N, int k) {
    // code here\
   int n1=func(arr,N,k);
   int n2=func(arr,N,k-1);
   //System.out.println(n1+"heelo"+n2);
    return n1-n2;
    
  }
  public static int func(int arr[],int N,int k)
  {
       HashMap<Integer,Integer> hm=new HashMap<>();
       hm.clear();
       if(k==0)
       return 0;
     int left=0,count=0,right=0;
     for(int i=0;i<N;i++)
     {
         int n=arr[i];
        
         if(hm.containsKey(n))
         hm.put(n,hm.get(n)+1);
         else
         {
            
                 while(hm.size()==k && left<N)
                 {
                         int nleft=arr[left];
                         if(hm.containsKey(nleft))
                         {
                         if(hm.get(nleft)==1)
                         hm.remove(nleft);
                         
                         else
                         hm.put(nleft,hm.get(nleft)-1);
                         }
                         left+=1;
                         
                     
                 }
                 hm.put(n,1);
         }
         right=i;
        int m=right-left;
       
         count=count+m+1;
          //System.out.println("v"+count);
     }
     return count;
  }
}
     