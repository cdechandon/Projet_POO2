package model;

public class Tour extends AbstractPiece {
	

	
	public Tour(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
		
	}
	

	@Override
	// return true si le deplacement est legal
	public boolean isMoveOk(int xFinal, int yFinal) {		
			return this.getX()==xFinal ||this.getY()==yFinal ;
	}

}
