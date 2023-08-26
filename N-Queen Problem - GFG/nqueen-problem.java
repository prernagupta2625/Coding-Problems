//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int ar[]=new int[n];
        Arrays.fill(ar,-1);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        func(ar,0,new ArrayList<>(),ans,n);
        return ans;
        
    }
    public static void func(int ar[],int ind,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> 
    ans,int n)
    {
        if(ind==n)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(truth(ar,i,ind,n))
            {
                list.add(i+1);
                //System.out.println(list);
                ar[ind]=i;
                func(ar,ind+1,list,ans,n);
                list.remove(list.size()-1);
                ar[ind]=-1;
            }
            
        }
    }
    public static boolean truth(int ar[],int r,int c,int n)
    {
        for(int j=0;j<n;j++)
        {
            if(ar[j]==r || (Math.abs(r-ar[j])==Math.abs(c-j) && ar[j]>-1))
            return false;
            
        }
        return true;
    }
}