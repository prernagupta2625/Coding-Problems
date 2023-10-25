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

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
       
        Arrays.sort(stalls);
        int low=1,high=stalls[n-1]-stalls[0],ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(func(stalls,k,mid))
            {
                ans=mid;
                low=mid+1;
            }
            else
            high=mid-1;
            //System.out.println("mid "+mid+" ans "+ans);
        }
        return ans;
    }
    public static boolean func(int stalls[],int k,int mid)
    {
        int prev=stalls[0],count=1;
        for(int i=1;i<stalls.length;i++)
        {
            // System.out.println(stalls[i]+" "+prev+" "+mid);
            if((stalls[i]-prev)>=mid)
            {
                prev=stalls[i];
                count++;
            
            }
           
        }
       // System.out.println(" count "+count);
        if(count>=k)
        return true;
        else
        return false;
    }
}