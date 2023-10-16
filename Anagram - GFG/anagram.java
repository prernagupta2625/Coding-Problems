//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        HashMap<Character,Integer> hm=new HashMap<>();
        if(a.length()!=b.length())
        return false;
        for(int i=0;i<a.length();i++)
        {
            char ch=a.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
        }
        for(int i=0;i<b.length();i++)
        {
            char ch=b.charAt(i);
            if(hm.containsKey(ch))
            {
                if(hm.get(ch)==1)
                hm.remove(ch);
                else
                hm.put(ch,hm.get(ch)-1);
                
            }
            else
            {
                return false;
            }
            
        }
        return true;
        
    }
}