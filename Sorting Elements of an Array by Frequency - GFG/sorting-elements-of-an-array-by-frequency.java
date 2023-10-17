/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int n,t;
		t=sc.nextInt();
		for(int j=0;j<t;j++)
		{
		n=sc.nextInt();
		int ar[]=new int[n];
		int ans[]=new int[n];
		ArrayList<Map.Entry<Integer,Integer>> list=new ArrayList<>();
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
		    ar[i]=sc.nextInt();
		    hm.put(ar[i],hm.getOrDefault(ar[i],0)+1);
		    
		}
		for(Map.Entry<Integer,Integer> e: hm.entrySet())
		{
		    list.add(e);
		}
		Collections.sort(list,(a,b)->{
		    if(a.getValue()==b.getValue())
		    return a.getKey()-b.getKey();
		    else
		    return b.getValue()-a.getValue();
		});
		int c=0;
		for(int i=0;i<list.size();i++)
		{
		    int num=list.get(i).getKey();
		    int freq=list.get(i).getValue();
		    for(int k=0;k<freq;k++)
		    {
		        ans[c]=num;
		        c++;
		    }
		}
	for(int ind: ans)
	System.out.print(ind+" ");
	System.out.println();
		}
	}
}