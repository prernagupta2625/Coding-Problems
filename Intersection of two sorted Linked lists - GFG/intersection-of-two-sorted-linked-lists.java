//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node ptr1=head1,ptr2=head2,head=null,tmp=null;
        while(ptr1!=null && ptr2!=null)
        {
            //System.out.println(ptr1.data+"helo"+ptr2.data);
            if(ptr1.data==ptr2.data)
            {
                Node obj=new Node(ptr1.data);
                obj.next=null;
                if(head==null ){
                    head=obj;
                    tmp=obj;
                }else
                {
                    tmp.next=obj;
                    tmp=obj;
                }
                ptr1=ptr1.next;
                ptr2=ptr2.next;
            }
            else
            {
                if(ptr1.data<ptr2.data)
                ptr1=ptr1.next;
                else if(ptr2.data < ptr1.data)
                ptr2=ptr2.next;
            }
        }
        return(head);
    }
}