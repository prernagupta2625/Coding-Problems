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
            long res = obj.subarrayRanges(N, arr);

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
    public static long subarrayRanges(int N, int[] arr) {
        // code here
        Stack<pair> st1=new Stack<pair>();
        Stack<pair> st2=new Stack<pair>();
        int leftmin[]=new int[N];
        int rightmin[]=new int[N];
        int leftmax[]=new int[N];
        int rightmax[]=new int[N];
        
        for(int i=0;i<N;i++)
        {
            int count=1;
            while(!st1.isEmpty() && st1.peek().num>arr[i])
            {
                count=count+st1.peek().freq;
                st1.pop();
            }
            st1.push(new pair(arr[i],count));
            leftmin[i]=count;
            int count2=1;
            while(!st2.isEmpty() && st2.peek().num<arr[i])
            {
                count2=count2+st2.peek().freq;
                st2.pop();
            }
            st2.push(new pair(arr[i],count2));
            leftmax[i]=count2;
        }
        st1.clear();
        st2.clear();
        for(int i=N-1;i>=0;i--)
        {
            int count=1;
            while(!st1.isEmpty() && st1.peek().num>=arr[i])
            {
                count=count+st1.peek().freq;
                st1.pop();
            }
            st1.push(new pair(arr[i],count));
            rightmin[i]=count;
            int count2=1;
            while(!st2.isEmpty() && st2.peek().num<=arr[i])
            {
                count2=count2+st2.peek().freq;
                st2.pop();
            }
            st2.push(new pair(arr[i],count2));
            rightmax[i]=count2;
        }
        long ans=0;
        for(int j=0;j<N;j++)
        {
            ans=ans-(long)(leftmin[j]*rightmin[j]*arr[j]);
            ans=ans+(long)(leftmax[j]*rightmax[j]*arr[j]);
        }
        return ans;
    }
}
