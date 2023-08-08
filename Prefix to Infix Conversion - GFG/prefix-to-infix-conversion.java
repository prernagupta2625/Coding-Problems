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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st=new Stack<String>();
        for(int i=pre_exp.length()-1;i>=0;i--)
        {
            char ch=pre_exp.charAt(i);
            if(isalpha(ch))
            st.push(ch+"");
            else
            {
                String s1=st.pop();
                String s2=st.pop();
                st.push('('+s1+ch+s2+')');
            }
        }
        return st.pop();
    }
    static boolean isalpha(char ch)
    {
        int num=(int )ch;
        if((num>=65 && num<=90)||(num>=97 && num<=122))
        return true;
        else
        return false;
    }
}
