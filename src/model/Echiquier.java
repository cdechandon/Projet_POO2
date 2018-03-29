package model;

import java.util.ArrayList;
import java.util.List;


public class Echiquier implements BoardGames {
	
	public String message;
	public Jeu jeu1;
	public Jeu jeu2;
	public Jeu jeuCourant;
	
	public Echiquier() {
		this.jeu1= new Jeu(Couleur.BLANC);
		this.jeu2= new Jeu(Couleur.NOIR);
		this.jeuCourant=jeu1;
	}
	
	/**
	 * 
	 * @return le joueur courant
	 */
	public Jeu getJeuCourant(){
		return this.jeuCourant;
	}
	
  /**
   * modifi le jeu courant 
   */
	public void switchJoueur(){
		if(getJeuCourant()==jeu1){
			this.jeuCourant=jeu2;
		}
		else{
			this.jeuCourant=jeu1;
		}
	}
	/**
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si le deplacement est effectif
	 */
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal){
		boolean moveOk=false;		
		// au moins une des deux coords finales est differente d'une des deux coords init
		if(xInit!=xFinal || yInit!=yFinal){ // ToDo limite du damier
			// si il y a une piece presente à l'emplacement et si le deplacement est autorisé
			if(this.jeuCourant.isPieceHere(xInit, yInit)&& 
					this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal)){
						moveOk=true;
			}
		}		
		return moveOk;
	}
	
	/**
	 * true si le déplacement est effectué, false sinon

	 */
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean move =false;
			if(this.isMoveOk(xInit, yInit, xFinal, yFinal)){
				this.jeuCourant.move(xInit, yInit, xFinal, yFinal);
				move=true;
			}
			
		return move;
	}
    public List<PieceIHM> getPiecesIHM(){
    	 List<PieceIHM> piecesIHM = new ArrayList<PieceIHM>();
    	
    	 for(int i=0;i<=jeu1.getPiecesIHM().size()-1;i++){
    		 
    		 piecesIHM.add(jeu1.getPiecesIHM().get(i)); 
    	 }
    	 for(int i=0;i<=jeu2.getPiecesIHM().size()-1;i++){
    		 piecesIHM.add(jeu2.getPiecesIHM().get(i)); 
    	 }
    	 
		return piecesIHM;
    	 
     }
     
     
	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	 private  void setMessage(String message){
		 this.message=message;
	 }
	@Override
	public Couleur getColorCurrentPlayer() {
		return this.jeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		
		return null;
	}
	
	public String toString(){
		String ret="Jeu1 : ";
		ret= ret+ jeu1.toString();
		ret= ret +"\n";
		ret= ret +jeu2.toString();
		return ret;
	}
	
	public static void main(String[] args) {
		
	Echiquier echeq =new Echiquier();
	//System.out.print(echeq.jeuCourant);
	System.out.print(echeq.getPiecesIHM());
	}

}
