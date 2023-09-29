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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class pair{
    int x,y;
    pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
         int vis[][]=new int[n][m];
         for(int i=0;i<n;i++)
         Arrays.fill(vis[i],0);
         int count=0;
         Queue<pair> que=new LinkedList<>();
         for(int i=0;i<n;i++)
         {
             if(a[i][0]=='O')
             {
                 vis[i][0]=1;
                 count++;
                 que.add(new pair(i,0));
             }
             if(a[i][m-1]=='O')
             {
                 vis[i][m-1]=1;
                 count++;
                 que.add(new pair(i,m-1));
             }
         }
         for(int i=0;i<m;i++)
         {
             if(a[0][i]=='O')
             {
                 vis[0][i]=1;
                 count++;
                 que.add(new pair(0,i));
             }
             if(a[n-1][i]=='O')
             {
                 vis[n-1][i]=1;
                 count++;
                 que.add(new pair(n-1,i));
             }
         }
        //  for(int i=0;i<n;i++)
        //  {
        //      for(int j=0;j<m;j++)
        //      System.out.print(vis[i][j]);
        //      System.out.println();
        //  }
         int row[]={-1 ,1 ,0 ,0};
         int col[]={0,0,-1,1};
         while(!que.isEmpty())
         {
             pair obj=que.remove();
             int x=obj.x;
             int y=obj.y;
             for(int i=0;i<4;i++)
             {
                 int X=x+row[i];
                 int Y=y+col[i];
                 if(X>-1 && X<n && Y>-1 && Y<m && a[X][Y]=='O' && vis[X][Y]==0)
                 {
                     vis[X][Y]=1;
                     que.add(new pair(X,Y));
                     count++;
                     
                 }
             }
         }
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<m;j++)
             { //System.out.print(vis[i][j]);
                 if(a[i][j]=='O' && vis[i][j]==0)
                 a[i][j]='X';
             }
             //System.out.println();
         }
         
         return a;
             
    }
}