//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<N;i++)
        {
            int f=0;
            int num=asteroids[i];
            if(st.isEmpty())
            st.push(num);
            else
            {
                if(num>=0)
                st.push(num);
                else
                {
                
                    while(!st.isEmpty())
                    {
                        if(st.peek()>0 && st.peek()>Math.abs(num))
                        break;
                        else if(st.peek()<0)
                            {st.push(num);
                            break;
                            }
                            
                        else if(st.peek()>0 && st.peek()==Math.abs(num))
                        {
                            st.pop();
                            f=1;
                            break;
                        }
                        else
                        st.pop();
                    
                    }
                    if(st.isEmpty() && f==0)
                    st.push(num);
                    
                    
                }
                
            }
        }
        
        int ans[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--)
        {
            ans[i]=st.pop();
        }
        return ans;
    }
}
