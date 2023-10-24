//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int k) {
        
        int max=-1,ans=-1;
        for(int i:nums)
        max=Math.max(max,i);
        
        int low=1,high=max;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int n=func(nums,mid);
            if(n<=k)
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
        
        
    }
    public static int func(int nums[],int mid)
    {
        int sum=0;
        for(int i:nums)
        {
            sum=sum+i/mid;
            if(i%mid!=0)
            sum+=1;
        }
          return sum;
    }
  
}