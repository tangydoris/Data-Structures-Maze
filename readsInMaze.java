import java.io.*;
import java.util.*;

	 public class readsInMaze {

		static int startX;
		static int startY;
	    
	    public static void setInitialPosition(int x, int y){
	    	startX = x;
	    	startY = y;
	    }
	    
	    private static char maze[][];

	     /*Creates a Scanner for the inputed file with a maze. The input must be a file name and path (e.g. file.txt). 
	      * In addition, this file must be formatted such that the length and height of the maze are on the first line, 
	      * the second contains the array coordinates for the exit 
	      * and the third the array coordinates for the entrance. 
	      * The next lines should contain the maze drawn with 'x's and ' 's. 
	      */
	     public static void readInMaze (File file) throws FileNotFoundException{
	         //initialize ArrayList of of strings
	    	 //to store each row of maze
	         ArrayList<String> maze_rows = new ArrayList<String>();

	         //print path of file
	         //System.out.println(file.getAbsolutePath());
	         @SuppressWarnings("resource")
			Scanner readIn = new Scanner(file);
	         startX = readIn.nextInt();
	         startY = readIn.nextInt();
	         System.out.println("Initial Position is:\t"+ startX + "\t" + startY);

	         //store each row of the maze
	         while (readIn.hasNextLine()){
	             maze_rows.add(readIn.nextLine());
	         }
	         
	         //create matrix to store each maze position
	         int rows = maze_rows.size();
	         int cols = maze_rows.get(1).length();
	         //System.out.print(maze_rows);
	         //System.out.println(maze_rows.get(1));
	         maze = new char[rows][cols];
	         
	         
	         //iterate through maze_rows
	         //store each character that makes up maze
	         for(int i = 1; i < rows; i++){
	        	 for(int j = 0; j < cols; j ++){
	        		 maze[i][j] = maze_rows.get(i).charAt(j);
	        	 }
	         }
	         
	         //set initial position of maze
	         maze[startX][startY] = "*".charAt(0);
	     }
	     
	     
	     //prints maze line for line
	     public static void printMaze(){
	         for(int i = 0; i < maze.length; i ++){
	        	 for(int j = 0; j < maze[1].length; j++)
	        		 System.out.print(maze[i][j]);
	        	 System.out.println();
	         }
	     }
	     

	     public static void main(String[] args){
	    	try {
				readInMaze(new File("maze.in.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	printMaze();
	     }

}
