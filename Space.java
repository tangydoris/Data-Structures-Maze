public class Space {
	
	public SpaceType type;
	private int x, y;
	
	public Space(SpaceType t, int xcor, int ycor){
		type = t;
		x = xcor;
		y = ycor;
	}
	
	public SpaceType getType(){
		return type;
	}
	
	public boolean isFree(){
		return type == SpaceType.COR;
	}
	
	public boolean isWall(){
		return type == SpaceType.WALL;
	}
	
	public boolean isExit(){
		return type == SpaceType.EXIT;
	}
	
	public boolean isVisited(){
		return type == SpaceType.VCOR;
	}
	
	public void changeType(SpaceType newType){
		type = newType;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String toString(){
		return type.toString();
	}
}
