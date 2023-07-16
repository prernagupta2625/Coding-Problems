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
        int maxstep=0,steps=0,jump=0,cs;
        for(int i=0;i<arr.length;i++)
        {
            cs=i+arr[i];
             maxstep=Math.max(cs,maxstep);
             if(steps>0)
             steps-=1;
             if(maxstep==i && i<arr.length-1 && arr[i]<=0)
             return -1;
            if(steps==0 || i==arr.length-1)
            {
                jump+=1;
                steps=maxstep-i;
                
            }
           
        }
        return jump-1;
    }
}