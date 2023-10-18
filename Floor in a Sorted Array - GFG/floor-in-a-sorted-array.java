//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int ind=-1;
    static Long ans=Long.MIN_VALUE;
    static int findFloor(long arr[], int n, long x)
    {
        ind=-1;
        ans=Long.MIN_VALUE;
        func(arr,x,0,n-1);
        return ind;
    }
    public static void func (long arr[],long x,int beg,int end)
    {
        if(beg>end)
        return;
        int mid=(end+beg)/2;
        if(arr[mid]<=x)
        {
            if(arr[mid]>ans)
           { ans=arr[mid];
           ind=mid;
           }
            if(arr[mid]==x)
            return;
            else
            func(arr,x,mid+1,end);
            
        }
        else if(x<arr[mid])
        {
            func(arr,x,beg,mid-1);
        }
    }
    
}
