//{ Driver Code Starts
//Code by:Saksham Raj Seth
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class LL{
Node head;
Node tail;
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }
 public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            LL llist = new LL();
			llist.head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
			int value=sc.nextInt();
			Node phead=head;
			while(phead.next!=null){
				phead=phead.next;
			}
			phead.next=head;
            Solution ob=new Solution();
			head = ob.sortedInsert(head,value);
			Node current = head;
			
			if(head != null){
			    do{
			        System.out.print(current.data+" ");
			        current = current.next;
			    }while(current != head);
			}
			System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class Solution
{
	public static Node sortedInsert(Node head,int data)
         {  int f=0;
            Node ptr=head;
            Node obj = new Node(data);
            if(head.data<data)
            {
            while(ptr.next!=head)
            {
                if(ptr.next.data>data)
                {
                    obj.next=ptr.next;
                    ptr.next=obj;
                    f=1;
                    break;
                }
                ptr=ptr.next;
            }
            if(f==0)
            {
                obj.next=ptr.next;
                ptr.next=obj;
            }
            }
            else
            {
                while(ptr.next!=head)
                {
                    ptr=ptr.next;
                }
               obj.next=ptr.next;
               ptr.next=obj;
               head=obj;
            }
            return(head);
            
         }
}