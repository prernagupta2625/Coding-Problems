//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            int[] ans=obj.longestCommonPrefix(s1,s2);
            if(ans[0] == -1)
                System.out.println(ans[0]);
            else 
                System.out.println(ans[0]+" "+ans[1]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] longestCommonPrefix(String s1, String s2){
        //code here
        //int left=0,right=-1,len2=s2.length();
        int ans[]={-1,-1};
        int k,max=0,j;
        for(int i=0;i<s2.length()-1;i++)
        {
             k=i;
            for( j=0;j<s1.length();j++)
            {
                
                if(s1.charAt(j)!=s2.charAt(k))
                {
                    break;
                }
                else
                k++;
                max=Math.max(max,j+1);
                if(k>=s2.length())
                break;
            }
           
        }
        if(max>0)
        {
            ans[0]=0;
            ans[1]=max-1;
        }
        return ans ;
    }
}