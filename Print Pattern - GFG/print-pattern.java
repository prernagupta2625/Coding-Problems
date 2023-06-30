//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static List<Integer> pattern(int N){
        // code here
        Solution obj=new Solution();
        List<Integer> list=new ArrayList<>();
        list.add(N);
        return obj.calculate(N,true,list);
    }
    List<Integer> calculate(int N,boolean  val,List<Integer> list)
    {
        boolean pre;
        if(list.get(list.size()-1)==N && list.size()>1)
        return list;
        if(val==true)
        { 
            int sadh=list.get(list.size()-1)-5;
            if(list.get(list.size()-1)>0)
            {
                list.add(sadh);
                pre=true;
            }
            else
            {
                pre=false;
                sadh=sadh+10;
                list.add(sadh);
                
            }
            
            return calculate(N,pre,list);
        }
        else
        {
            pre=false;
            list.add(list.get(list.size()-1)+5);
            return calculate(N,pre,list);
        }
    }
}