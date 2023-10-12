//{ Driver Code Starts
// Initial Template for Java

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
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
        // code here
        long sum=0,min=100000000;
        for(int i=0;i<N-k;i++)
        {
            sum=sum+(long)cardPoints[i];
        }
        min=Math.min(min,sum);
        long S=sum;
        for(int i=N-k;i<N;i++)
        {
            sum=sum+cardPoints[i]-cardPoints[i-N+k];
            min=Math.min(min,sum);
            S+=cardPoints[i];
        }
        return S-min;
    }
}
