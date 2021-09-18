//Paul Long
//R00191864

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
	
	//-------------------------------------------------------------------
		// 0. iterativeDisplayElements --> Displays all elements of a MyList 
		//-------------------------------------------------------------------	
		/**
		 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
		 * @param m: The MyList we want to display its elements.	  
		 */	
		public void iterativeDisplayElements(MyList<Integer> m){
			//-----------------------------
			//SET OF OPS
			//-----------------------------

			//-----------------------------
			// I. SCENARIO IDENTIFICATION
			//-----------------------------
			int scenario = 0; 
			
			//Rule 1. MyList is empty
			if (m.length() == 0) 
				scenario = 1;
			//Rule 2. MyList is non-empty
			else
				scenario = 2;

			//-----------------------------
			// II. SCENARIO IMPLEMENTATION 
			//-----------------------------
			switch(scenario){	
					
			//Rule 1. MyList is empty
			case 1: 
				//1. We print the empty message
				System.out.println("Empty MyList");
				
				break;
				
			//Rule 2. MyList is non-empty
			case 2: 
				//1. We print the initial message
				int size = m.length();
				System.out.println("MyList Contains the following " + size + " items: ");
				
				//2. We traverse the items
				for (int i = 0; i < size; i++)
					System.out.println("Item " + i + ": " + m.getElement(i));
				
				break;
		
			}
			
		}	
	//-------------------------------------------------------------------
	// 1. getEven --> Finds the even numbers in MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function finds the even number in m. 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: A new MyList containing only the even numbers present in m	  
	 */	
	public MyList<Integer> getEven(MyList<Integer> m){
			 // TO-DO
		
		//initialize res
		MyList<Integer> res = new MyDynamicList<Integer>();
		
		int scenario = 0;
		
		//list is empty
		if (m.length() == 0) {
			scenario = 1;
		}
		
		//list is populated
		else {
			scenario = 2;
		}
		
		
		switch(scenario) {
		case 1:
			break;

		case 2:
			//save contents of first element in a
			int a = m.getElement(0);
			//remove element
			m.removeElement(0);
			//call method with list minus the first element
			res = getEven(m);
			
			//check if selected element is even
			if ((a%2) == 0) {
				//add element to result list
				res.addElement(0, a);
			}
			//add element back to prevent changing the list
			m.addElement(0, a);
			
			break;
		}
		return res;
	}

	//-------------------------------------------------------------------
	// 2. getProduct --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the product of all items in m.  
	 * @param m: The MyList we want to check.
	 * @return: The product value calculated.  
	 */	
	public int getProduct(MyList<Integer> m){
			 // TO-DO

		//initialize res
		int res = 0;
		
		int scenario = 0;
		
		//if list is empty
		if (m.length() == 0) {
			scenario = 1;
		}
		//if list only has one element
		else if (m.length() == 1) {
			scenario = 2;
		}
		else {
			scenario = 3;
		}
		
		
		switch(scenario) {
		case 1:
			System.out.println("List is empty");
			break;
		case 2:
			//return first and only element
			res = m.getElement(0);
			break;
		case 3:
			//save contents of first element to a
			int a = m.getElement(0);
			//remove first element from m
			m.removeElement(0);
			//call method with list minus the first element
			res = getProduct(m);
			
			//multiply first element by next
			res = res * a;
			//add element back to m so as not to edit the list
			m.addElement(0, a);
			
			break;
		}
		return res;
	}

	//-------------------------------------------------------------------
	// 3. isEqual --> Determines if two MyLists are identical  
	//-------------------------------------------------------------------	
	/**
	 * The function determines is m1 and m2 are identical.   
	 * @param m1, m2: The two MyLists we want to compare.
	 * @return: True or false 
	 */	
	public boolean isEqual(MyList<Integer> m1, MyList<Integer> m2){
			 // TO-DO
		boolean res = false;
		
		int scenario = 0;
		
		//both lists are empty and therefore equal
		if ((m1.length() == 0) && (m2.length() == 0)) {
			scenario = 3;
		}
		//m1 is empty, m2 is not
		else if (m1.length()  == 0) {
			scenario = 1;
		}
		//m2 is empty, m1 is not
		else if (m2.length() == 0) {
			scenario = 1;
		}
		//lengths are not equal, lists cannot be equal
		else if (m1.length() != m2.length()) {
			scenario = 1;
		}
		//lengths are equal, compare lists
		else if ((m1.length() == m2.length()) && (m1.length() != 0) && (m2.length() != 0)){
			scenario = 2;
		}
		else {
			scenario = 1;
		}
		
		
		switch(scenario) {
		case 1:
			//lists are not equal
			res = false;
			break;
		case 2:
			//save first elements of both lists
			int a = m1.getElement(0);
			int b = m2.getElement(0);
			
			//remove first elements
			m1.removeElement(0);
			m2.removeElement(0);
			
			//call method to compare next two elements
			isEqual(m1, m2);
			
			//add elements back to lists
			m1.addElement(0, a);
			m2.addElement(0, b);
			
			//check if elements are equal
			if (a == b) {
				res = true;
			}
			else {
				res = false;
			}
			break;
		case 3:
			res = true;
		}
		return res;
	}
	
		
	//-------------------------------------------------------------------
	// 4. fermat --> Computes the n-est term of the Fermat series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Fermat series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int fermat(int n){
		 // TO-DO
		
		//initialize res
		int res = 0;
		
		int scenario = 0;
		
		//invalid n
		if (n < 0) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		
		
		switch(scenario) {
		case 1:
			break;
		case 2:
			//call method
			res = fermat(n - 1);
			//calculate res
			res = (2 ^ (res * 2))  + 1;
			break;
		}
		return res;
	}
		
}
