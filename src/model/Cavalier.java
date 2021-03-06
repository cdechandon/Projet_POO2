package model;

public class Cavalier extends AbstractPiece {

	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	// le cavalier se deplace en L ( 2 puis 1)
	public boolean isMoveOk(int xFinal, int yFinal) {
		// deplacement en x
		int dx = xFinal-this.getX();
		//deplacement en y
		int dy = yFinal-this.getY();
		 // si la piece se deplace de + ou - deux colonnes  et + ou - une ligne ou
		// si la piece se deplace de + ou - deux lignes  et + ou - une colonnes.
		return ( Math.abs(dx)==2 && Math.abs(dy)==1 )|| (Math.abs(dy)==2 && Math.abs(dx)==1);
	}

}
