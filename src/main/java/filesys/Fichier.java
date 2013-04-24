package filesys;

/**
 * classe fichier 
 * @author mlik
 *
 */
public class Fichier extends Noeud {
	/**
	 * taille de fichier
	 */
	 public int taille;

	 /**
	  * Constructeur de la classe fichier
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
