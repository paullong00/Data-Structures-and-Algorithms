//Paul Long
//R00191864


/**
* ADT MyQueue: Private Part<br>. 
* The class implements all the operations available in MyQueue<br>
*/
public class MyDynamicQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode head;

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	//public myQueue myCreateEmpty(){}
	
	public MyDynamicQueue(){//TO-COMPLETE 
		this.head = null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	

	public boolean isEmpty(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true; 
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (head != null) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			res = false;
			break;
		case 2:
			res = true;
			break;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get and remove first element from top of MyQueue: dequeue
	//-------------------------------------------------------------------

	public int dequeue(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		boolean e = isEmpty();
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		//queue isn't empty
		if (e == false) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			//set res to element about to be removed
			res = head.getInfo();
			//head pointer is moved to the next element
			head = head.getNext();
			break;
		case 2:
			System.out.println("Can't dequeue, queue is empty");
			break;
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of MyQueue: enqueue
	//-------------------------------------------------------------------
	
	public void enqueue(int element){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		boolean e = isEmpty();
		//create a node for the element about to be added to the queue
		MyNode n = new MyNode(element, null);
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		//queue is empty
		if (e == true) {
			scenario = 1;
		}
		//queue is populated
		else {
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			//head pointer set to the element you've just added
			head = n;
			break;
		case 2:
			//current allows you to move through the queue
			MyNode current = head;
			
			//move through queue, current points to each element in turn
			while (current.getNext() != null) {
				current = current.getNext();
			}
			//at the back of the queue, add the new element
			current.setNext(n);
			break;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> get the item at the top of myqueue: front
	//-------------------------------------------------------------------
	/**
	* Given a concrete MyQueue, get the item at the back of the queue..<br>
	* @return: item at back of  MyQueue.	 
	*/	
	public int rear(){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = -1;
		int scenario = 0;
		boolean e = isEmpty();
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		//queue is populated
		if (e == false) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			//current keeps track of where you are in the queue currently
			MyNode current = head;
			//loop cycles through the queue to the end and sets res to the final value in the queue
			while (current.getNext() != null) {
				current = current.getNext();
				res = current.getInfo();
			}
			break;
		case 2:
			System.out.println("Can't get rear, queue is empty");
			break;
		}
		return res;
	}
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> get the item at the top of myqueue: front
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, get the item at the top of the queue..<br>
	 * @return: item at top of  MyQueue.	 
	 */	
	public int front(){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int res = -1;
		int scenario = 0;
		boolean e = isEmpty();
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		if (e == false) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			res = head.getInfo();
			break;
		case 2:
			System.out.println("Can't get front, queue is empty");
			break;
		}
		return res;
	}	
	
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyQueue: print
	//-------------------------------------------------------------------
	
	public void print(){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int data;
		int scenario;
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		if (isEmpty() == false) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			MyNode current = head;
			//cycle through each element in the queue, printing each one
			while (current != null) {
				data = current.getInfo();
				System.out.println(data);
				
				current = current.getNext();
			}
			break;
		case 2:
			System.out.println("Queue is empty");
			break;
		}
	}
}
