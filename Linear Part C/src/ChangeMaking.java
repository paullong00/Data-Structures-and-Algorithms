//Paul Long
//R00191864

/**
* Classical Change making problem with an unlimited amount of coins of each type. <br> 
* Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
* Depending on the type of coins, it can lead to an optimal solution.<br>
* The class encapsulates all the functions of the Greedy schema<br>
*/

public class ChangeMaking {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking(){}

	
	// -------------------------------------------------------------------
	// 1. selectionFunctionFirstCandidate--> It selects the first candidate 
	// -------------------------------------------------------------------
	/**
	 * Given a current solution that is not a final solution, this function
	 * selects the new candidate to be added to it.<br>
	 * The policy followed is very simple: Just pick the first unused item.
	 * 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of first candidate to be selected.
	 */
	public int selectionFunctionFirstCandidate(MyList<Integer> candidates) {
		//no limit to the amount of times you can choose a coin; all candidates can be considered at all times.

		//TO-DO
		
		//first candidate
		int res = 0;
		//returns candidate at start of list of candidates
		return res;
	}

		
	//-------------------------------------------------------------------
	// 1. selectionFunction --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the best (largest) coin according to the objective function of minimizing the number
	 * of coins that make the change of the amount. 
	 * @param candidates: List of candidates
	 * @return: The index of candidate to be selected.
	 */	
	public int selectionFunctionBestCandidate(MyList<Integer> coinValues, MyList<Integer> candidates ){
		//no limit to the amount of times you can choose a coin; all candidates can be considered at all times.
		
			//TO-DO
		//initialize res
		int res = 0;
		
		int a = 0;
		
		//iterate through list
		for (int i = 0; i < candidates.length(); i++) {
			
			//current element
			int b = candidates.getElement(i);
			
			//check if the current element is bigger than the previous
			if (b > a) {
				
				a = b;
				
				//set res to the position of the biggest element in the list
				res = i;
			}
		}
		
		return res;
	}
	
	//-------------------------------------------------------------------
	// 2. feasibilityTest --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param candidateValue: The value of the candidate coin selected. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
		 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated){
		
			//TO-DO
		//initialize res
		boolean res = false;
		
		int scenario = 0;
		
		//check if potential value is viable given the change determined so far
		if ((candidateValue + changeGenerated) <= amount) {
			scenario = 1;
		}
		//the candidate is not viable
		else {
			scenario = 2;
		}
		
		
		switch(scenario) {
		case 1:
			//candidate passes the feasibility test
			res = true;
			break;
		case 2:
			//candidate fails
			res = false;
			break;
		}
		
		return res;
	}
	
	// -------------------------------------------------------------------
	// 5. solutionTest --> It selects if the current solution is the final
	// solution
	// -------------------------------------------------------------------
	/**
	 * Given a current solution, this function states whether it is a final
	 * solution or it can still be improved.<br>
	 * To determine it, it checks whether there is (at least) one item not
	 * picked before that fits into the knapsack.
	 * 
	 * @param nbCandidates:
	 *            number of candidates that have not been yet selected by the
	 *            selection function
	 * @return: Whether the current solution is the final solution.
	 */
	public boolean solutionTest(MyList<Integer> candidates) {

			//TO-DO
		
		//initialize res
		boolean res = false;
		
		//get size of candidates list
		int size = candidates.length();
		
		int scenario = 0;
		
		//check if candidates list has any elements
		if (size == 0) {
			//if it's empty, all candidates have been tested
			scenario = 1;
		}
		
		//not all candidates have been tested
		else {
			scenario = 2;;
		}
		
		
		switch(scenario) {
		case 1:
			res = true;
			break;
		case 2:
			res = false;
			break;
		}
		
		return res;
	}


	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its objective function value according to:<br>
	 * How many coins are used in the solution.<br>
	 * @param sol: The MyList containing the solution to the problem. 
	 * @return: The objective function value of such solution.
	 */	
	public int  objectiveFunction(MyList<Integer> sol){
		
			//TO-DO
		
		//set res to length of list sol
		int res = sol.length();
		
		return res;
	}
	
	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param typeSelectFunc:
	 *            Type of selection function to choose.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount){
		//if the feasabliityTest returns false (using this coin takes us to an invalid state), then item should no longer be considered; set the candidate to 1 in itemsCOnsidered list.
			//TO-DO
		
		//initialize res
		MyList<Integer> res = new MyDynamicList<Integer>();
		
		//get number of possible coin values
		int size = coinValues.length();
		
		//keeps track of the position of the element being tested for feasibility
		int current = 0;
		//keeps track of element being tested for feasibility
		int next = 0;
		//keeps track of amount of money calculated so far to not go over the total
		int moneySoFar = 0;
		
		//list of possible elements
		MyList<Integer> itemsConsidered = new MyDynamicList<Integer>();
		
		
		//if no options are available for coin values, no result set can be calculated
		if (size == 0){
			//returns 0
			return coinValues;
		}
		
		//make a copy of coinValues so as not to edit the original set of coinValues
		for (int i = 0; i < size; i++) {
			int a = coinValues.getElement(i);
			itemsConsidered.addElement(i, a);
		}
		
		
		//if required selection method is for the first acceptable candidate (dummy selection)
		if (typeSelectFunc == 1) {
			
			//while the current solution is not the final one
			while (solutionTest(itemsConsidered) == false) {
				
				//select first element
				current = selectionFunctionFirstCandidate(itemsConsidered);
				next = itemsConsidered.getElement(current);
				
				//if current element passes feasibility test
				if (feasibilityTest(next, amount, moneySoFar) == true) {
					//add element to moneySoFar
					moneySoFar = moneySoFar + next;
					//add element to res
					res.addElement(0, next);
				}
				else {
					//remove element which failed the feasibility test
					itemsConsidered.removeElement(current);
				}
			}
		}

		
		//if selection function is for the best candidate (biggest coin possible)
		else {
			while (solutionTest(itemsConsidered) == false) {
				
				//get position of largest possible element
				current = selectionFunctionBestCandidate(coinValues, itemsConsidered);
				//get element at that position
				next = itemsConsidered.getElement(current);
				
				//check if selected value is feasible
				while (feasibilityTest(next, amount, moneySoFar) == true) {
					//update moneySoFar to include value that has just been deemed feasible
					moneySoFar = moneySoFar + next;
					//add value to res
					res.addElement(0, next);
				}
				//selected value is not feasible and is removed from consideration
				itemsConsidered.removeElement(current);
			}
		}
		
		//iterate through result list printing each element
		for (int i = 0; i < res.length(); i++) {
			System.out.println(res.getElement(i));
		}
		//print length of result list
		System.out.println("Number of coins: " + objectiveFunction(res));
		return res;
	}
	
}
