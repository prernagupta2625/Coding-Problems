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
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int n, int target){
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0,count=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
            if(sum==target)
            {
              if(hm.containsKey(0))
              count=count+hm.get(0);
              count++;
            }
            else
            {
                if(hm.containsKey(sum-target))
                {
                    count+=hm.get(sum-target);
                }
                
            }
            if(hm.containsKey(sum))
                {
                    hm.put(sum,hm.get(sum)+1);
                }
                else
                {
                    hm.put(sum,1);
                }
        }
        return count;
    }
}