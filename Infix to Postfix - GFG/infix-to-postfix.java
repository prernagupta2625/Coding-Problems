//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st=new Stack<Character>();
        String ans="";
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            int num=(int)ch;
            if((num>=65 && num<=90 )||(num>=97 && num<=122))
            {
                ans=ans+ch;
            }
            else if(ch=='1'||ch=='0'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9')
            ans=ans+ch;
            else
            {
                if(st.isEmpty())
                {
                    st.push(ch);
                }
                else if(ch=='^')
                {             while(!st.isEmpty())
                            {
                                if(st.peek()=='^')
                                {
                                    ans=ans+st.pop();
                                    
                                }
                                else
                                break;
                                
                            }
                st.push(ch);
                }
                else
                {
                    if((ch=='*' || ch=='/')&& (st.peek()=='+' || st.peek()=='-' )) 
                    {
                        st.push(ch);
                    }
                    else 
                    {
                        
                        if(ch=='/'|| ch=='*')
                        {
                            while(!st.isEmpty())
                            {
                                if(st.peek()=='+'||st.peek()=='-'||st.peek()=='(')
                                {
                                    
                                    break;
                                }
                                else
                                {
                                    ans=ans+st.pop();
                                }
                            }
                            st.push(ch);
                        }
                        else if(ch=='+'|| ch=='-')
                        {
                             while(!st.isEmpty())
                            {
                                if(st.peek()=='(')
                                {
                                   
                                    break;
                                }
                                else
                                {
                                    ans=ans+st.pop();
                                }
                            }
                            st.push(ch);
                        
                        }
                        else if(ch=='(')
                        st.push(ch);
                        else if(ch==')')
                        {
                           
                             while(!st.isEmpty())
                            {
                                if(st.peek()=='(')
                                {
                                    st.pop();
                                    break;
                                }
                                else
                                {
                                    
                                    ans=ans+st.pop();
                                     
                                }
                                
                            }
                        }
                    }
                }
            }
            
        }
        if(!st.isEmpty())
        {
            while(!st.isEmpty())
            {
                ans=ans+st.pop();
            }
        }
        return ans;
    }
}