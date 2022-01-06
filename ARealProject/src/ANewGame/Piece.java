package ANewGame;
import java.util.ArrayList;

public class Piece implements Cloneable {
	int side;
	//white = 0
	//black = 1
	int[] location = new int[2];
	int pieceID;
	ArrayList<int[]> legalMoves = new ArrayList<int[]>();
	
	boolean hasMoved;
	boolean underAttack;
	
	PieceType type;
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public Piece(PieceType p) {
		this.type = p;
	}
	
	public Piece(int s, int id, PieceType p, int[] l) {
		this.side = s;
		this.pieceID = id;
		this.type = p;
		this.hasMoved = false;
		this.underAttack = false;
		this.location[0] = l[0];
		this.location[1] = l[1];
	}

}
