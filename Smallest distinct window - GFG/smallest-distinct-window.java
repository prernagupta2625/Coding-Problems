//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        HashMap<Character,Integer> hm=new HashMap<>();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            hs.add(str.charAt(i));
        }
        int k=hs.size(),right=-1,left=0,min=1000000;;
        for(int i=0;i<str.length();i++)
        {
           char ch=str.charAt(i);
           hm.put(ch,hm.getOrDefault(ch,0)+1);
           while(hm.size()>=k)
           {
               char c=str.charAt(left);
               if(hm.get(c)==1 && hm.size()==k)
               break;
               else
               {
                   if(hm.get(c)==1)
                   hm.remove(c);
                   else
                   hm.put(c,hm.get(c)-1);
               }
               left++;
           }
           right=i;
           if(hm.size()==k)
           min=Math.min(min,right-left+1);
        }
        return min;
    }
}