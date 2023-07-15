//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    static int mid;
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        mid=0;
        delete(0,s);
    } 
    static void delete(int len,Stack<Integer> s)
    {
        int num;
        if(!s.empty())
        {
            len=len+1;
            num=s.pop();
            delete(len,s);
        }
        else
        {
            mid=len/2+1;
           // System.out.println("mid"+mid);
            return;
        }
        
        if(len!=mid)
        {
            //System.out.println("len"+len+"val"+num);
            s.push(num);
        }
    }
}

