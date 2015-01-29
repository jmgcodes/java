import java.util.*;

class LLNode{
	
	int data;
	LLNode next;
	
	LLNode(int data){
		
		this.data = data;
		this.next = null;
	}
	
};

class LL{
	
	LLNode root;
	LLNode tail;
	
	LL(){
		this.root = null;
		this.tail = null;
	}
	
	public LLNode getRoot(){
		
		return root;
	}
	
	public void add(int data){
		
		LLNode newnode = new LLNode(data);
		
		if(root == null){
			
			root = newnode;
			tail = newnode;
			
		}
		else{
			
			tail.next = newnode;
			tail = newnode;
			
		}
	}
	
	public void print(){
		
		if(root==null)
			System.out.println("Empty LL");
		else{
						
			LLNode temp = root;
			while(temp!=null){
				
				System.out.print(temp.data + " ");
				temp = temp.next;
				
			}
			System.out.println("");

			
		}
	}
	
}

public class LLModify {

	public static void fnLL(){
		
		LL myLL = new LL();
		
		myLL.add(10);
		myLL.add(20);
		myLL.add(30);
		myLL.add(40);
		
		myLL.print();
		
		int[] arr = {2,3};
		LLNode newLL = fnDelete(myLL.getRoot(),arr,2);
		System.out.print(newLL.data + " " + newLL.next.data );
		
	}
	
	public static LLNode fnDelete(LLNode firstNode, int[] arr, int n){
		
		LLNode head = firstNode;
		LLNode current = head;
		LLNode nextNode = firstNode.next;
		
		int count = 0;
		
		if(n ==0 )
			return firstNode;
		
		for(int i=0; i<n; i++){
			
			int removeIndex = arr[i];
			
			while(removeIndex != count + 1){
				
				current.next = nextNode;
				current = nextNode;
				nextNode = nextNode.next;
				
				count ++;
				
			}
			
			nextNode = nextNode.next;
			count++;
			
		}
		current.next = nextNode;


		return head;
		
	}
	
}
