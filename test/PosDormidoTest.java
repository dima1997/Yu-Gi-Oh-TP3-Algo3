import junit.framework.TestCase;

public class PosDormidoTest extends TestCase {

    public void testPosDormidoObtenerPuntosLanzaExcepcion() {

        PosDormido p = new PosDormido();
        boolean lanzoError = false;

        try{

            p.obtenerPuntos(1, 1);

        }catch(MonstruoNoSeEncuentraEnArenaDeJuegoError e ){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }

    public void testPosDormidoDanioDePersonajeDevuelveCero(){

        PosDormido p = new PosDormido();

        assertEquals(p.danioDePersonaje(200), 0);

    }

    public void testPosDormidoMatarAUnMonstruoNoLoAgregarAlbotin(){

        PosDormido p = new PosDormido();
        Botin b = new Botin();
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        Monstruo m = new Monstruo(1,1,1);
        unCampo.colocarMonstruo(m);
        p.matar(m, b);

        b.ejecutar(unCampo);

        assertFalse(c.esta(m));

    }

    public void testPosDormidaAtacarLanzaError(){
        PosicionStrategy posicionAtacante = new PosDormido();
        PosicionStrategy posicionAtacada = new PosAtaque();
        boolean lanzoError = false;

        try{

            posicionAtacante.atacar(posicionAtacada, new Monstruo(1,1,1), new Monstruo(1,1,1));

        }catch(MonstruoNoSeEncuentraEnArenaDeJuegoError e ){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }


}
