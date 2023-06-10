//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        ArrayList<Integer> lst1=new ArrayList<Integer>();
        ArrayList<Integer> lst2=new ArrayList<Integer>();
        int f=0;
        int j=0;
        for(int i=0;i<a.length;i++)
        {
           
             if(a[i]<0)
            lst1.add(a[i]);
            else
            lst2.add(a[i]);
        }
        for(int k=0;k<lst1.size();k++)
        {
            a[j]=lst1.get(k);
            j++;
        }
         
        for(int h=0;h<lst2.size();h++)
        {
            a[j]=lst2.get(h);
            j++;
           
        }
        
        
        
        
    }
}