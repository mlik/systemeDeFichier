package filesys;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SystemeDeFichierTestCase {

	/**
	 * 
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
	 * 
	 */
	@Test
	public void testAjoutNullAuRepertoire(){
		Repertoire repertoireRacine = new Repertoire("racine");
		try {
			repertoireRacine.ajouter(null);
		} catch (Exception e) {
			fail(e.getMessage());
			assertEquals(MessagesErreurs.referenceNull, e.getMessage());
		}
	}
	

}
