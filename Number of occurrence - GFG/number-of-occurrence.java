//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int u= upper(0,n-1,x,arr,n);
        int l=lower(0,n-1,x,arr);
        //System.out.println(u+" "+l);
        return u-l-1;
    }
    public static int lower(int beg,int end,int x,int arr[])
    {
        if(end<beg)
        return -1;
        int mid=(end+beg)/2;
        if(arr[mid]<x)
        {
            int ind=lower(mid+1,end,x,arr);
            if(ind>mid)
            return ind;
            else
            return mid;
        }
        else
        return lower(beg,mid-1,x,arr);
    }
    public static int upper(int beg,int end,int x,int arr[],int n)
    {
        if(end<beg)
        return n;
        int mid=(end+beg)/2;
        if(arr[mid]>x)
        {
            int ind=upper(beg,mid-1,x,arr,n);
            if(ind<mid)
            return ind;
            else
            return mid;
        }
        else
        return upper(mid+1,end,x,arr,n);
    }
}