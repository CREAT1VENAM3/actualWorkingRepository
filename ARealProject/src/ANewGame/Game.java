package ANewGame;

public class Game implements Cloneable{
	
	int whoseTurn;
	Board board;
	Player p1;
	Player p2;
	boolean gameOver;
	
	PieceType pawnType;
	PieceType knightType;
	PieceType bishopType;
	PieceType rookType;
	PieceType queenType;
	PieceType kingType;
	
	Piece basePawn;
	Piece baseKnight;
	Piece baseBishop;
	Piece baseRook;
	Piece baseQueen;
	Piece baseKing;
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public Game() {
		this.whoseTurn = 0;
		this.board = new Board();
		this.p1 = new Player(0);
		this.p2 = new Player(1);
		this.gameOver = false;
		
		
		//building piece types
		this.pawnType = new PieceType(0);
		this.knightType = new PieceType(1);
		this.bishopType = new PieceType(2);
		this.rookType = new PieceType(3);
		this.queenType = new PieceType(4);
		this.kingType = new PieceType(5);
		
		//building generic piece templates
		this.basePawn = new Piece(pawnType);
		this.baseKnight = new Piece(knightType);
		this.baseBishop = new Piece(bishopType);
		this.baseRook = new Piece(rookType);
		this.baseQueen = new Piece(queenType);
		this.baseKing = new Piece(kingType);
		
		//building players' pawns
		int[] s = {0,0};
		for (int i = 0; i < 8; i++) {
			s[0] = 1;
			s[1] = i;
			this.p1.addPiece(new Piece(0, i+1, pawnType, s));
			s[0] = 6;
			s[1] = i;
			this.p2.addPiece(new Piece(1, i+1, pawnType, s));
		}
		
		//building players' knights
		s[0] = 0;
		s[1] = 1;
		this.p1.addPiece(new Piece(0, 9, knightType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 9, knightType, s));
		s[0] = 0;
		s[1] = 6;
		this.p1.addPiece(new Piece(0, 10, knightType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 10, knightType, s));
		
		//building players' bishops
		s[0] = 0;
		s[1] = 2;
		this.p1.addPiece(new Piece(0, 11, bishopType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 11, bishopType, s));
		s[0] = 0;
		s[1] = 5;
		this.p1.addPiece(new Piece(0, 12, bishopType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 12, bishopType, s));
		
		//building players' rooks
		s[0] = 0;
		s[1] = 0;
		this.p1.addPiece(new Piece(0, 13, rookType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 13, rookType, s));
		s[0] = 0;
		s[1] = 7;
		this.p1.addPiece(new Piece(0, 14, rookType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 14, rookType, s));
		
		//building players' queens
		s[0] = 0;
		s[1] = 3;
		this.p1.addPiece(new Piece(0, 15, queenType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 15, queenType, s));
		
		//building players' kings
		s[0] = 0;
		s[1] = 4;
		this.p1.addPiece(new Piece(0, 16, kingType, s));
		s[0] = 7;
		this.p2.addPiece(new Piece(1, 16, kingType, s));
		
		this.updateBoard();
		
	}
	
	public void updateBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.board.spaces[i][j].status = 0;
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < this.p1.currentPieces.size(); k++) {
					if (this.p1.currentPieces.get(k).location.equals(this.board.spaces[i][j].location)) {
						this.board.spaces[i][j].status = 1;
					}
				}
				for (int k = 0; k < this.p2.currentPieces.size(); k++) {
					if (this.p2.currentPieces.get(k).location.equals(this.board.spaces[i][j].location)) {
						this.board.spaces[i][j].status = 2;
					}
				}
			}
		}
		return;
	}
	
	public void movePiece(Piece p, int[] d) {
		if (p.side == 0) {
			if (this.board.spaces[d[0]][d[1]].status == 2) {
				for (int i = 0; i < p2.currentPieces.size(); i++) {
					if (p2.currentPieces.get(i).location.equals(d)) {
						p2.currentPieces.remove(i);
					}
				}
			}
		}
		else {
			if(this.board.spaces[d[0]][d[1]].status == 1) {
				for (int i = 0; i < p1.currentPieces.size(); i++) {
					if (p1.currentPieces.get(i).location.equals(d)) {
						p1.currentPieces.remove(i);
					}
				}
			}
		}
		p.location[0] = d[0];
		p.location[1] = d[1];
		this.updateBoard();
		return;
	}
	
	//LEGAL MOVES HELPER FUNCTIONS
	public boolean inBoundsCheck(Piece p, int[] l) {
		int[] d = {0,0};
		d[0] = p.location[0] + l[0];
		d[1] = p.location[1] + l[1];
		if (((d[0] < 8) && (d[0] > -1))&& ((d[1] < 8) && (d[1] > -1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean movingToAlliedPieceCheck(Piece p, int[] l) {
		int[] d = {0,0};
		d[0] = p.location[0] + l[0];
		d[1] = p.location[1] + l[1];
		if (this.board.spaces[d[0]][d[1]].status == p.side + 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean movingThroughPiecesCheck(Piece p, int[] l) {
		int[] d = {0,0};
		d[0] = p.location[0] + l[0];
		d[1] = p.location[1] + l[1];
		if (p.type.pieceTypeID == 1) {
			return true;
		}
		else {
			int[] e = {0,0};
			
			//horizontal (right) moves
			if ((l[0] == 0) && (l[1] > 0)) {
				e[0] = p.location[0];
				for (int i = 1; i < l[1]; i++) {
					e[1] = p.location[1] + i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//horizontal (left) moves
			else if ((l[0] == 0) && (l[1] < 0)) {
				e[0] = p.location[0];
				for (int i = -1; i > l[1]; i--) {
					e[1] = p.location[1] + i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//vertical (up) moves
			else if ((l[1] == 0) && (l[0] > 0)) {
				e[1] = p.location[1];
				for (int i = 1; i < l[0]; i++) {
					e[0] = p.location[0] + i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//vertical (down) moves
			else if ((l[1] == 0) && (l[0] < 0)) {
				e[1] = p.location[1];
				for (int i = -1; i > l[0]; i--) {
					e[0] = p.location[0] + i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//diagonal (up right) moves
			else if ((l[0] > 0) && (l[1] > 0)) {
				for (int i = 1; i < l[1]; i++) {
					e[0] = p.location[0] + i;
					e[1] = p.location[1] + i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//diagonal (up left) moves
			else if ((l[0] > 0) && (l[1] < 0)) {
				for (int i = 1; i < l[0]; i++) {
					e[0] = p.location[0] + i;
					e[1] = p.location[1] - i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//diagonal (down left) moves
			else if ((l[0] < 0) && (l[1] < 0)) {
				for (int i = -1; i > l[0]; i--) {
					e[0] = p.location[0] + i;
					e[1] = p.location[1] + i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			//diagonal (down right) moves
			else if ((l[0] < 0) && (l[1] > 0)) {
				for (int i = -1; i > l[0]; i--) {
					e[0] = p.location[0] + i;
					e[1] = p.location[1] - i;
					if (this.board.spaces[e[0]][e[1]].status != 0) {
						return false;
					}
				}
				return true;
			}
			
			else {
				return true;
			}
			
		}
	}
	
	public boolean movingIntoCheckCheck(Piece p, int[] l) {
		Game testGame = (Game)this.clone();
		
		if (p.side == 0) {
			boolean pieceFound = false;
			int i = 0;
			while (pieceFound == false) {
				if (testGame.p1.currentPieces.get(i).pieceID == p.pieceID) {
					pieceFound = true;
				}
				else {
					i++;
				}
			}
			testGame.movePiece(testGame.p1.currentPieces.get(i), l);
			testGame.updateInCheck(testGame.p1);
			if (testGame.isInCheck(testGame.p1) == false) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			boolean pieceFound = false;
			int i = 0;
			while (pieceFound == false) {
				if (testGame.p2.currentPieces.get(i).pieceID == p.pieceID) {
					pieceFound = true;
				}
				else {
					i++;
				}
			}
			testGame.movePiece(testGame.p2.currentPieces.get(i), l);
			testGame.updateInCheck(testGame.p2);
			if (testGame.isInCheck(testGame.p2) == false) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean isInCheck(Player p) {
		return p.inCheck;
	}
	
	public void updateInCheck (Player p) {
		int[] l = {0,0};
		int[] m = {0,0};
		for (int i = 0; i < p.currentPieces.size(); i++) {
			if (p.currentPieces.get(i).type.pieceTypeID == 5) {
				l[0] = p.currentPieces.get(i).location[0];
				l[1] = p.currentPieces.get(i).location[1];
			}
		}
		if (p.playerID == 0) {
			for (int i = 0; i < this.p2.currentPieces.size(); i++) {
				for (int j = 0; j < this.p2.currentPieces.get(i).legalMoves.size(); j++) {
					m[0] = this.p2.currentPieces.get(i).legalMoves.get(j)[0] + this.p2.currentPieces.get(i).location[0];
					m[1] = this.p2.currentPieces.get(i).legalMoves.get(j)[1] + this.p2.currentPieces.get(i).location[1];
					if ((m[0] == l[0]) && (m[1] == l[1])) {
						p.inCheck = true;
					}
				}
			}
			return;
		}
		else {
			for (int i = 0; i < this.p1.currentPieces.size(); i++) {
				for (int j = 0; j < this.p1.currentPieces.get(i).legalMoves.size(); j++) {
					m[0] = this.p1.currentPieces.get(i).legalMoves.get(j)[0] + this.p1.currentPieces.get(i).location[0];
					m[1] = this.p1.currentPieces.get(i).legalMoves.get(j)[1] + this.p1.currentPieces.get(i).location[1];
					if ((m[0] == l[0]) && (m[1] == l[1])) {
						p.inCheck = true;
					}
				}
			}
			return;
		}
	}
	
	public void updateLegalMoves(Piece p) {
		p.legalMoves.clear();
		int[] m = {0,0};
		for (int i = 0; i < p.legalMoves.size(); i++) {
			m[0] = p.legalMoves.get(i)[0];
			m[1] = p.legalMoves.get(i)[1];
			if (this.inBoundsCheck(p, m)) {
				if (this.movingToAlliedPieceCheck(p, m)) {
					if (this.movingThroughPiecesCheck(p, m)) {
						if (this.movingIntoCheckCheck(p, m)) {
							p.legalMoves.add((int[])m.clone());
						}
					}
				}
			}
		}
		return;
	}
	
	

}
