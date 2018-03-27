package model;

public class Pion extends AbstractPiece{
	
	private String name;
	private Couleur couleur_de_piece;
	private Coord coord;


	public Pion(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}


	@Override
	//Retourne true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	public boolean isMoveOk(int xFinal, int yFinal) {
		if((getX()==xFinal) && (getY()+1==yFinal || getY()+2 == yFinal) ){
			return true;
		}
		return false;
	}
	
	
}
	