//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
          HashMap<Character,Integer> hm = new HashMap<>();
       /* hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int count = 0;
        int n = str.length();
        if (n == 1){
            return (hm.get(str.charAt(0)));
        }else{
            for (int i = 0; i < n-1 ; i++){
                if (hm.get(str.charAt(i)) >= hm.get(str.charAt(i+1))){
                    count+=hm.get(str.charAt(i));
                }
                else {
                    count-=hm.get(str.charAt(i));
                }
            }
        }
        return (count+hm.get(str.charAt(n-1)));*/
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int sum=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(i+1==str.length())
            {
                sum+=hm.get(ch);
            }
            else
            {
                if(hm.get(ch)>=hm.get(str.charAt(i+1)))
                {
                    sum+=hm.get(ch);
                }
                else
                {
                    sum-=hm.get(ch);
                }
            }
        }
        return sum;
    }
}