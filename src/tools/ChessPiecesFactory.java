package tools;

import java.util.LinkedList;
import java.util.List;

import model.Coord;
import model.Couleur;
import model.Pieces;

/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 * 
 * Classe qui fabrique une liste de pieces de jeu d'echec
 * de la couleur pass�e en param�tre
 *
 */
public class ChessPiecesFactory {

	/**
	 * private pour ne pas instancier d'objets
	 */
	private ChessPiecesFactory() {

	}

	/**
	 * @param pieceCouleur
	 * @return liste de pi�ces de jeu d'�chec
	 */
	public static List<Pieces> newPieces(Couleur pieceCouleur){

		List<Pieces> pieces = null;
		pieces = new LinkedList<Pieces>();
		String initCouleur = (Couleur.BLANC == pieceCouleur ? "B_" : "N_" );

		if (pieceCouleur != null){
			for (int i = 0; i < ChessPiecePos.values().length; i++) {
				// parcour toutes les pieces
				if (pieceCouleur.equals(ChessPiecePos.values()[i].couleur)) {
					// parcour les coords de chaque piece
					for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
						
						String className = "model." + ChessPiecePos.values()[i].nom;	// attention au chemin reucpere le nom de la classe de la piece ( tour, roi etc)
						Coord pieceCoord = ChessPiecePos.values()[i].coords[j]; // recupere les coord des dif pieces de cette classe
						pieces.add((Pieces) Introspection.newInstance (className, // construit la piece avec son constructeur et l'ajoute à la liste pieces
								new Object[] {pieceCouleur, pieceCoord}));
						
					}
				}
			}
		}
		return pieces;
	}

	/**
	 * Tests unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessPiecesFactory.newPieces(Couleur.BLANC));
	}
}
