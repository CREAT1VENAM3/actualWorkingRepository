package ANewGame;

public class Board implements Cloneable {
	
	Space[][] spaces;
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public Board() {
		 this.spaces = new Space[8][8];
		 int[] s = {0,0};
		 for (int i = 0; i < 8; i++) {
			 for (int j = 0; j < 8; j++) {
				 s[0] = i;
				 s[1] = j;
				 this.spaces[i][j] = new Space((int[])s.clone());
			 }
		 }
	}

}
