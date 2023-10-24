//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] nums, int N, int D) {
        // code here
        int max=-1,sum=0;
        for(int i: nums)
        {
            max=Math.max(max,i);
            sum=sum+i;
        }
        int low=max,high=sum,ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int n=func(nums,mid);
            if(n<=D)
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
        int d=0,i=0;
        while(i<nums.length)
        {
           
            if(nums[i]<=mid)
            {
                 int h=mid;
                while(h>0 && i<nums.length)
                {
                    if(nums[i]<=h)
                    {
                        
                        h-=nums[i];
                        i++;
                    }
                    else
                    break;
                }
                d++;
            }
           else
           return Integer.MAX_VALUE;
        }
        return d;
    }
};