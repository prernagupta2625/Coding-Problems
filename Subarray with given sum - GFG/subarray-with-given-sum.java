//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int sum=0,left=0,right;
        for(int i=0;i<n;i++)
        {
             sum=sum+arr[i];
             right=i;
             if(sum==s)
             {
                 ArrayList<Integer> list=new ArrayList<>();
                 list.add(left+1);
                 list.add(right+1);
                 return list;
             }
             else if(sum>s)
             {
                 while(sum>s && left<right)
                 {
                     sum=sum-arr[left];
                     left++;
                     if(sum==s)
                     {
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(left+1);
                        list.add(right+1);
                        return list;
                     }
                 }
             }
             
             
        }
        ArrayList<Integer> a=new ArrayList<>();
        a.add(-1);
        return a;
    }
}