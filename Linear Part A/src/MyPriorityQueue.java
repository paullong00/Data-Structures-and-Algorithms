//Paul Long
//R00191864


/**
* ADT MyQueue: Private Part<br>. 
* The class implements all the operations available in MyQueue<br>
*/
public class MyPriorityQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode head;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	//public myQueue myCreateEmpty(){}
	
	public MyPriorityQueue(){//TO-COMPLETE 
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
	// Basic Operation (Partial) --> Add element to the MyQueue based on its priority class: enqueue
	//-------------------------------------------------------------------
	
	public void enqueue(int element){//TO-COMPLETE 
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int scenario = 0;
		boolean e = isEmpty();
		
		MyNode n = new MyNode(element, null);
		
		//current keeps track of position in queue
		MyNode current = head;
		//start is used exclusively to mark the position where a high priority element will be added
		MyNode start = head;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		//queue is empty
		if (e == true) {
			scenario = 1;
		}
		//element is low priority
		else if (50 <= element) {
			scenario = 2;
		}
		//element is high priority
		else {
			scenario = 3;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			//queue is empty, element is added straight to the top regardless of priority
			head = n;
			break;
		case 2:
			//low priority
			//always added to rear of queue
			
			//go to the back of the queue
			while (current.getNext() != null) {
				current = current.getNext();
			}
			//add new element to the back of the queue
			current.setNext(n);
			break;
		case 3:
			//high priority
			//added in front of low priority, at the back of high priority
			
			int a;
			int y = element;
			
			//first element is low priority
			if (start.getInfo() > 49) {
				//find first low priority element and mark as start
				while(start.getInfo() < 50) {
					start = start.getNext();
					current = start;
				}
				
				//variable used to end the while loop
				int i = 1;
				
				while (i != 0) {
					//store value of current in a
					a = current.getInfo();
					//set value of current to y (initially equals element)
					current.setInfo(y);
					//set y equal to a for next node
					y = a;
					
					//if you've reached the end of the queue
					if (current.getNext() == null) {
						//create a new node with the value y
						MyNode d = new MyNode(y, null);
						//add node to back of queue
						current.setNext(d);
						//exit loop
						i = 0;
					}
					//pass through loop again for the next node in queue
					else {
						current = current.getNext();
					}
				}
				break;
			}
			//check next element until you get to a low priority one
			else {
				//find first low priority element and mark as start
				while(start.getInfo() < 50) {
					start = start.getNext();
					current = start;
				}
				
				//variable used to end the while loop
				int i = 1;
				
				while (i != 0) {
					//store value of current in a
					a = current.getInfo();
					//set value of current to y (initially equals element)
					current.setInfo(y);
					//set y equal to a for next node
					y = a;
					
					//if you've reached the end of the queue
					if (current.getNext() == null) {
						//create a new node with the value y
						MyNode d = new MyNode(y, null);
						//add node to back of queue
						current.setNext(d);
						//exit loop
						i = 0;
					}
					//pass through loop again for the next node in queue
					else {
						current = current.getNext();
					}
				}
				
				break;
			}
			
		
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
