package model;

public class Roi extends AbstractPiece{

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	// Le roi peut se deplacer d'une case dans toutes les directions
	public boolean isMoveOk(int xFinal, int yFinal) {
		if(this.getX()-1<= xFinal && this.getX()+1>= xFinal ) {
			if(this.getY()-1<= yFinal && this.getY()+1>= yFinal ) {
				return true;
				
			}
		}
		return false;
	}
	

}
