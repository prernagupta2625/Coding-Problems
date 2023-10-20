//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		array[i] = sc.nextInt();
        	}
        	int target = sc.nextInt();

            Solution ob = new Solution();
			System.out.println(ob.Search(array,target));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int Search(int array[], int target)
	{
	    // code here
	    int m=0;
	    if(array.length>1)
	    for(int i=0;i<array.length-1;i++)
	    {
	        if(array[i]>array[i+1])
	        {
	            m=i;
	            break;
	        }
	    }
	    return Math.max(func(array,target,0,m),func(array,target,m+1,array.length-1));
	}
	public static int func(int arr[],int target,int beg,int end)
	{
	    if(end<beg)
	    return -1;
	    int mid=(beg+end)/2;
	    if(arr[mid]==target)
	    return mid;
	    else if(arr[mid]<target)
	    return func(arr,target,mid+1,end);
	    else
	    return func(arr,target,beg,mid-1);
	}
} 

