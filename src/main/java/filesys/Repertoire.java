package filesys;

import java.util.ArrayList;

public class Repertoire extends Noeud {
	private ArrayList<Noeud> contenu;

	public Repertoire() {
		contenu = new ArrayList<Noeud>();
	}
	
	public void ajouter(Noeud noeud){
		contenu.add(noeud);
	}
	
	
}
