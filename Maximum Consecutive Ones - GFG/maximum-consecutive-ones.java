//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int longestOnes(int n, int[] nums, int k) {
        // code here
        int no_zeroes=0,no_ones=0,max=0,right=0,start=0;
        for(int i=0;i<n;i++)
        {
            int no=nums[i];
            if(no==0 && no_zeroes<k)
            {
                no_zeroes+=1;
                
            }
            else if(no==0 && no_zeroes==k)
            {
                while(no_zeroes==k)
                {
                    if(nums[start]==0)
                    {
                        no_zeroes--;
                        start+=1;
                    }
                    else
                    start++;
                }
                no_zeroes+=1;
                
            }
            right=i;
           // System.out.println("start"+start+"right"+right+"zero"+no_zeroes);
            max=Math.max(max,right-start+1);
        }
        return max;
        
    }
}
        
