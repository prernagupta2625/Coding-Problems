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
        Stack<Character> s=new Stack<Character>();
        for(int j=0;j<x.length();j++)
        {
            s.push(x.charAt(j));
        }
        Stack<Character> emp=new Stack<Character>();
        Solution obj=new Solution();
       return obj.check(s,emp);
    }
    boolean check(Stack<Character> s,Stack<Character> emp)
    {
        while(!s.empty())
        {
            if(s.peek()==')'||s.peek()=='}'||s.peek()==']')
            emp.push(s.pop());
            else if(s.peek()=='('||s.peek()=='{'||s.peek()=='[')
            {
                if(emp.empty())
                return false;
                if((s.peek()=='('&& emp.peek()==')')||s.peek()=='{'&& emp.peek()=='}'||
               ( s.peek()=='['&& emp.peek()==']'))
                {
                    s.pop();
                    emp.pop();
                }
                else
                return false;
                
            }
        }
        if(s.empty()&&emp.empty())
        return true;
        else
        return false;
    }
}
