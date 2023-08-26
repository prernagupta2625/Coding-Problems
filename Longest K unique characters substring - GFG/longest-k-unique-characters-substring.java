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
        int max=-1,left=0,right;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(hm.containsKey(ch))
            hm.put(ch,hm.get(ch)+1);
            else
            hm.put(ch,1);
            right=i;
            if(hm.size()==k)
            max=Math.max(max,right-left+1);
            else if(hm.size()>k)
            {
                while(hm.size()>k && left<right)
                {
                    
                    if(hm.get(s.charAt(left))==1)
                    {
                        hm.remove(s.charAt(left));
                       // System.out.println(s.charAt(left));
                        
                    }
                    else
                    hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                    left++;
                }
               // System.out.println(left+"size"+hm.size());
            }
        }
        return max;
    }
}