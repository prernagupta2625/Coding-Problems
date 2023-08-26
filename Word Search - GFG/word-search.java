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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        boolean val;
        
        for(int i=0;i<board.length;i++)
        {
            //System.out.println(board.length);
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {   char tmp=board[i][j];
                    board[i][j]='.';
                    boolean h=false;
                if(j<board[0].length-1)
                   h= search(word,1,board,i,j+1);
                   boolean d=false;
                   if(i<board.length-1)
                   d=search(word,1,board,i+1,j);
                   boolean l=false;
                   if(j>0)
                   l= search(word,1,board,i,j-1);
                   boolean u=false;
                   if(i>0)
                   u=search(word,1,board,i-1,j);
                   if(h||d||u||l ==true)
                   return true;
                   board[i][j]=tmp;
                
                }
            }
            
        }
        return false;
        
    }
    public static boolean search(String word,int ind,char[][]board,int r,int c)
    {
        if(ind==word.length())
        return true;
        if(board[r][c]==word.charAt(ind))
        {
           char tmp= board[r][c];
           board[r][c]='.';
          if(ind==word.length()-1)
            return true;
            boolean h=false;
                if(c<board[0].length-1)
                   h= search(word,ind+1,board,r,c+1);
                   boolean d=false;
                   if(r<board.length-1)
                   d=search(word,ind+1,board,r+1,c);
                   boolean l=false;
                   if(c>0)
                   l= search(word,ind+1,board,r,c-1);
                   boolean u=false;
                   if(r>0)
                   u=search(word,ind+1,board,r-1,c);
                   board[r][c]=tmp;
                   return h || d || u|| l;
                
        }
        else
        return false;
    }
    
}