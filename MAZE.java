import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MAZE {
	
	public Space maze[][];
	private int startX, startY;
	private static int maxX;
	private static int maxY;
	
	public MAZE(File file) throws FileNotFoundException{
		//initialize ArrayList of of strings
		//to store each row of maze
        ArrayList<String> maze_rows = new ArrayList<String>();

        //print path of file
        //System.out.println(file.getAbsolutePath());
        @SuppressWarnings("resource")
		Scanner readIn = new Scanner(file);
        startX = readIn.nextInt();
        startY = readIn.nextInt();
        
        readIn.nextLine();
        
        //store each row of the maze
        while (readIn.hasNextLine()){
            maze_rows.add(readIn.nextLine());
        }
        
        
        //create matrix to store each maze position
        maxX = maze_rows.size();
        maxY = maze_rows.get(0).length();
        
        maze = new Space[maxX][maxY];
        
        
        //iterate through maze_rows
        //store each Space that makes up maze
        for(int i = 0; i < maxX; i++){
        	for(int j = 0; j < maxY; j++){
        		char c = maze_rows.get(i).charAt(j);
        		//System.out.print(c);
        		SpaceType t;
        		switch (c){
        			case (char)120:
        				t = SpaceType.WALL;
        				break;
        			case (char)111:
        				t = SpaceType.EXIT;
    					break;
        			case (char)42:
        				t = SpaceType.IP;
        				break;
        			default:
        				t = SpaceType.COR;
    					break;
        		}
        		maze[i][j] = new Space(t, i, j);
        	}
        }
        maze[startX][startY] = new Space(SpaceType.IP, startX, startY);
    	//System.out.print(maxX);
    	//System.out.print(maxY);
	}
	

    public String toString(){    	
    	String ans = "";
        for(int i = 0; i < maxX; i++){
       	 	for(int j = 0; j < maxY; j++){
       	 		ans += maze[i][j].toString();
       	 }
       	 ans += "\n";
        }
        return ans;
    }
    
    public SpaceType type(int xcor, int ycor){
    	return maze[xcor][ycor].getType();
    }
    
    public ArrayList<Space> getNeighbors(int xcor, int ycor){
    	ArrayList<Space> list = new ArrayList<Space>();
    	list.add(maze[xcor-1][ycor]);
    	list.add(maze[xcor][(ycor+1)]);
    	list.add(maze[(xcor+1)][ycor]);
    	list.add(maze[xcor][(ycor-1)]);
    	
    	return list;
    }
    
    public void changeSpaceType(int xcor, int ycor, SpaceType newType){
    	maze[xcor][ycor].changeType(newType);
    }
    
    public int getStartX(){
    	return startX;
    }
    
    public int getStartY(){
    	return startY;
    }
    
    public int getMaxX(){
    	return maxX;
    }
    
    public int getMaxY(){
    	return maxY;
    }
    
    public Space getSpace(int xcor, int ycor){
    	return maze[xcor][ycor];
    }
    
    /*
    public static void main(String[] args){
    	try {
			MAZE m = new MAZE(new File("maze.in.txt"));
			
			System.out.print(m.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    */
    
}
