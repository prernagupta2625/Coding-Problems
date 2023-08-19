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
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class pair implements Comparable<pair>{
    int rating,ind;
    pair(int rating,int ind)
    {
        this.rating=rating;
        this.ind=ind;
    }
    public int compareTo(pair obj)
    {
      
        return this.rating-obj.rating;
       
    }
}

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        pair ar[]=new pair[N];
        ArrayList<pair> list=new ArrayList<>();
        int sum=0,count=0;
        for(int j=0;j<N;j++)
        {
            list.add(new pair(ratings[j],j));
        }
        Collections.sort(list);
        for(int i=0;i<N;i++)
        {
            pair obj=list.get(i);
            pair left=null,right=null;
            count=0;
            if(obj.ind-1>-1)
            left=ar[obj.ind-1];
            if(obj.ind+1<N)
            right=ar[obj.ind+1];
           if(left==null && right!=null)
            {
                if(obj.rating==right.rating)
                count=1;
                else
                count=right.ind+1;
            }
            else if(right==null && left!=null)
            {
                if(obj.rating==left.rating)
                count=1;
                else
                count=left.ind+1;
            }
            else if(left!=null && right!=null)
            {
               if((left.rating==right.rating)&&(right.rating==obj.rating))
               count=1;
               else if(obj.rating==left.rating )
               count=right.ind+1;
               else if(obj.rating==right.rating)
               count=left.ind+1;
               else
               count=Math.max(left.ind,right.ind)+1;
            }
            else
            count=1;
            
            ar[obj.ind]=new pair(obj.rating,count);
            //System.out.println("rating "+obj.rating+" count "+count+" ind "+obj.ind);
            sum=sum+count;
            
        }
        return sum;
    }
}
