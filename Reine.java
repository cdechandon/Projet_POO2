package model;

public class Reine extends AbstractPiece{
	
	private String name;
	private Couleur couleur_de_piece;
	private Coord coord;


	public Reine(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}
	Pieces maTour =  new Tour(Couleur.NOIR, new Coord(this.getX(),this.getY()));
	Pieces monFou =  new Fou(Couleur.NOIR, new Coord(this.getX(),this.getY()));
	

	@Override
	//Retourne true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		if(maTour.isMoveOk(xFinal, yFinal) || monFou.isMoveOk(xFinal, yFinal)){
			return true;
		}
		return false;
	}
	
	
}
