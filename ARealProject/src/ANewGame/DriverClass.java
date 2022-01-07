package ANewGame;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TO BE DONE
		
		//Rebuild Space Class - IN PROGRESS (WAITING ON OTHER CLASSES TO BE FINISHED)
		//Finish Rebuilding PieceType - IN PROGRESS (WAITING ON OTHER CLASSES TO BE FINISHED)
		//Rebuild Board - IN PROGRESS (WAITING ON OTHER CLASSES TO BE FINISHED)
		//Rebuild Piece - IN PROGRESS (WAITING ON OTHER CLASSES TO BE FINISHED)
		//Rebuild Player - IN PROGRESS (WAITING ON OTHER CLASSES TO BE FINISHED)
		//Build Basic Game Structure (including code to start a game) (For testing) - IN PROGRESS
		//Build Move Function - DONE
		//Rebuild Legal Move Checks (In Bounds, Not Moving Onto Allied Piece, Not Moving through pieces, not moving into check) - DONE
		//Create Visual Representation
		//Build Game into playable state (actually taking turns, winning and losing, etc)
		
		Game newGame = new Game();
		System.out.println("Player 1 in check: " + newGame.p1.inCheck);
		newGame.printBoard();
		newGame.updateAllPiecesMoves();
		System.out.println("Player 1 in check: " + newGame.p1.inCheck);
		int[] m = {2,1};
		newGame.attemptMove(newGame.p1.currentPieces.get(1), m);
		System.out.println("Player 1 in check: " + newGame.p1.inCheck);
		System.out.println(newGame.p1.currentPieces.get(8).legalMoves.size());
		newGame.updateLegalMoves(newGame.p1.currentPieces.get(8));
		System.out.println("Player 1 in check: " + newGame.p1.inCheck);
		System.out.println(newGame.p1.currentPieces.get(8).legalMoves.size());
		System.out.println(newGame.p1.currentPieces.get(8).type.pieceTypeID);
		System.out.println(newGame.p1.inCheck);
		System.out.println("Player 1 in check: " + newGame.p1.inCheck);
	}

}
