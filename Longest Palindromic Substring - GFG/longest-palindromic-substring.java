//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S){
        // code here
        int max=0;
        String ans="";
        for(int i=0;i<S.length();i++)
        {
            for(int j=i;j<S.length();j++)
            {
                int f=0;
                int n=j-i+1;
                int a,b;
                if(n%2==0)
                {
                   b=n/2;
                   a=b-1;
                }
                else if(n==1)
                {
                    a=j;
                    b=j;
                }
                else{
                    a=n/2-1;
                    b=n/2+1;
                }
                a+=i;
                b+=i;
                while(a>-1 && b>-1 && b<=j && a>=i)
                {
                    if(S.charAt(a)!=S.charAt(b))
                    {
                        f++;
                        break;
                    }
                   a--;
                   b++;
                
                }
                if(f==0)
                {if(j-i+1>max)
                {
                    max=j-i+1;
                    ans=S.substring(i,j+1);
                   // System.out.println(ans+" "+a+" "+b+" "+i+" "+j);
                }
                }
            }
          
        }
        return ans;
    }
}