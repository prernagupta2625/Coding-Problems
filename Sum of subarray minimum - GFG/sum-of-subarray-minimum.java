//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class pair{
    int num,freq;
    pair(int n,int f)
    {
        num=n;
        freq=f;
    }
}
class Solution {
    public static int sumSubarrayMins(int N, int[] arr) {
        // code here
        
        Stack<pair> st=new Stack<pair>();
        int left[]=new int[N];
        int right[]=new int[N];
        for(int i=0;i<arr.length;i++)
        {
           
            int count=1;
            while(!st.isEmpty() && st.peek().num>arr[i])
            {
                count=count+st.peek().freq;
                st.pop();
            }
            st.push(new pair(arr[i],count));
            left[i]=count;
                
                  
        }
        st.clear();
        for(int i=arr.length-1;i>=0;i--)
        {
          
            int count=1;
            while(!st.isEmpty() && st.peek().num>=arr[i])
            {
                count=count+st.peek().freq;
                st.pop();
            }
            st.push(new pair(arr[i],count));
            right[i]=count;
        }
        int ans=0;
        int m=(int)Math.pow(10,9)+7;
        for(int i=0;i<arr.length;i++)
        {
            //System.out.println("left"+left[i]+"right "+right[i]);
          
            ans=(ans + (left[i]*right[i]*arr[i])%m)%m;
        }
        return ans;
    }
}
