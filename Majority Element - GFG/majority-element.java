//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int count=0, element=a[0];
        for(int i=0;i<size;i++)
        {
            if(a[i]==element)
            {
                count++;
            }
            else
            {
                if(count==0)
                {
                    element=a[i];
                    count=0;
                }
                else
                {
                    count-=1;
                }
            }
        }
        int f=0;
        for(int k=0;k<size;k++)
        {
            if(a[k]==element)
            f++;
        }
        if(f>size/2)
        return element;
        else return -1;
        
    }
}