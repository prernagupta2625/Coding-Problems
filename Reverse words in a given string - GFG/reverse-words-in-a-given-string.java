//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here
        String str="";
        int f=0,ind=-1;
        S=' '+S;
        for(int i=S.length()-1;i>=0;i--)
        {
            char ch=S.charAt(i);
            if(ch=='.' || i==0)
            { if(ind==-1)
              str=str+S.substring(i+1);
              else
              str=str+S.substring(i+1,ind);
                ind=i;
                if(i!=0)
                str=str+'.';
            }
       
        }
        return str;
    }
}