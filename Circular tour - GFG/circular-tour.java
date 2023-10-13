//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here
	int n=distance.length;
	int ar[]=new int[n];
	for(int i=0;i<n;i++)
	{
	    ar[i]=petrol[i]-distance[i];
	    
	}
	int sum=0,ind=-1,max=Integer.MIN_VALUE,s=0;
	for(int i=0;i<n;i++)
	{
	    sum=sum+ar[i];
	    s=s+ar[i];
	    if(sum>0 && ind==-1)
	    {
	        ind=i;
	    }
	    else if(sum<0)
	    {
	        sum=0;
	        ind=-1;
	    }
	}
	if(s<0)
	return -1;
	else
	return (ind);
    }
}