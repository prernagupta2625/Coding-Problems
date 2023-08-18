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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bill[]) {
        // code here
        int ar[]=new int[2];
       
        for(int j=0;j<bill.length;j++)
        {
            int n=bill[j];
            if(n==5)
            ar[0]++;
            else if(n==10)
            {
                ar[1]++;
                if(ar[0]>0)
                    ar[0]--;
                    else
                    return false;
            }
            else
            {
                if(ar[0]>0 && ar[1]>0)
                {
                    ar[0]--;
                    ar[1]--;
                }
                else if(ar[0]>=3)
                ar[0]-=3;
                else
                return false;
                
            }
                
        }
        return true;
    }
}
