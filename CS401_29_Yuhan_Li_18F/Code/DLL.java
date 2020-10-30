public class DLL { 
	Node head; 
	class Node { 
		grade data; 
		Node prev; 
		Node next; 

		Node(grade d) { data = d; } 
	} 

	public void push(grade new_data) 
	{ 

		Node new_Node = new Node(new_data); 

		new_Node.next = head; 
		new_Node.prev = null; 

		if (head != null) 
			head.prev = new_Node; 

		head = new_Node; 
	} 

	public void printlistbak(Node node,int n,int m) 
	{ 
		n++;
        Node last = null; 
        String FFF =null;
		System.out.println("Traversal in reverse Direction"); 
		while(m!=node.data.getSID())
		{
			 last = node; 
		     node = node.next;
		}		
		
		System.out.println("Current location of pointer is:"+node.data.getfirstN() + " " + node.data.getlastN() + " " + node.data.getSite()+"\n"); 
		
		while (node != null&&n>0) { 
			System.out.print(node.data.getfirstN() + " " + node.data.getlastN() + " " + node.data.getSite() +"<<" ); 
			last = node; 
			if(node.next!= null)
		       node = node.next;
			else
			{   FFF = node.data.getfirstN() +" "+node.data.getlastN();
				node = node.next;
			}
			n--;
		} 
		
		  if(n!=0)
		  {  
        	  System.out.println(" ");
		     System.out.println("Sorry, can¡¯t go that far. " + FFF + " is the first member of the list.\n") ;
		  }
	} 
	
	public void printlistfor(Node node,int n,int m) 
	{ 
		n++;
        Node last = null; 
        String LLL = null;
        while (node != null) { 
            last = node; 
            node = node.next; 
        } 
        
		while(m!=last.data.getSID())
		{
			last = last.prev;
		}
		
		System.out.println("Current location of pointer is:1"+last.data.getfirstN() + " " + last.data.getlastN() + " " + last.data.getSite()+"\n"); 
			System.out.println("Traversal in forwaord direction");
		  	while (last != null&&n>0) { 
				System.out.print(last.data.getfirstN() + " " + last.data.getlastN() + " " + last.data.getSite()+">>" ); 
                if(last.prev!=null)
				last = last.prev; 
                else
                {
                	LLL=last.data.getfirstN() +" "+last.data.getlastN();
                	last = last.prev;
                }
				n--;
		} 
		  if(n!=0)
			  {
	        	  System.out.println(" ");
		   	     System.out.println("Sorry, can¡¯t go that far. " +LLL+ " is the last member of the list.\n") ;
			  }
	} 
} 