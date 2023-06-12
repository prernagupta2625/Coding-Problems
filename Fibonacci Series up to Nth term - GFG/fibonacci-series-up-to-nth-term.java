//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans[] = obj.Series(n);
            for (long i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    long[] Series(int N) {
       long arr[]=new long[N+1];
       arr[0]=0;
       arr[1]=1;
       for(int i=2;i<N+1;i++)
       arr[i]=arr[i-1]+arr[i-2];
       return arr;
        
    }
}