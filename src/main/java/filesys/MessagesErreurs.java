package filesys;
/**
 * Classe qui contient les messages d'erreur 
 * @author mlik
 *
 */
public interface MessagesErreurs {
	/**
	 * reference null
	 */
	public static String referenceNull = "Reference null";
	/**
	 * element existe deja avec le meme nom
	 */
	public static String elementDupliquee = "Un élément existe déjà avec le même nom";
	/**
	 * un repertoire ne peut pas etre ajouté à lui meme
	 */
	public static String memeInstance = "un répertoire ne peut pas être ajouté à lui-même";
	/**
	 * une repertoire ne peut pas etre un sous repertoire à lui meme
	 */
	public static String memeInstanceIndirectement = "un répertoire ne peut pas être un sous-répertoire de lui-même (même indirectement)";
}
