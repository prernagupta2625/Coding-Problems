//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int N, int k)
    {
        // code here
        return func(arr,0,N-1,N,k);
    }
    public static int func(int arr[],int beg,int end,int N,int k)
    {
        if(end<beg)
        return 0;
        int mid=(beg+end)/2;
        if(arr[mid]==k)
        return mid;
        else if(arr[mid]<k)
        {
            int ind=func(arr,mid+1,end,N,k);
            if(ind==0)
            return mid+1;
            else
            return ind;
            
        }
        else
        return func(arr,beg,mid-1,N,k);
    }
}