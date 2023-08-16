//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        
        HashMap<Character,Integer> hm=new HashMap<>();
        int start=0,end=0,max=0;
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            if(hm.containsKey(ch))
            {
               while(hm.containsKey(ch))
               {
                   hm.remove(S.charAt(start++));
                   
               }
               end=i;
               hm.put(ch,i);
            }
            else
            {
                hm.put(ch,i);
                end=i;
            }
            //System.out.println("start"+start+"end"+end);
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}