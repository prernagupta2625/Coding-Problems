//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int count=0,left=0,right=0,len=0,maxlen=-1;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(hm.containsKey(ch))
            hm.put(ch,hm.get(ch)+1);
            else if(hm.size()==k)
            {
                while(hm.size()==k)
                {
                    char c=s.charAt(left);
                    if(hm.containsKey(c))
                    {
                        if(hm.get(c)==1)
                        hm.remove(c);
                        else
                        hm.put(c,hm.get(c)-1);
                    }
                    left++;
                    len--;
                }
                hm.put(ch,1);
                
            }
            else
            hm.put(ch,1);
                len++;
                if(hm.size()==k)
                maxlen=Math.max(maxlen,len);
                right=i;
                
        }
        return maxlen;
        
        
        
    }
}