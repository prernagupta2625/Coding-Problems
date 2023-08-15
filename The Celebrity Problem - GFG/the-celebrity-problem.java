//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int f;
    	for(int i=0;i<n;i++)
    	{
    	    f=0;
    	    for(int j=0;j<n;j++)
    	    {
    	        if(M[j][i]==0 && j!=i)
    	        {
    	            f=1;
    	            break;
    	        }
    	       
    	    }
    	     if(f==0)
    	        {
    	            //System.out.println("i"+i);
    	            
    	            for(int k=0;k<n;k++)
    	            {
    	                if(M[i][k]==1)
    	                {
    	                    f=1;
    	                    break;
    	                }
    	            }
    	            if(f==0)
    	            return i;
    	        }
    	}
    	return -1;
    }
}