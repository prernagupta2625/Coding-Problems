//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int low=0,high=n-1,min=Integer.MAX_VALUE;
        while(low<=high)
        {
            if(arr[low]<=arr[high])
            {
                min=Math.min(min,arr[low]);
                break;
            }
            int mid=(high+low)/2;
            if(arr[mid]<=arr[high])
            {
                min=Math.min(min,arr[mid]);
                high=mid-1;
            }
            else if(arr[low]<=arr[mid])
            {
                min=Math.min(min,arr[low]);
                low=mid+1;
            }
            
        }
        return min;
    }
}
