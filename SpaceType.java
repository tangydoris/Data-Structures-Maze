
public enum SpaceType {
	
	IP, WALL, COR, VCOR, WAYO, EXIT;
	
	public String toString(){
		switch(this){
			case IP: return "*";
			case WALL: return "x";
			case VCOR: return ".";
			case WAYO: return "E";
			case EXIT: return "o";
			default: return " ";
		}
	}
}