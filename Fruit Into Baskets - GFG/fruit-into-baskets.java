//{ Driver Code Starts
// Initial Template for Java

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

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int left=0,right=0,e1=0,e2=0,max=0,ne1,ne2=0,j;
        e1=fruits[0];
        ne1=1;
        for( j=1;j<N;j++)
        {
            if(fruits[j]!=e1)
            {
                e2=fruits[j];
                ne2=1;
                right=j;
                break;
            }
            else
            {
                ne1+=1;
                right=j;
            }
        }
        max=Math.max(max,right-left+1);
        
        for(int i=j+1;i<N;i++)
        {
            int no=fruits[i];
            if(no==e1)
            {
                ne1++;
            }
            else if(no==e2)
            ne2++;
            else
            {
                while(left<=right)
                {
                    if(ne1==0 || ne2==0)
                    break;
                    if(fruits[left]==e1)
                    ne1--;
                    else if(fruits[left]==e2)
                    ne2--;
                    left++;
                }
                if(ne1==0)
                {
                    e1=fruits[i];
                    ne1=1;
                }
                else if(ne2==0)
                {
                    e2=fruits[i];
                    ne2=1;
                }
            }
            right=i;
            max=Math.max(max,right-left+1);
        }
        
        return max;
        
        
    }
}