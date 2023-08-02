//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int ind=0;
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        int start=0,end=nums.length-1;
        ind=0;
        int arr[]=new int[nums.length];
        func(nums,start,end,arr);
        return arr;
        
    }
    public static void func(int nums[],int start,int end,int arr[])
    {
        if(start>end)
        return;
        
        int mid=(start+end)/2;
        arr[ind]=nums[mid];
        ind++;
        func(nums,start,mid-1,arr);
        func(nums,mid+1,end,arr);
        
        
    }
}