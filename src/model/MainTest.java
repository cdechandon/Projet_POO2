package model;

public class MainTest {

	public static void main(String[] args) {
		
		Coord coord = new Coord(2,5);
		Tour tour= new Tour(Couleur.BLANC,coord);
		Cavalier caval = new Cavalier(Couleur.BLANC,coord);
		Roi roi = new Roi(Couleur.BLANC,coord);
		System.out.println(tour.toString() + " caval .isMoveOk() : "+ roi.isMoveOk(3,4));
		 
	}

}
