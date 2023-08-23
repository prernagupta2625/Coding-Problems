//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ans=new ArrayList<>();
        func(n,n,0,"",ans);
        return ans;
        
    }
    public static void func(int n,int total,int c,String s,List<String> list)
    {
        if(s.length()==2*total)
        {
            list.add(s);
            return;
        }
        
        if(n>0)
        {
            func(n-1,total,c+1,s+"(",list);
            
        }
        if(c>0)
        {
        //System.out.println("c "+c+" n"+n+" str "+s);
        func(n,total,c-1,s+")",list);
        }
        
        
        
    }
}