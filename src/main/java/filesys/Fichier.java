package filesys;

/**
 * 
 * @author mlik
 *
 */
public class Fichier extends Noeud {
	/**
	 * 
	 */
	 public int taille;

	 /**
	  * 
	  * @param nom
	  * @param taille
	  */
	public Fichier(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
	}

	@Override
	public int getTaille() {
		return taille;
	}
	 
	 
}
