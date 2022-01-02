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
	}

}
