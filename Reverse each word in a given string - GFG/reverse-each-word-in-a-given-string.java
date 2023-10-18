//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        String str="",s="";
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            if(ch=='.' )
            {
                str=str+s+'.';
                s="";
            }
            else if( i==S.length()-1)
           { 
               s=ch+s;
               str=str+s;
           
           }
            else
            s=ch+s;
        }
        return str;
    }
}