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
	
};

class LLMergeSort{
	
		public void fnLLMergeSort(){
		
			LL myLL = new LL();
			
			myLL.add(10);
			myLL.add(1);
			myLL.add(3);
			myLL.add(2);
			myLL.add(5);

			System.out.println("LL to sort");
			myLL.print();
			
			myLL = mergeSort(myLL);
			
			System.out.println("Sorted LL");
			myLL.print();
		
		};
		
		public LL mergeSort(LL myLL){
			
			LLNode temp = myLL.root;
			LLNode temp1 = myLL.root;
			LLNode temp2 = myLL.root;
			
			if(temp == null || temp.next == null)
				return myLL;
				
			LL first = new LL();
			LL second = new LL();
			
			
			while(temp!=null){
				
				temp = temp.next;
				
				if(temp!=null){
					
					first.add(temp1.data);
					temp = temp.next;
					temp1 = temp1.next;
					temp2 = temp2.next;
					
				}
			}
			
			second.root = temp2;
						
			first = mergeSort(first);
			second = mergeSort(second);
			
			return mergeLL(first,second);
		}
		
		public LL mergeLL(LL first, LL second){
			

			LL result = new LL();
			
			LLNode root1 = first.root;
			LLNode root2 = second.root;
			
			if(root1==null)
				return second;
			else if(root2 == null)
				return first;
			
			while(root1!=null && root2!=null){
				
				if(root1.data > root2.data){
					
					result.add(root2.data);
					root2 = root2.next;

					
				}
				else{
					
					result.add(root1.data);		
					root1 = root1.next;
			}
				
				
			}
			
			if(root1!=null){
				
				while(root1!=null){
					
					result.add(root1.data);
					root1 = root1.next;
					
				}
			}
			
			
			if(root2!=null){
				
				while(root2!=null){
					
					result.add(root2.data);
					root2 = root2.next;
					
				}
			}			
				
			
			return result;
		}
			
}
	
