package filesys;

public interface MessagesErreurs {
	public static String referenceNull = "Reference null";
	public static String elementDupliquee = "Un élément existe déjà avec le même nom";
	public static String memeInstance = "un répertoire ne peut pas être ajouté à lui-même";
	public static String memeInstanceIndirectement = "un répertoire ne peut pas être un sous-répertoire de lui-même (même indirectement)";
}
