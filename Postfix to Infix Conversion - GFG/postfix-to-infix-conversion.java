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
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st=new Stack<String>();
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(isalpha(ch))
            {
                st.push(ch+"");
            }
            else
            {
                String s1=st.pop();
                String s2=st.pop();
                st.push('('+s2+ch+s1+')');
            }
        }
        return st.pop();
    }
    static boolean isalpha(char ch)
    {
        int num=(int)ch;
        if((num<=122 && num>=97)||(num<=90 && num>=65))
        return true;
        else
        return false;
    }
}
