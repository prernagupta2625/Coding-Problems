//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        long suma=0,sumb=0,dif;
        for(int i=0;i<n;i++)
        {
            suma=suma+A[i];
        }
        for(int i=0;i<m;i++)
        {
            sumb=sumb+B[i];
        }
        dif=Math.abs(suma-sumb);
        if(!(dif%2==0))
        return -1;
        Arrays.sort(A);
        Arrays.sort(B);
        
       if(suma>sumb)
       {
           for(int j=0;j<A.length;j++)
           {
           long res= check(B,A[j]-dif/2);
           if(res==1)
           return 1;
           }
       }
       else
       {
            for(int j=0;j<B.length;j++)
           {
            long res= check(A,B[j]-dif/2);
           if(res==1)
           return 1;
           }
       }
        return -1;
    }
    public static long check( long arr[],long x)
    {
         int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return 1;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // If we reach here, then element was
        // not present
        return -1;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends