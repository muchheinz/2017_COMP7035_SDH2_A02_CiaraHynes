package hint3;


/**
* Classical Change making problem with an unlimited amount of coins of each type. <br> 
* Version 1: Selection function with basic policy: First available coin.<br> 
* Leads to non-optimal solution.<br>
* The class encapsulates all the functions of the Greedy schema<br>
*/

public class ChangeMaking_1 {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking_1(){}

	//-------------------------------------------------------------------
	// 0. displayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this function displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void displayElements(MyList<Integer> m){
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
			System.out.print("MyList has " + size + " items: [");
			
			//2. We traverse the items
			for (int i = 0; i < size - 1; i++)
				System.out.print(m.getElement(i) + ", ");
			System.out.println(m.getElement(size - 1) + "]");
			
			break;
	
		}
		
	}
		
	//-------------------------------------------------------------------
	// 1. getCandidate --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is very simple: Just pick the first non-discarded type of coin.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @return: The index of candidate to be selected.
	 */	
	public int getCandidate(int changeGenerated, 
							MyList<Integer> discarded, 
							MyList<Integer> coinValues){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;
		int size = discarded.length();
		int index = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		while(res == -1 && index < size)
		{
			if (discarded.getElement(index) == 0){
				res = index;
				
			}
		}
		
		index++;
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
	//-------------------------------------------------------------------
	// 2. isValid --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param itemSelected: The index of the candidate selected.
	 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean isValid(MyList<Integer> coinValues,
						   int amount,
						   int changeGenerated,
						   int itemSelected){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = false;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		if (coinValues.getElement(itemSelected) + changeGenerated <= amount)
		{
			res = true;

		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
	//-------------------------------------------------------------------
	// 3. isFinal --> It selects if the current solution is the final solution  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution, this function states whether it is a final solution or it can still be improved.<br> 
	 * To determine it, it checks whether there is (at least) one more coin that can be used as part of the change.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
	 * @param coinValues: The MyList containing the set of coins supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: Whether the current solution is the final solution.
	 */	
	public boolean isFinal(int changeGenerated,
						   MyList<Integer> discarded,
						   MyList<Integer> coinValues, 
						   int amount){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;
		int index = 0;
		int size = discarded.length();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		while((res == true) && (index < size))
		{
			if(discarded.getElement(index) == 0)
			{
				if(coinValues.getElement(index) + changeGenerated <= amount)
				{
					res = false;
				}
			}
			index++;

		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its value according to:<br>
	 * How many coins are used in the solution.<br>
	 * How accurate it is the change.<br> 
	 * @param sol: The MyList containing the solution to the problem.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param amount: The amount of change we want to generate. 
	 * @return: The value of such solution.
	 */	
	public MyList<Integer> getQuality(MyList<Integer> sol, 
									  int changeGenerated, 
									  int amount){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();
		changeGenerated = 0;
		
		int coinsUsed = 0;
		int accuracy = 0;
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		for( int count = 0; count < sol.length(); count++)
		{
			coinsUsed += sol.getElement(count);
		}
		
		accuracy = amount - changeGenerated;
	
		res.addElement(0, accuracy);
		res.addElement(1, coinsUsed);
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(MyList<Integer> coinValues, 
			                     int amount){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();
		MyList<Integer> solutionValue = null;
		MyList<Integer> discarded = new MyDynamicList<Integer>();

		
		int changeGenerated = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		

		for(int count = 0; count < coinValues.length(); count++)
		{
			res.addElement(0, 0);
			discarded.addElement(0, 0);
			
		}

		while(isFinal(changeGenerated, discarded, coinValues, amount) == false)
		{
			int candidate = getCandidate(changeGenerated, discarded, coinValues);
			
			if(isValid(coinValues, amount, changeGenerated, candidate) == true)
			{	
				int value = res.getElement(candidate);
				
				res.removeElement(candidate);
				res.addElement(candidate, value + 1);
				
				changeGenerated = changeGenerated + coinValues.getElement(candidate);
			
			}
			
			else
			{
				discarded.removeElement(candidate);
				discarded.addElement(candidate, 1);
			}
		}
		
		displayElements(res);
		
		solutionValue = getQuality(res, changeGenerated, amount);
		
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
}
