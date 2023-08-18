//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int n)
    {
        // code here
         int ar[]={1,2,5,10,20,50,100,200,500,2000};
        List<Integer> list=new ArrayList<>();
        int ind=9;
        while(n>0 && ind>-1)
        {
            int i=n/ar[ind];
            for(int j=1;j<=i;j++)
            {
                list.add(ar[ind]);
            }
           
            n-=i*(ar[ind]);
            ind--;
        }
        return list;
        
    }
}