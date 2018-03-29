package model;

public class Fou extends AbstractPiece{
	

	public Fou(Couleur couleur_de_piece, Coord coord){
		super(couleur_de_piece, coord);
	}


	@Override
	//Retourne true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		 return yFinal - getY()== xFinal-getX();
			
	}
	
	
}

