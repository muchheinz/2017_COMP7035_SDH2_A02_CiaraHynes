package hint2;


/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms2 {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms2(){}
		
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
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 * @return 
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 	
		
		if(m.length() == 0)
		{
			scenario = 1;
		}
		
		else if(m.length() > 1)
		{
			scenario = 2;
		}
		
		else
		{
			scenario = 3;
		}
	
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		case 1: 
			System.out.println("No elements to print");
			break;
			
		case 2: 
			int elementOne;
			
			elementOne = m.getElement(0);
			m.removeElement(0);
			System.out.println(elementOne);

			recursiveDisplayElements(m);
			
			m.addElement(0, elementOne);
			System.out.println("");
			break;
			
		case 3:
			Integer element;
			
			element = m.getElement(0);
			System.out.println(element);
			
			break;
		}
		
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 		
		
		if(m.length() == 0)
		{
			
		}
		
		else
		{
			scenario = 2;
		}
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		case 2:
			
			int elementOne;
			
			elementOne = m.getElement(0);
			m.removeElement(0);

			res = smallerMyList(m, e);

			if(elementOne < e)
			{
				res.addElement(0, elementOne);
			}
			

			m.addElement(0, elementOne);
			
			break;
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 			
		
		if(m.length() == 0)
		{

		}
		
		else
		{
			scenario = 2;
		}
		
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		case 1:
			break;
			
		case 2:
			
			int elementOne;
			
			elementOne = m.getElement(0);
			m.removeElement(0);

			res = biggerEqualMyList(m, e);

			if(elementOne >= e)
			{
				res.addElement(0, elementOne);
				System.out.println("");
			}
			

			m.addElement(0, elementOne);
			
			break;
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 		
		
		if(m1.length() > 0)
		{
			scenario = 1;
		}
		
		else if(m2.length() > 0)
		{
			scenario = 2;
		}
	
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
			
		switch(scenario){	
			
		case 1:
			
			int elementOne;
			
			elementOne = m1.getElement(0);
			m1.removeElement(0);

			res = concatenate(m1, m2);

			res.addElement(0, elementOne);
			m1.addElement(0, elementOne);

			
			break;
			
		case 2:
			
			int element;
			
			element = m2.getElement(0);
			m2.removeElement(0);

			res = concatenate(m1, m2);

			res.addElement(0, element);
			m2.addElement(0, element);

			
			break;
		}
			
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		if(m.length() == 0)
		{
			scenario = 1;
		}
		
		else if (m.length() > 1)
		{
			scenario = 2;
		}
		
		else
		{
			scenario = 3;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
			
		switch(scenario){	
		
		case 2:

			int elementOne;
			
			MyList<Integer> one = new MyDynamicList<Integer>();
			MyList<Integer> two = new MyDynamicList<Integer>();

						
			elementOne = m.getElement(0);
			m.removeElement(0);
						
			one = smallerMyList(m, elementOne);
			one = quickSort(one);

			two = biggerEqualMyList(m, elementOne);
			two = quickSort(two);
			two.addElement(0, elementOne);

			//res = quickSort(m);
			

			res = concatenate(one, two);
			
			m.addElement(0, elementOne);

			

			break;
			
		case 3:
			
			res = m;
			break;
		
		}		
	
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}		
	
}
