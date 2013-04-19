package filesys;

public abstract class Noeud {
	 public String nom;
	 
	 public String getNom() {
		return nom;
	}

	abstract public int getTaille();
}
