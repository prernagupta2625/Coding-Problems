//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    GfG obj=new GfG();
	    if(!s.empty())
		{
		    int num=s.pop();
		    sort(s);
		    obj.sorted(num,s);
		   
		}
		 return s;
	}
	void sorted(int num,Stack<Integer> s)
	{
	    if(s.empty())
	    {
	        s.push(num);
	    }
	    else
	    {
	        if(num>s.peek())
	        {
	            s.push(num);
	        }
	        else
	        {
	            int no=s.pop();
	            sorted(num,s);
	            s.push(no);
	        }
	    }
	    
	}
}