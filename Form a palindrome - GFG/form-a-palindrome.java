//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
        int len=str.length();
        int dp[][]=new int[len][len];
        for(int i=0;i<len;i++)
        Arrays.fill(dp[i],0);
        for(int i=len-1;i>=0;i--)
        {
            for(int j=0;j<len;j++)
            {
                if(i>j)
                continue;
                if(str.charAt(i)==str.charAt(j))
                {
                    if(i<len-1 && j>0)
                    dp[i][j]=dp[i+1][j-1];
                    if(i==j)
                     dp[i][j]+=1;
                     else
                      dp[i][j]+=2;
                }
                else
                {
                    if(i<len-1)
                     dp[i][j]=Math.max( dp[i][j],dp[i+1][j]);
                     if(j>0)
                      dp[i][j]=Math.max( dp[i][j],dp[i][j-1]);
                }
            }
        }
        return len-dp[0][len-1];
    }
}