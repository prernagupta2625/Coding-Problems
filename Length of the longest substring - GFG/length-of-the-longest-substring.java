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
        int left=0,right=-1,max=0;
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            if(hm.containsKey(ch))
            {
                while(left<=right)
                {
                    char c=S.charAt(left);
                    if(S.charAt(left)==ch)
                    {
                        hm.remove(ch);
                        left++;
                        break;
                    }
                    else
                    {
                        if(hm.containsKey(S.charAt(left)))
                       {  if(hm.get(c)==1)
                       hm.remove(c);
                       else
                           hm.put(c,hm.get(c)-1);
                       }
                        
                        left++;
                    }
                    
                }
                
            }
        
            hm.put(ch,1);
            right=i;
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}