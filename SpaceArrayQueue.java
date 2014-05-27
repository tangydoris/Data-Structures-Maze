public class SpaceArrayQueue implements SetOfSpaces{

	private int capacity;
	private int numElem;
	private int front;
	private int rear;
	
	private Space myQueue[];
 
public SpaceArrayQueue( int cap )
 {
	 //set initial values
	 capacity = cap;
	 numElem = 0;
	 rear = 0;
	 front = 0;
	
	 //allocate the array for storing characters
	 myQueue =  new Space[capacity];
 }

 public void add(Space s) {
	  //if the queue is full, allocate a larger array
	  if (numElem == capacity)
		  makeLarger();
	  
	  //add the new value to the top of the queue
	  if (s != null) {
		  myQueue[rear] = s;
		  rear = (rear+1) % capacity;
		  numElem++;
	  }
 }

 public Space remove() {
	  //if stack is empty return null reference
	  if (isEmpty())
		  return null;
	  
	  //otherwise remove and return Space from the front of queue
	  else {
		  Space temp = myQueue[front];
		  front = (front+1) % capacity;
		  return temp;
	  }
}
 
 
 private void makeLarger(){
  //allocate larger array
  Space tempqueue[] = new Space[capacity * 2];
  
  //copy the data over to the new array
  for (int i = 0; i < capacity; i++){
   tempqueue[i] = myQueue[i];
  }
  //reset list reference to the new array
  myQueue = tempqueue;;
  //reset the capacity to the new value
  capacity = 2*capacity;
  
 }
 

 public boolean isEmpty(){
	return (numElem==0);
 }
 
}
