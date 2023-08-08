//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] nextGreaterElement(int N, int arr[]) {
        // code here
        Stack<Integer> st=new Stack<Integer>();
        int ans[]=new int[N];
        for(int i=arr.length-1;i>=0;i--)
        {
            st.push(arr[i]);
        }
        for(int i=arr.length-1;i>=0;i--)
        {
            if(st.peek()>arr[i])
            {
                ans[i]=st.peek();
            }
            else
            {
                while(!st.isEmpty())
                {
                    if(st.peek()>arr[i])
                    {
                        ans[i]=st.peek();
                        break;
                    }
                    else
                    st.pop();
                }
                if(st.isEmpty())
                ans[i]=-1;
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
