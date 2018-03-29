package model;

public class Roi extends AbstractPiece{

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	// Le roi peut se deplacer d'une  seule case dans toutes les directions
	public boolean isMoveOk(int xFinal, int yFinal) {
		// deplacement en x
		int dx = xFinal-this.getX();
		//deplacement en y
		int dy = yFinal-this.getY();
		// si X-1<=xFinal<=X+1 et si Y-1<=yFinal<=Y+1 il faut que le deplacement ne soit pas superieur à 1
		return Math.abs(dx)<=1 && Math.abs(dy)<=1 ;
	}
	

}
