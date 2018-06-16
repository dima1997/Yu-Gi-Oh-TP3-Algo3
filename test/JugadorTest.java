import junit.framework.TestCase;

public class JugadorTest extends TestCase {

	public void testVerVidaDeJugador () {
		
		Jugador jugadorUno = new Jugador("nombreJugador", 8000);		
		assertEquals(jugadorUno.verVida(), 8000);
		
	}
	
	public void testJugadorRecibeAtaqueYSeLeRestaLaVidaCorrecta () {
		
		Jugador jugadorUno = new Jugador("nombreJugador", 8000);		
		jugadorUno.recibirAtaque(7334);
		int resultadoEsperado = 8000-7334;
		
		assertEquals(jugadorUno.verVida(), resultadoEsperado);
		
	}

	public void testJugadorColocarMonstruoColocaAlMonstruoEnSuCampo(){
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador("", 100, unCampo);
		Monstruo unMonstruo = new Monstruo(1,1,1);

		unJugador.colocarCarta(unMonstruo);
	}

	public void testJugadorAplicarEfectoSobreCampoEfectoAgujeroNegroAplicaDichoEfectoSobreElCampoDelJugador(){
		Campo campoUno = new Campo();
		Jugador unJugador = new Jugador("1",8000, campoUno);

		Monstruo mokeyMokey = new Monstruo(300,100,3);
		Monstruo aitsu = new Monstruo(100,100,5);
		Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
		Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);

		unJugador.colocarCarta(mokeyMokey);
		unJugador.colocarCarta(aitsu);
		unJugador.colocarCarta(agresorOscuro);
		unJugador.colocarCarta(agujaAsesina);

		EfectoSobreCampo efectoAgujeroNegro = new EfectoAgujeroNegro();

		unJugador.aplicarEfectoSobreCampo(efectoAgujeroNegro);

		assertFalse(campoUno.esta(mokeyMokey));
		assertFalse(campoUno.esta(aitsu));
		assertFalse(campoUno.esta(agresorOscuro));
		assertFalse(campoUno.esta(agresorOscuro));
	}
}
