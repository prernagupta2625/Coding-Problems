//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        func(m,0,0,"",ans,n);
        return ans;
    }
    public static void func(int [][] m,int r,int c,String s,ArrayList<String> 
    ans,int n)
    {
        if(r==n-1 && c==n-1)
        {  if(m[r][c]==1)
            ans.add(s);
            return;
        }
        if(m[r][c]==1)
        {
            m[r][c]=0;
            if(r<n-1)
            func(m,r+1,c,s+'D',ans,n);
            if(r>0)
            func(m,r-1,c,s+'U',ans,n);
            if(c<n-1)
            func(m,r,c+1,s+'R',ans,n);
            if(c>0)
            func(m,r,c-1,s+'L',ans,n);
            m[r][c]=1;
            
        }
    }
    
}