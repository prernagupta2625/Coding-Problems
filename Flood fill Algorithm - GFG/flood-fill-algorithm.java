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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
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
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor)
    {
        // Code here 
        
        int len=image.length,width=image[0].length,color=image[sr][sc];
        int image2[][]=new int[len][width];
        image2=image;
        Queue<pair> que=new LinkedList<>();
        que.add(new pair(sr,sc));
        image[sr][sc]=-1;
        image2[sr][sc]=newcolor;
        while(!que.isEmpty())
        {
           pair obj=que.remove();
           int x=obj.x;
           int y=obj.y;
           if(x>0)
           {
               if(image[x-1][y]!=-1 && image[x-1][y]==color && image2[x-1][y]!=newcolor)
               {
                   image[x-1][y]=-1;
                   image2[x-1][y]=newcolor;
                   que.add(new pair(x-1,y));
               }
           }
           if(y>0)
           {
               if(image[x][y-1]!=-1 && image[x][y-1]==color && image2[x][y-1]!=newcolor)
               {
                   image[x][y-1]=-1;
                   image2[x][y-1]=newcolor;
                   que.add(new pair(x,y-1));
               }
           }
           if(x<len-1)
           {
               if(image[x+1][y]!=-1 && image[x+1][y]==color && image2[x+1][y]!=newcolor)
               {
                   image[x+1][y]=-1;
                   image2[x+1][y]=newcolor;
                   que.add(new pair(x+1,y));
               }
           }
           if(y<width-1)
           {
               if(image[x][y+1]!=-1 && image[x][y+1]==color && image2[x][y+1]!=newcolor)
               {
                   image[x][y+1]=-1;
                   image2[x][y+1]=newcolor;
                   que.add(new pair(x,y+1));
               }
           }
        }
        return image2;
    }
}