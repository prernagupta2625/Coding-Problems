//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int max=-1;
        for(int i:piles)
        max=Math.max(max,i);
        int low=1,high=max,ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int f=func(piles,mid,H);
            if(f==3)
            {
            low=mid+1;
            }
            else if(f==2)
          {  
               ans=Math.min(ans,mid);
               high=mid-1;
          }
            else
            {
              ans=Math.min(ans,mid);
              high=mid-1;
            }
            
            
        }
        if(ans==Integer.MAX_VALUE)
        return -1;
        else
        return ans;
    }
    public static int func(int piles[],int s,int H)
    {
        int sum=0;
        for(int i=0;i<piles.length;i++)
        {
            int num=piles[i];
            int d=num/s;
            sum+=d;
            if(num%s!=0)
            sum+=1;
        }
        //System.out.println("sum "+sum+" "+s);
        if(sum==H)
        return 1;
        else if(sum<H)
        return 2;
        else
        return 3;
    }
}
        
