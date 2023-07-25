//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        int start=-1,end=-2;
        for(int i=0;i<n;i++)
        {
            if(a[i]!=0)
            {start=i;
            break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(a[i]!=2)
            {end=i;
            break;
            }
        }
        int tmp;
       
        int ind=start;
        if(start<end)
        {
    while(ind<=end )
        {
            if(a[ind]==0)
            {
                tmp=a[ind];
                a[ind]=a[start];
                a[start]=tmp;
                start++;
                while(a[start]==0)
                start++;
                if(ind<start)
                {
                    ind=start;
                }
                
            }
            else if(a[ind]==2)
            {
                tmp=a[ind];
                a[ind]=a[end];
                a[end]=tmp;
                end--;
                while(a[end]==2)
                {
                    end--;
                }
            }
            else ind++;
            //System.out.println("start "+start+" end "+end);
        }
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