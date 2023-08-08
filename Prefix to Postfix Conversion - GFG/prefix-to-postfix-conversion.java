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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        String s="";
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
               // st.push(st.pop()+st.pop()+ch);
               st.push(s1+s2+ch);
            }
        }
        return st.pop();
    }
    static boolean isalpha(char ch)
    {
        int num=(int)ch;
        if((num>=65 && num<=90) || (num>=97 && num<=122))
        return true;
        else
        return false;
    }
}
