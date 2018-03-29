package model;

public interface Pieces {
	
	public int getX();
	public int getY ();
	public Coord getCoord();
	public Couleur getCouleur();
	public boolean isMoveOk(int xFinal, int yFinal);
	public boolean move(int xFinal,int yFinal);
	public boolean capture();

}
