import junit.framework.TestCase;

public class EfectoFisuraTest extends TestCase {
	
	/*Colocar 2 monstruos en el campo enemigo, con diferente ataque. 
	 * Activo la carta mágica Fisura, y verificar que el de menor ataque es destruido. */
	
	/* Efecto: estruye el monstruo boca arriba con menor ataque en el campo del oponente
	 *  (si hay empate elige al azar).*/
	
	public void testActivarEfectoFisuraEnUnCampoCuandoHayDosMonstruosConDiferenteAtaqueDestruyeAlDeMenorAtaque() {
		
		Cementerio unCementerio = new Cementerio();
		Campo unCampo = new Campo(unCementerio);
		Monstruo monstruoMenorAtaque = new Monstruo(100, 0, 1);
		Monstruo monstruoMayorAtaque = new Monstruo(150, 0, 1);
		EfectoSobreCampo efectoFisura = new EfectoFisura();
		
		monstruoMenorAtaque.colocarEnPosAtaque();
		monstruoMayorAtaque.colocarEnPosDefensa();
		unCampo.colocarMonstruo(monstruoMayorAtaque);
		unCampo.colocarMonstruo(monstruoMenorAtaque);

		efectoFisura.activar(unCampo);
		
		assertTrue(unCampo.esta(monstruoMayorAtaque));
		assertFalse(unCampo.esta(monstruoMenorAtaque));
		
		assertTrue(unCementerio.esta(monstruoMenorAtaque));
		assertFalse(unCementerio.esta(monstruoMayorAtaque));
		
	}
}
