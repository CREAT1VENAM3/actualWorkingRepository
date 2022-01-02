package ANewGame;

public class Space implements Cloneable {
	int[] location;
	int status;
	// 0 = empty
	// 1 = white piece
	// 2 = black piece
	int pieceContainedID;
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public Space(int[] l) {
		this.location = l;
		this.status = 0;
		this.pieceContainedID = 0;
	}
	
	

}
