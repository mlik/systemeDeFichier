package filesys;

import java.util.ArrayList;

public class Repertoire extends Noeud {
	private ArrayList<Noeud> contenuDuRepertoire;
	
	public Repertoire(String nom) {
		contenuDuRepertoire = new ArrayList<Noeud>();
		this.nom = nom;
	}
	
	public void ajouter(Noeud noeud) throws Exception{
		if(noeud == null) throw new Exception(MessagesErreurs.referenceNull);
		if(contientMemeNom(noeud.getNom())) throw new Exception(MessagesErreurs.elementDupliquee);
		if(this.equals(noeud)) throw new Exception(MessagesErreurs.memeInstance);
		contenuDuRepertoire.add(noeud);
	}

	private boolean contientMemeNom(String nom) {
		for(Noeud noeud:contenuDuRepertoire){
			if(noeud.getNom().equals(nom)) return true;
		}
		return false;
	}

	@Override
	public int getTaille() {
		int resultat = 0;
		for(Noeud noeud:contenuDuRepertoire){
			resultat += noeud.getTaille();
		}
		return resultat;
	}
	
	
}
