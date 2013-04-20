package filesys;

import java.util.ArrayList;

public class Repertoire extends Noeud {
	private ArrayList<Noeud> contenuDuRepertoire;
	private ArrayList<Repertoire> listeDesParents;
	
	public Repertoire(String nom) {
		contenuDuRepertoire = new ArrayList<Noeud>();
		listeDesParents = new ArrayList<Repertoire>();
		this.nom = nom;
	}
	
	public void ajouter(Noeud noeud) throws Exception{
		if(noeud == null) throw new Exception(MessagesErreurs.referenceNull);
		if(contientMemeNom(noeud.getNom())) throw new Exception(MessagesErreurs.elementDupliquee);
		if(this.equals(noeud)) throw new Exception(MessagesErreurs.memeInstance);
		if(listeDesParents.contains(noeud)) throw new Exception(MessagesErreurs.memeInstanceIndirectement);
		contenuDuRepertoire.add(noeud);
		incrementerListeDesParents(noeud);
	}

	private void incrementerListeDesParents(Noeud noeud) {
		if(noeud instanceof Repertoire){
			Repertoire repAAjouter = (Repertoire) noeud;
			repAAjouter.getListeDesParents().addAll(listeDesParents);
			repAAjouter.getListeDesParents().add(this);
		}
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

	public ArrayList<Repertoire> getListeDesParents() {
		return listeDesParents;
	}
	
	
}
