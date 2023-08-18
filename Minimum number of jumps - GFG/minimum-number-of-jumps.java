//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
         int start=1,end=arr[0],n=arr.length;
        int count=0,f=0;
        if(n==1)
        return 0;
        while(start <= end )
        {
            if(end>=n-1)
             return 1;
            int i=start,sum=0,ind=-1;
            count++;
            while(i<=end)
            {
                if(i+arr[i]>sum)
                {
                    sum=i+arr[i];
                    ind=i;
                    if(sum>=n-1)
                    {
                        f=1;
                        count++;
                        return count;
                        
                    }
                }
                i++;
            }
            if(f==1)
            break;
            start=ind+1;
            end=ind+arr[ind];

        }
        return -1;
    }
}