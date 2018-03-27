package model;

public class Fou extends AbstractPiece{
	
	private String name;
	private Couleur couleur_de_piece;
	private Coord coord;


	public Fou(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}


	@Override
	//Retourne true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	public boolean isMoveOk(int xFinal, int yFinal) {
		if(yFinal - getY()== xFinal-getX()){
			return true;
		}
		return false;
	}
	
	
}

