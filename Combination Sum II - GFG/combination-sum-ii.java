//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(a);
        func(a,s,0,ans,new ArrayList<>(),0);
        return ans;
    }
    public static void func(int []a,int s,int ind,List<List<Integer>> ans,List<Integer> list,int sum)
    {
        if(sum==s)
        { 
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind>=a.length || sum>s)
        return;
        int n=-1;
        
        for(int i=ind;i<a.length;i++)
        {
            if(a[i]!=n)
            {
        n=a[i];
        if(sum+a[i]>s)
        break;
        list.add(n);
        //System.out.println("l"+list+"ind"+(i+1));
        func(a,s,i+1,ans,list,sum+a[i]);
        list.remove(list.size()-1);
        
        }
    }
    }
}