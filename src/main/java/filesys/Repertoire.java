package filesys;
import java.util.ArrayList;

/**
 * Classe qui represente un repertoire ...
 * @author mlik
 *
 */
public class Repertoire extends Noeud {
	/**
	 * Contenu du repertoire 
	 */
	private ArrayList<Noeud> contenuDuRepertoire;
	/**
	 * Liste des parents
	 */
	private ArrayList<Repertoire> listeDesParents;
	/**
	 * Constructeur repertoire
	 * @param nom
	 */
	public Repertoire(String nom) {
		contenuDuRepertoire = new ArrayList<Noeud>();
		listeDesParents = new ArrayList<Repertoire>();
		this.nom = nom;
	}
	
	/**
	 * Ajouter un repertoire ou un fichier dans le repertoire conrant 
	 * @param noeud
	 * @throws Exception
	 */
	public void ajouter(Noeud noeud) throws Exception {
		if (noeud == null)
			throw new Exception(MessagesErreurs.referenceNull);
		if (contientMemeNom(noeud.getNom()))
			throw new Exception(MessagesErreurs.elementDupliquee);
		if (this.equals(noeud))
			throw new Exception(MessagesErreurs.memeInstance);
		if (listeDesParents.contains(noeud))
			throw new Exception(MessagesErreurs.memeInstanceIndirectement);
		contenuDuRepertoire.add(noeud);
		incrementerListeDesParents(noeud);
	}
	/**
	 * methode pour incrementer la liste des parents
	 * @param noeud
	 */
	private void incrementerListeDesParents(Noeud noeud){
		if (noeud instanceof Repertoire) {
			Repertoire repAAjouter = (Repertoire) noeud;
			repAAjouter.getListeDesParents().addAll(listeDesParents);
			repAAjouter.getListeDesParents().add(this);
		}
	}
	/**
	 * methode qui retourne faux si le nom de l'element existe deja 
	 * @param nom
	 * @return faux si le nom de l'element existe deja 
	 */
	private boolean contientMemeNom(String nom) {
		for (Noeud noeud : contenuDuRepertoire) {
			if (noeud.getNom().equals(nom))
				return true;
		}
		return false;
	}
	
	@Override
	public int getTaille() {
		int resultat = 0;
		for (Noeud noeud : contenuDuRepertoire) {
			resultat += noeud.getTaille();
		}
		return resultat;
	}
	/**
	 * Accesseur sur la liste des parents 
	 * @return liste des parents
	 */
	public  ArrayList<Repertoire> getListeDesParents() {
		return listeDesParents;
	}

}
