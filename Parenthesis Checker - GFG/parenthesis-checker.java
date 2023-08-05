//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<x.length();i++)
        {
            char ch=x.charAt(i);
            if(st.isEmpty() || ch=='('|| ch=='{'|| ch=='[')
            st.push(ch);
            else
            {
                 if((st.peek()=='(' && ch==')')||(st.peek()=='{' && ch=='}')||(st.peek()=='[' && ch==']'))
                st.pop();
                else
                return false;
            }
        }
        if(st.isEmpty())
        return true;
        else
        return false;
    }
}
