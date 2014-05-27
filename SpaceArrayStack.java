public class SpaceArrayStack implements SetOfSpaces{

	private int numElem;
	private int capacity;
	private Space myStack[];
 
public SpaceArrayStack( int cap )
 {
	 //set initial values
	 capacity = cap;
	 numElem = 0;
	 capacity = cap;
	
	 //allocate the array for storing characters
	 myStack =  new Space[capacity];
 }

 public void add(Space s) {
	  //if the stack is full, allocate a larger array
	  if (numElem == capacity)
	   makeLarger();
	  
	  //add the new value to the top of the stack
	  if (s != null) {
	   myStack[numElem] = s;
	   numElem++;
	  }
 }

 public Space remove() {
	  //if stack is empty return null reference
	  if (isEmpty())
		  return null;
	  //otherwise remove and return Space from the end of the stack
	  else {
		  numElem--;
		  return myStack[numElem];
	  }
}
 
 
 private void makeLarger(){
  //allocate larger array
  Space newArrayStack[] = new Space[capacity * 2];
  //copy the data over to the new array
  for (int i = 0; i < capacity; i++)
  {
   newArrayStack[i] = myStack[i];
  }
  //reset list reference to the new array
  myStack = newArrayStack;
  //reset the capacity to the new value
  capacity = 2*capacity;
  
 }
 

 public boolean isEmpty(){
	return (numElem==0);
 }
 

}
