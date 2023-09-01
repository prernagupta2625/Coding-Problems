//{ Driver Code Starts
                               import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        int S1=0, S2=0, k=0;
        for(var a : m)
        {
            k++;
            for(int e : a){
                if(k==1) S1+=e;
                else S2+=e;
            }
        }
        
        if(S1 < S2){
            System.out.println(S1);
            System.out.println(S2);
        }
        else{
            System.out.println(S2);
            System.out.println(S1);
        }
    }
    
    
    
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.minDifference(n, arr);
            
            IntMatrix.print(res);
            
        }
    }
}

                               
// } Driver Code Ends


class Solution {
  static int dif;
    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        // code here
        int sum=0;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> all=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> ans1=new ArrayList<>();
        ArrayList<Integer> ans2=new ArrayList<>();
        dif=Integer.MAX_VALUE;
        for(Integer t: arr)
        {
            sum+=t;
            list.add(t);}
           
        func(arr,0,ans,list,new ArrayList<>(),sum,0,n,
        ans1, ans2);
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
    public static void func(int arr[],int ind,ArrayList<ArrayList<Integer>> 
    ans,ArrayList<Integer> list,ArrayList<Integer> list2,int sum,int s,int n,
    ArrayList<Integer> ans1,ArrayList<Integer> ans2)
    {
        if(ind>=n)
            return;
            
        if(list2.size()==n/2)
        {
           
            int d=Math.abs(s-(sum-s));
            if(d<dif)
            {
                dif=d;
               ans1.clear();
               ans1.addAll(list2);
                ans2.clear();
                ans2.addAll(list);
                
            }
        }
            list2.add(arr[ind]);
            list.remove(Integer.valueOf(arr[ind]));
            func(arr,ind+1,ans,list,list2,sum,s+arr[ind],n,ans1,ans2);
            list2.remove(Integer.valueOf(arr[ind]));
            list.add(arr[ind]);
            func(arr,ind+1,ans,list,list2,sum,s,n,ans1,ans2);
            
            
            
        
    }
}
        
