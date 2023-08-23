//{ Driver Code Starts
//Initial Template for Java

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
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> ans=new ArrayList<>();
    func(n,true,"",ans);
    return ans;
  }
  public static void func(int n,boolean flag,String s,List<String> lst)
  {
      if(s.length()==n)
      {
          lst.add(s);
          //System.out.println(s+" ");
          return;
      }
      if(flag==true)
      {
          func(n,true,s+'0',lst);
          func(n,false,s+'1',lst);
         
      }
      else
      func(n,true,s+'0',lst);
  }
}
     
     