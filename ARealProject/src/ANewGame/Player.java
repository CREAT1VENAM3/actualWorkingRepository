package ANewGame;
import java.util.ArrayList;

public class Player implements Cloneable{
	int playerID;
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
	}
	
	public void addPiece(Piece p) {
		this.currentPieces.add(p);
	}
	
}
