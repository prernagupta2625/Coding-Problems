//{ Driver Code Starts
import java.util.*;
class Node
{
	Node next;
	int data;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class Delete_Kth_Node
{
	Node head;	
	
	void addToTheLast(Node node)
	{
		if(head == null)
		head = node;
		else
		{
			Node temp = head;
			while(temp.next != null)
			temp = temp.next;
			
			temp.next = node;
		} }	
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();		 
		 while(t>0)
         {
			int n = sc.nextInt();
			Delete_Kth_Node list = new Delete_Kth_Node();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				list.addToTheLast(new Node(a));
			}
			int k = sc.nextInt();					  
			//System.out.println(list.head.data+" "+ k);
			list.head = new GfG().delete(list.head,k); 
			Node temp = list.head;
			while(temp!=null)
			{
				System.out.print(temp.data+ " ");
			    temp = temp.next;
			}
			System.out.println();
			t--;
		}
	}
}
// } Driver Code Ends


/* Link list Node
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class GfG
{
    /*You are required to complete this method*/
    Node delete(Node head, int k)
    {
	int i =1;
	Node ptr1=null,ptr=head,ptr2=null;;
	if(k==0)
	{
	    return(head);
	}
	else if(k==1)
	{
	    return(null);
	}
	else{
	while( ptr!=null && ptr.next!=null)
	{
	    i=i+1;
	   
	    if(i%k==0)
	    {
	  //System.out.println("#"+i);
	 ptr.next=ptr.next.next;
	   i=i+1;
	   ptr=ptr.next;
	    }
	    else
	    {
	    ptr=ptr.next;
	    }
	    
	}
	return(head);
	
    }
    }
}