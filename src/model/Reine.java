package model;

public class Reine extends AbstractPiece{

	Pieces maTour =  new Tour(Couleur.NOIR, new Coord(this.getX(),this.getY()));
	Pieces monFou =  new Fou(Couleur.NOIR, new Coord(this.getX(),this.getY()));
	

	public Reine(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}

	@Override
	//Retourne true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	public boolean isMoveOk(int xFinal, int yFinal) {
		
			return maTour.isMoveOk(xFinal, yFinal) || monFou.isMoveOk(xFinal, yFinal);
	}
	
}
