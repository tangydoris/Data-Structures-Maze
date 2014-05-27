import java.io.*;
import java.util.*;

public class RunQueue {
	
	private MAZE maze;
	private SpaceArrayQueue queue;
	private static PrintWriter out;
	
	public RunQueue(File file){		
		try {
			if(file.exists() && file.canRead()){
			maze = new MAZE(file);
			queue = new SpaceArrayQueue(maze.getMaxX() * maze.getMaxY());}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fileout = new File("fileout2.txt");
		try {
			out = new PrintWriter(fileout);
			out.println("Row Column");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void solve(){
		int startX = maze.getStartX();
		int startY = maze.getStartY();
		out.println(startX+" "+startY);
	    findPath(startX, startY);
		out.close();
	}
	
	
	public boolean findPath(int xcor, int ycor){
		if(maze.getSpace(xcor, ycor).isExit()){
			maze.changeSpaceType(xcor, ycor, SpaceType.EXIT);
			printMaze();
			return true;
		}
		
		ArrayList<Space> neighbors = maze.getNeighbors(xcor, ycor);
		for(Space move : neighbors){
		//for(int i = neighbors.size(); i >= 0; i--){
			//Space move = neighbors.get(i);
			if(isFreeSpace(move)){
				queue.add(move);
			}
		}

		if(!queue.isEmpty()){
			Space nextMove = queue.remove();

			int nextX = nextMove.getX();
			int nextY = nextMove.getY();

			out.println(nextX+" "+nextY);
			
			if(maze.getSpace(nextX, nextY).isExit()){
				maze.changeSpaceType(nextX, nextY, SpaceType.WAYO);
				printMaze();
				return true;
			}
			
			enterSpace(nextX, nextY);
			
			if(findPath(nextX, nextY))
				return true;
			
			return false;
		}
		else
			return true;
	}
	
	public boolean isFreeSpace(Space move){
		int x = move.getX();
		int y = move.getY();
		
		if(x <= 0 || x >= maze.getMaxX() ||
				y <= 0|| y >= maze.getMaxY())
			return false;
		
		return (maze.getSpace(x, y).isFree() || maze.getSpace(x, y).isExit());
	}
	
	public void enterSpace(int xcor, int ycor){
		maze.changeSpaceType(xcor, ycor, SpaceType.VCOR);

		try {
		    Thread.sleep(100);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		printMaze();
	}
	
	public void printMaze(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print(maze.toString());
	}
	
    public static void main(String[] args){
    	String filename = args[0];
    	
		try {
			RunStack test = new RunStack(new File(filename));
			test.printMaze();			
			test.solve();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
