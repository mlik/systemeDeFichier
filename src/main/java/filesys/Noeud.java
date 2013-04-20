package filesys;

/**
 * Classe abstraite qui défini un élément du système
 * 
 * @author mlik
 * 
 */
public abstract class Noeud {
	/**
	 * Nom de l'élément
	 */
	public String nom;

	/**
	 * Accesseur du nom
	 * 
	 * @return le nom de l'élément
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Calcul la taille de l'élément
	 * 
	 * @return la taille de l'élément
	 */
	abstract public int getTaille();
}
