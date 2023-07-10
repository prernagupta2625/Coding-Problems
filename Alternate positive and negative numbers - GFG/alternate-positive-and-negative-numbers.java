//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        Queue<Integer> que1=new LinkedList<>();
        Queue<Integer> que2=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=0)
            {
                que1.add(arr[i]);
            }
            else
            {
                que2.add(arr[i]);
            }
        }
        boolean flag=true;
        int c=0;
        for(int j=0;j<n;)
        {
            int num=0;
            if(flag==true)
            {
                if(que1.peek()!=null)
                {
                    num=que1.remove();
                    c++;
                }
                
                flag=false;
            }
            else 
            {
                if(que2.peek()!=null)
                {
                    num=que2.remove();
                    c++;
                }
                
                flag=true;
            }
            arr[j]=num;
            j=c;
        }
        
    }
}