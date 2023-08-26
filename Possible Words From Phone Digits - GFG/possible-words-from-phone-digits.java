//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        String ar[]={ "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> ans=new ArrayList<>();
        func(a,0,"",ans,ar);
        return ans;
    }
    public static void func(int a[],int ind,String str,ArrayList<String> ans,String ar[])
    {
        if(ind==a.length)
        {
            ans.add(str);
            return;
        }
        for(int i=0;i<ar[a[ind]].length();i++)
        {
            func(a,ind+1,str+ar[a[ind]].charAt(i),ans,ar);
            
        }
    }
}


