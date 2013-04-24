package filesys;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SystemeDeFichierTestCase {

	/**
	 * Teste le calcule de la taille du repertoire 
	 * @throws Exception
	 */
	@Test
	public void testCalculTaille() throws Exception {
		Repertoire repertoireRacine = new Repertoire("racine");
		Repertoire repertoireNiveau1 = new Repertoire("niveau1");
		Repertoire repertoireNiveau2 = new Repertoire("niveau2");
		Fichier fichierA = new Fichier("A", 20);
		Fichier fichierB = new Fichier("B", 20);
		Fichier fichierC = new Fichier("C", 20);
		Fichier fichierD = new Fichier("D", 20);

		repertoireNiveau2.ajouter(fichierC);
		repertoireNiveau2.ajouter(fichierD);
		repertoireNiveau1.ajouter(repertoireNiveau2);
		repertoireNiveau1.ajouter(fichierB);
		repertoireRacine.ajouter(repertoireNiveau1);
		repertoireRacine.ajouter(fichierA);

		assertEquals(80, repertoireRacine.getTaille());
	}

	/**
	 * Teste l'ajout d'une referecence nul dans un repertoire
	 */
	@Test
	public void testAjoutNullAuRepertoire() {
		Repertoire repertoireRacine = new Repertoire("racine");
		try {
			repertoireRacine.ajouter(null);
			fail();
		} catch (Exception e) {
			assertEquals(MessagesErreurs.referenceNull, e.getMessage());
		}
	}
	/**
	 * Teste le cas d'ajout element qui contient le meme nom qu'un element existant
	 */
	@Test
	public void testAjoutElementAvecLeMemeNom() {
		Repertoire repertoireRacine = new Repertoire("racine");
		Repertoire repertoireNiveau1 = new Repertoire("niveau1");
		Fichier fichierA = new Fichier("niveau1", 20);

		try {
			repertoireRacine.ajouter(repertoireNiveau1);
			repertoireRacine.ajouter(fichierA);
			fail();
		} catch (Exception e) {
			assertEquals(MessagesErreurs.elementDupliquee, e.getMessage());
		}

	}
	/**
	 * Teste le cas d'jout un repertoire à lui meme
	 */
	@Test
	public void testAjoutRepertoireALuiMeme() {
		Repertoire repertoireRacine = new Repertoire("racine");
		try {
			repertoireRacine.ajouter(repertoireRacine);
			fail();
		} catch (Exception e) {
			assertEquals(MessagesErreurs.memeInstance, e.getMessage());
		}
	}
	/**
	 * Teste d'ajout d'un repertoire à lui meme indirectement 
	 */
	@Test
	public void testAjoutRepertoireIndirectement() {
		Repertoire repertoireRacine = new Repertoire("racine");
		Repertoire repertoireNiveau1 = new Repertoire("niveau1");
		try {
			repertoireRacine.ajouter(repertoireNiveau1);
			repertoireNiveau1.ajouter(repertoireRacine);
			fail();
		} catch (Exception e) {
			assertEquals(MessagesErreurs.memeInstanceIndirectement,
					e.getMessage());
		}
	}

}
