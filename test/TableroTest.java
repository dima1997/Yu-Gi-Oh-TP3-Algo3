import junit.framework.TestCase;

public class TableroTest extends TestCase {

    public void testActivarEfectoWastelandAumenta200AlAtaqueDeJugadorPropioYAumenta300DefensaJugadorOponente(){

        Tablero tablero = new Tablero();

        Jugador jugadorPropio = new Jugador("1", 4);
        Jugador jugadorOponente = new Jugador("2", 5);

        Campo campoPropio = jugadorPropio.obtenerCampo();
        Campo campoOponente = jugadorOponente.obtenerCampo();

        MonstruoComun mPropio = new MonstruoComun(400,100,3);
        MonstruoComun mOponenete = new MonstruoComun(10,100,3);
        EfectoWasteland wasteland = new EfectoWasteland(campoPropio, campoOponente);
        CartaCampo cartaWasteland = new CartaCampo(wasteland);

        tablero.colocarMonstruoEnPosAtaque(jugadorPropio, mPropio);
        tablero.agregarCartaDeCampo(cartaWasteland);
        tablero.colocarMonstruoEnPosDefensa(jugadorOponente, mOponenete);

        assertEquals(mPropio.obtenerPuntos(), 600);
        assertEquals(mOponenete.obtenerPuntos(), 400);
    }


}

