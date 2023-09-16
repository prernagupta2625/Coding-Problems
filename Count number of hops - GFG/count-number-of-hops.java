//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
        long dp[]=new long[n+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        int a,b,c;
        for(int i=1;i<n+1;i++)
        {
            a=i-1;
            b=i-2;
            c=i-3;
            if(a>-1)
            dp[i]=(dp[i]+dp[a])%1000000007;
            if(b>-1)
            dp[i]=(dp[i]+dp[b])%1000000007;
            if(c>-1)
            dp[i]=(dp[i]+dp[c])%1000000007;
            
        }
        return dp[n];
    }
   
}

