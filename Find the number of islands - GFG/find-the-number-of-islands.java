//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class pair{
    int x,y;
    pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int len=grid.length;
        int wid=grid[0].length;
        int count=0;
        Queue<pair> que=new LinkedList<>();
        int row[]={1,1,1,-1,-1,-1,0,0};
        int col[]={-1,1,0,-1,0,1,-1,1};
        int vis[][]=new int[len][wid];
        for(int i=0;i<len;i++)
        Arrays.fill(vis[i],0);
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<wid;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    que.add(new pair(i,j));
                    vis[i][j]=1;
                    count++;
                    while(!que.isEmpty())
                    {
                        pair obj=que.remove();
                        int x=obj.x;
                        int y=obj.y;
                        for(int k=0;k<8;k++)
                        {
                            int X=x+row[k];
                            int Y=y+col[k];
                           
                            //System.out.println(X+" "+Y);
                            if(X>-1 && X<len && Y>-1 && Y<wid && grid[X][Y]=='1' && vis[X][Y]==0)
                            {
                                //System.out.println("HEllo");
                                vis[X][Y]=1;
                                que.add(new pair(X,Y));
                            }
                        }
                    }
                }
            }
            //  for(int n=0;n<len;n++)
            // {
            //     for(int m=0;m<wid;m++)
            //     System.out.print(vis[n][m]);
            //     System.out.println();
            // }
           
        }
        
        return count;
    }
}