package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerLunatiqueTest extends PassagerAbstraitTest{

	@Test
	public void testToString() {
		assertEquals(passager1.toString(), "psg1 DEHORS");
	}
	

	@Override
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		// TODO Auto-generated method stub
		return new PassagerLunatique(nom,destination);
	}
	
	
	@Test
	public void testchoixChangerPlace() throws UsagerInvalideException {
		Bus newBus = new FauxBusVide();
		passager1.choixPlaceMontee(newBus);
		assertTrue(passager1.etat.monEtat == Etat.DEBOUT);
		passager1.choixChangerPlace(newBus, 5);
		assertTrue(passager1.etat.monEtat == Etat.DEHORS);
	}
	
	@Test
	public void testchoixPlaceMonteeDebout() throws UsagerInvalideException {
		Bus busDebout = new FauxBusDebout();
			passager1.choixPlaceMontee(busDebout);
			assertTrue(passager1.estDebout());
	}
	@Test
	public void testchoixPlaceMonteeVide() throws UsagerInvalideException {
		Bus busVide = new FauxBusVide();
		passager1.choixPlaceMontee(busVide);
		assertTrue(passager1.estDebout());
	}
	@Test
	public void testchoixPlaceMonteePlein()throws UsagerInvalideException {
		Bus busPlein = new FauxBusPlein();
		passager1.choixPlaceMontee(busPlein);
		assertTrue(passager1.estDehors());
	}
	
	@Test
	public void testchoixPlaceMonteeAssis() throws UsagerInvalideException {
		Bus busAssis = new FauxBusAssis();
		passager1.choixPlaceMontee(busAssis);
		assertTrue(passager1.estDehors());

	}

}
