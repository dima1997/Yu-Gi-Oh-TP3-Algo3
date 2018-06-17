import junit.framework.TestCase;

public class PosDefensaTest extends TestCase {

    public void testPosDefensaObtenerPuntosDevuelveLaDefensaDelMonstruo() {

        PosDefensa d = new PosDefensa();

        assertEquals(d.obtenerPuntos(100, 1), 1);

    }

    public void testPosDefensaDanioDePersonajeDevuelveCero(){

        PosDefensa p = new PosDefensa();

        assertEquals(p.danioDePersonaje(200), 0);

    }

    public void testPosDefensaMatarAUnMonstruoNoLoAgregaAlBotinDeMuertos(){

        PosDefensa p = new PosDefensa();
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        Monstruo m = new Monstruo(1,1,1);
        unCampo.colocarMonstruo(m);
        Botin b = new Botin();

        p.matar(m, b);

        b.ejecutar(unCampo);

        assertFalse(c.esta(m));

    }

    public void testPosDefensaAtacarPosAtaqueAitsuContraAgujaAsesinaYSeLevantaUnaExcepcion(){
        PosicionStrategy posicionAtacante = new PosDefensa();
        PosicionStrategy posicioAtacada = new PosAtaque();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        aitsu.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();
        boolean lanzoError = false;

        try{

            posicionAtacante.atacar(posicioAtacada,aitsu,agujaAsesina);

        }catch(MonstruoNoSeEncuentraEnArenaDeJuegoError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }
}