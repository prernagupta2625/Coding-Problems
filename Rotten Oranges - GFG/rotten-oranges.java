//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class pos{
    int x,y;
    pos(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int total=0,rotten=0,len=grid.length,width=grid[0].length;
        //System.out.print("l"+len+"w"+width);
        Queue<pos> que=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            { if(grid[i][j]!=0)
                total++;
                if(grid[i][j]==2)
                {
                    que.add(new pos(i,j));
                    rotten++;
                }
            }
        }
        que.add(null);
        int f=0,count=0;
        while(que.peek()!=null)
        {
            if(f==1)
                count++;
                f=1;
            while(que.peek()!=null)
            {
                
                pos obj=que.remove();
                int x=obj.x;
                int y=obj.y;
                if(x>0)
                {if(grid[x-1][y]==1)
                {
                    grid[x-1][y]=2;
                    rotten++;
                    que.add(new pos(x-1,y));
                    
                }
                }
                if(x<(len-1))
                {
                    if(grid[x+1][y]==1)
                    {rotten++;
                    grid[x+1][y]=2;
                    que.add(new pos(x+1,y));
                    }
                }
                if(y>0)
                {
                    if(grid[x][y-1]==1)
                    {
                        grid[x][y-1]=2;
                        rotten++;
                        que.add(new pos(x,y-1));
                    }
                }
                if(y<width-1)
                {
                    if(grid[x][y+1]==1)
                    {
                        grid[x][y+1]=2;
                        rotten++;
                        que.add(new pos(x,y+1));
                    }
                }
            }
            que.add(null);
            if(que.peek()==null)
            que.remove();
            
        }
        if(rotten<total)
        return -1;
        else
        return count;
        
        
    }
}