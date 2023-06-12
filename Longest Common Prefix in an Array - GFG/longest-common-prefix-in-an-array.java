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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        Arrays.sort(arr);
        String c=arr[0];
        for(int i=1;i<arr.length;i++)
       { 
           String str=arr[i];
           int len=Math.min(c.length(),str.length());
           c=c.substring(0,len);
           for(int j=0;j<len;j++)
           {
               if(c.charAt(j)!=str.charAt(j))
               {
                   c=c.substring(0,j);
                   break;
               }
           }
       }
       
       if(c.length()==0)
       return "-1";
       else
       return c;
        
        
    }
}