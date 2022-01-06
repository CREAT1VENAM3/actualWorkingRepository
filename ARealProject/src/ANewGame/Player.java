package ANewGame;
import java.util.ArrayList;

public class Player implements Cloneable{
	int playerID;
	boolean inCheck;
	// White = 0
	// Black = 1
	ArrayList<Piece> currentPieces = new ArrayList<Piece>();
	
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public Player(int p) {
		this.playerID = p;
		this.inCheck = false;
	}
	
	public void addPiece(Piece p) {
		this.currentPieces.add(p);
	}
	
}
