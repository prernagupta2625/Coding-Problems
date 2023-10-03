//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        /*int num=(int)(Math.log((n*25)/26+1)/Math.log(26));
        if(num>0)
         n=n-(26/25*(int)Math.pow(26,num));
         System.out.println(num+" "+n);
        String str="";
        for(int i=num;i>=1;i--)
        {
            int v=(int)n/(int)Math.pow(26,i);
            System.out.println(v);
            str=str+(char)(65+v);
            n=n-v*(int)Math.pow(26,i);
            System.out.println("n"+n);
        }
        str=str+(char)(65+n-1);
        return str;*/
        String a="";
        while(n>0)
        {
            char b=(char)('A'+(n-1)%26);
            a=b+a;
            n=(n-1)/26;
        }
        return a;
        
    }
}