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
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
             if(mid<n-1 && arr[mid]==arr[mid+1])
            {
                if((high-mid-1)%2!=0 )
                {
                    low=mid+2;
                }
                else
                {
                    high=mid-1;
                }
            }
            else if(mid>0 && arr[mid]==arr[mid-1])
            {
                if((mid-1-low)%2!=0 )
                {
                    high=mid-2;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            return arr[mid];
         
        }
         return 0;
    }
}