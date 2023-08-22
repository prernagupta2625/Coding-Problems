//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> pq2=new PriorityQueue<>();
    public static void insertHeap(int x)
    {
        // add your code here
        if(pq1.isEmpty())
        pq1.add(x);
        else if(x<=pq1.peek())
        pq1.add(x);
        else
        pq2.add(x);
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
       if(pq1.size()-pq2.size()>1)
       pq2.add(pq1.poll());
       else if(pq2.size()-pq1.size()>1)
       pq1.add(pq2.poll());
       
       
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(pq1.size()==pq2.size())
        return ((pq2.peek()+pq1.peek())/2);
        else if(pq1.size()>pq2.size())
        return pq1.peek();
        else
        return pq2.peek();
        
    }
    
}