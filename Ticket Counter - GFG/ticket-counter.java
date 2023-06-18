//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int k)
    {
        int start=1,end=N;
        while(true)
        {
            if(start==end)
            {
                return start;
            }
            else
            {
                for(int i=0;i<k;i++)
                {
                    start=start+1;
                     if(start==end)
            {
                return start;
            }
                }
                for(int i=0;i<k;i++)
                {
                    end=end-1;
                     if(start==end)
            {
                return start;
            }
                }
            }
        }
    }
}