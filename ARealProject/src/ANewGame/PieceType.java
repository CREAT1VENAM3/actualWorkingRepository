package ANewGame;
import java.util.ArrayList;

public class PieceType implements Cloneable {
	int pieceTypeID;
	//pawn = 0
	//knight = 1
	//bishop = 2
	//rook = 3
	//queen = 4
	//king = 5
	
	ArrayList<int[]> potentialMoves = new ArrayList<int[]>();
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public PieceType(int p) {
		this.pieceTypeID = p;
		int[] m = {0,0};
		
		//adding pawn moves
		if (this.pieceTypeID == 0) {
			m[0] = 1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 2;
			this.potentialMoves.add((int[])m.clone());
		}
		
		//adding knight moves
		else if (this.pieceTypeID == 1) {
			m[0] = 2;
			m[1] = 1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 1;
			m[1] = 2;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -2;
			m[1] = 1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -1;
			m[1] = 2;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 2;
			m[1] = -1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 1;
			m[1] = -2;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -2;
			m[1] = -1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -1;
			m[1] = -2;
			this.potentialMoves.add((int[])m.clone());
		}
		
		//adding bishop moves
		else if (this.pieceTypeID == 2) {
			for (int i = 1; i < 8; i++) {
				m[0] = i;
				m[1] = i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = i;
				m[1] = -i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = -i;
				m[1] = i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = -i;
				m[1] = -i;
				this.potentialMoves.add((int[])m.clone());
			}
		}
		
		//adding rook moves
		else if (this.pieceTypeID == 3) {
			for (int i = 1; i < 8; i++) {
				m[0] = i;
				m[1] = 0;
				this.potentialMoves.add((int[])m.clone());
				m[0] = -i;
				m[1] = 0;
				this.potentialMoves.add((int[])m.clone());
				m[0] = 0;
				m[1] = i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = 0;
				m[1] = -i;
				this.potentialMoves.add((int[])m.clone());
			}
		}
		
		//adding queen moves
		else if (this.pieceTypeID == 4) {
			for (int i = 1; i < 8; i++ ) {
				m[0] = i;
				m[1] = 0;
				this.potentialMoves.add((int[])m.clone());
				m[0] = -i;
				m[1] = 0;
				this.potentialMoves.add((int[])m.clone());
				m[0] = 0;
				m[1] = i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = 0;
				m[1] = -i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = i;
				m[1] = i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = i;
				m[1] = -i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = -i;
				m[1] = i;
				this.potentialMoves.add((int[])m.clone());
				m[0] = -i;
				m[1] = -i;
				this.potentialMoves.add((int[])m.clone());
			}
		}
		
		//adding king moves
		else if (this.pieceTypeID == 5) {
			m[0] = 1;
			m[1] = 0;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 1;
			m[1] = 1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 0;
			m[1] = 1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -1;
			m[1] = 1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -1;
			m[1] = 0;
			this.potentialMoves.add((int[])m.clone());
			m[0] = -1;
			m[1] = -1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 0;
			m[1] = -1;
			this.potentialMoves.add((int[])m.clone());
			m[0] = 1;
			m[1] = -1;
			this.potentialMoves.add((int[])m.clone());
		}
	}
}
