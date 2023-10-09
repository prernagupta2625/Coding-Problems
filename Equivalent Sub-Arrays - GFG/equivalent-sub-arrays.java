//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
      HashSet<Integer> hs=new HashSet<>();
      for(int i=0;i<n;i++)
      hs.add(arr[i]);
      int k=hs.size();
     //System.out.println(func(arr,k,n)+" "+func(arr,k-1,n));
     return func(arr,k,n)-func(arr,k-1,n);
      
    }
    public static int func(int arr[],int k,int n)
    {
         HashMap<Integer,Integer> hm=new HashMap<>();
         int right=-1,left=0;
         if(k==0)
         return 0;
         int count=0;
         for(int i=0;i<n;i++)
         {
             if(hm.containsKey(arr[i]))
             hm.put(arr[i],hm.get(arr[i])+1);
             else
             {
                 while(hm.size()==k)
                 {
                     int num=arr[left];
                     if(hm.containsKey(num))
                     {
                         if(hm.get(num)==1)
                         {
                             hm.remove(num);
                         }
                         else
                         hm.put(num,hm.get(num)-1);
                     }
                     left++;
                 }
                 hm.put(arr[i],1);
             }
             right=i;
             count=count+right-left+1;
         }
         return count;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}

// } Driver Code Ends