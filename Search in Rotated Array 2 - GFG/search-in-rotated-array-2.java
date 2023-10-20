//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine().trim());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int Key;
            Key = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int N, int[] nums, int target) {
        // code here
        int m=0;
        if(N>1)
        for(int i=0;i<N-1;i++)
        if(nums[i]>nums[i+1])
        m=i;
        return (func(nums,target,0,m) || func(nums,target,m+1,N-1));
    }
    public static boolean func(int nums[],int target,int beg,int end)
    {
        if(beg>end)
        return false;
        int mid=(beg+end)/2;
        if(nums[mid]==target)
        return true;
        else if(nums[mid]<target)
        return func(nums,target,mid+1,end);
        else
        return func(nums,target,beg,mid-1);
    }
}
        
