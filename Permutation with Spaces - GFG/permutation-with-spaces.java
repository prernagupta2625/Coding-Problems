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
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        Solution obj=new Solution();
        ArrayList<String> arr=new ArrayList<>();
        obj.permute(S,0,arr,"",new HashSet<String>());
        return arr;
       
    }
    void permute(String s,int ind,ArrayList<String> arr,String str,HashSet<String> hs)
    {
        if(ind==s.length())
        {
            if(!hs.contains(str.trim()))
            {
                hs.add(str.trim());
                arr.add(str.trim());
            }
        }
        else
        {
            permute(s,ind+1,arr,str+s.charAt(ind)+" ",hs);
            permute(s,ind+1,arr,str+s.charAt(ind),hs);
            
        }
    }
    
}