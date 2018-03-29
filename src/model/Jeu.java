package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	private Couleur couleur;
	private List<Pieces> pieces;
	
	public Jeu(Couleur couleur){
		this.couleur=couleur;
		this.pieces = ChessPiecesFactory.newPieces(this.couleur); 	 // recupere la liste de pieces constuite par la fabrique de piece

	}

	public Couleur getCouleur(){
		return this.couleur;
	}

	// return true si une piece se trouve aux coords indiquées
	public boolean isPieceHere(int x, int y){
		boolean pieceHere=false;
		if(findPiece(x,y)!=null){
				pieceHere=true;
				
			}
		return pieceHere;

		}
	/**
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return  effectue le deplcament si déplacement pièce effectué
	 */
		public boolean move(int xInit, int yInit, int xFinal, int yFinal){
			boolean move=false;
			if (isMoveOk(xInit, yInit, xFinal, yFinal)){
				System.out.print("\n deplcament de: "+this.getPieceType(xInit, yInit)+ "coords"+this.findPiece(xInit, yInit).getCoord());
				this.findPiece(xInit, yInit).move(xFinal, yFinal);
				move= true;
			}
			return move;
		}
		/**
		 * 
		 * @param x
		 * @param y
		 * @return couleur de la pièce aux coordonnées x, y
		 */
		public Couleur getPieceColor(int x,int y){
			Pieces pieces = findPiece(x,y);
			return(pieces.getCouleur());
		}
		/**
		 * 
		 * @param x
		 * @param y
		 * @return une piece aux coords (x,y)
		 */
	private Pieces findPiece(int x,int y){
		for(int i=0;i<=this.pieces.size()-1;i++){
			if(this.pieces.get(i).getX()==x && this.pieces.get(i).getY()==y){
				return pieces.get(i);
			}
		}
		return null;
		
	}
	/**
	 * 	//   
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return  true si piece du jeu peut etre dÃ©deplacee aux 
	 * coordonnees finales, false sinon
	 */
	public boolean isMoveOk(int xInit,int yInit,int xFinal, int yFinal){
		boolean moveOk =false;
		Pieces pieces = findPiece(xInit, yInit);
		Pieces piecesFinale = findPiece(xFinal, yFinal);// recupere la pices en init
			if(isPieceHere(xFinal,yFinal) && piecesFinale.getCouleur()==this.getCouleur()){ // si il ya une piece et quelle est de la meme couleur
				 return moveOk;
				}

		return  pieces.isMoveOk(xFinal, yFinal);

	}
	

	/**
	 * 
	 * @param x
	 * @param y
	 * @return le type de  la piece situee aux coords x y
	 */
	public String getPieceType(int x, int y){
		Pieces piece = findPiece(x,y);
		return piece.getClass().getSimpleName();
	}
	
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM =null;
		 List<PieceIHM> list = new LinkedList<PieceIHM>();
		 for( Pieces piece : pieces){
			 boolean existe = false;
			 for(PieceIHM pieceIHM :list){
				 if((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					 existe=true;
					 if(piece.getX()!=-1){
						 pieceIHM.add(new Coord(piece.getX(),piece.getY()));
					 }
				 }
			 }
			 if (! existe) {
				 if (piece.getX() != -1){
					 newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					 piece.getCouleur());
					 newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					 list.add(newPieceIHM);
				 }
			 }
		 }
		 System.out.print(list);
		return list;
		
		}
	public String toString(){
		String ret="";
		for(int i=0;i<= pieces.size()-1;i++){
			ret= ret + "\n" +pieces.get(i).toString();
		}
		return ret;
		
	}
	
	//FixMe
	/**
	 * 
	 * @return les coords du roi 
	 */
	/*
	public Coord getKingCoord(){
		Coord coordRoi= null;
		for(int i=0;i<pieces.size()-1;i++){
			System.out.println(pieces.get(i).getClass().getSimpleName().toString());
			if (pieces.get(i).getClass().getName().toString()== "Roi"){
				System.out.println("bb");
				coordRoi=pieces.get(i).getCoord();
			}
		}
		return coordRoi;
	}
*/
	public static void main(String[] args) {
		Jeu jeu = new Jeu(Couleur.BLANC);
	
		System.out.println(jeu.getPiecesIHM());


	}

}
