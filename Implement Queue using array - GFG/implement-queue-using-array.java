//{ Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}




// } Driver Code Ends




class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=-1;
		rear=-1;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(front ==-1)
	    {
	        front++;
	        rear++;
	        arr[front]=x;
	        return;
	    }
	    rear++;
	    arr[rear]=x;
	    
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(front ==-1)
		return -1;
		if(front==rear )
		{
		   
		    int num=arr[front];
		    front=-1;
		    rear=-1;
		    return num;
		}
		else
		{
		    int num=arr[front];
		    front++;
		    return num;
		}
	} 
}




