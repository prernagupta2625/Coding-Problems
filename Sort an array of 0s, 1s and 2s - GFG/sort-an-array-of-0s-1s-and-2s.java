//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int nums[], int n)
    {
        // code here 
       int start=0,end=nums.length-1,tmp;
        for(int i=0;i<nums.length;)
        {
            if(i>end)
            break;
            
            if(nums[i]==0)
            {
                if(i!=start)
                {
               tmp=nums[i];
               nums[i]=nums[start];
               nums[start]=tmp;
               
                }
                else
                i++;
                start+=1;
                
            }
            else if(nums[i]==2)
            {
                if(i!=end)
                {
               tmp=nums[i];
               nums[i]=nums[end];
               nums[end]=tmp;
              
                }else
                i++;
                 end-=1;
                 
            }
            else i++;

        }
    
    }
   
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends