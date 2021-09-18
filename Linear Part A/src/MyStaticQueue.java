//Paul Long
//R00191864


/**
* ADT MyQueue: Private Part<br>. 
* The class implements all the operations available in MyQueue<br>
*/
public class MyStaticQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private int items[]; 
	private int numItems;
	private int maxItems;

	//-------------------------------------------------------------------
	//-------------------------------------------------------------------	
	//public myQueue myCreateEmpty(){}
	
	/**
	 * The constructor creates 1 instance (1 object) of the class MyStaticQueue<br>
	 * @param m: The maximum number of items MyQueue can contain.
	 */	 
	public MyStaticQueue(int m){//TO-COMPLETE 
		this.maxItems = m;
		this.items = new int[m];
		this.numItems = -1;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyQueue, it returns whether it is empty or not.<br>
	 * @return: Whether MyQueue is empty or not.
	 */	
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
		
		//identify scenarios for switch statement
		//the queue has at least one element
		if (numItems != -1) {
			scenario = 1;
		}
		//the queue is empty
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
	/**
	 * Given a concrete MyQueue, it returns element at the top of the queue (if any).<br>
	 * @return: Head element from MyQueue (ERROR if there are no items in MyQueue).
	 */	
	public int dequeue(){//TO-COMPLETE 
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		//initialize return variable
		int res = -1;
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		//identify scenarios for switch statement
		//queue has at least one element
		if (isEmpty() == false) {
			scenario = 1;
		}
		//queue is empty
		else {
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			//return variable set to element at the front of the queue
			res = items[0];
			//move each element in the queue up one position, overriding the original front element
			for(int i = 0; i < (this.numItems); i++) {
				this.items[i] = this.items[i+1];
			}
			//update the total number of elements in the queue
			this.numItems = this.numItems - 1;
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
	/**
	 * Given a concrete MyQueue, add an item to the back of the queue.<br>
	 * @param element: New item to be added to MyQueue.	 
	 */	
	public void enqueue(int element){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//identify scenarios for switch statement
		//the queue is full
		if (numItems == maxItems-1) {
			scenario = 1;
		}
		//the queue isn't full, an element can be added
		else {
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		//queue is full
		case 1:
			System.out.println("Queue is full");
			break;
		
		case 2:
			//update total number of elements
			numItems = numItems + 1;
			//add new element to the back of the queue
			items[numItems] = element;
			break;
		}
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
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		//identify scenarios for switch statement
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
			//set res to the first element in the queue
			res = items[0];
			break;
		case 2:
			res = -1;
			System.out.println("Queue is empty");
			break;
		}
		
		return res;
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
		int res = 0;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		//identify scenarios for switch statement
		//queue has at least one element
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
			//res set to element at the back of the queue
			res = items[numItems];
			break;
		case 2:
			res = -1;
			System.out.println("Queue is empty");
			break;
		}
		
		return res;
	}
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyQueue: print
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, prints all the elements (if any).<br>
	 * 
	 */	
	public void print(){//TO-COMPLETE 
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		//identify scenarios for switch statement
		//queue is empty
		if (isEmpty() == true) {
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
			System.out.println("Queue is empty");
			break;
		case 2:
			//iterate through queue printing each element
			for (int i=0; i<=numItems; i++) {
				System.out.println(items[i]);
			}
			break;
		}
	}
	
}
