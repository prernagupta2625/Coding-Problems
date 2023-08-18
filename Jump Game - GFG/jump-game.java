//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] arr, int n) {
        // code here
        int start=1,end=arr[0];
        if(end>=n-1)
            return 1;
        while(start <= end )
        {
            int i=start,sum=0,ind=-1;
            if(end>=n-1)
            return 1;
            while(i<=end)
            {
                //System.out.println("hey");
                if(i+arr[i]>=sum)
                {
                    sum=i+arr[i];
                    //System.out.print("hello"+sum+" ");
                    ind=i;
                    if(sum>=n-1)
                    {
                        return 1;
                        
                    }
                }
                i++;
            }
            start=ind+1;
            end=ind+arr[ind];
            if(end>=n-1)
            return 1;
        }
        return 0;
    }
};