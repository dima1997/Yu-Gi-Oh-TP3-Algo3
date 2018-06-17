import junit.framework.TestCase;

public class PosAtaqueTest extends TestCase {

    public void testPosAtaqueObtenerPuntosDevuelveElAtaqueDelMonstruo() {

        PosAtaque d = new PosAtaque();

        assertEquals(d.obtenerPuntos(100, 1), 100);

    }

    public void testPosAtaqueDanioDePersonajeDevuelveElResultadoDeLaPelea(){

        PosAtaque p = new PosAtaque();

        assertEquals(p.danioDePersonaje(200), 200);

    }

    public void testPosAtaqueDanioDePersonajeDevuelveElResultadoDeLaPeleaEnModulo(){

        PosAtaque p = new PosAtaque();

        assertEquals(p.danioDePersonaje(-200), 200);

    }

    public void testPosAtaqueMatarAUnMonstruoLoAgregaAlBotinDeMuertos(){

        PosAtaque p = new PosAtaque();
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        Monstruo m = new Monstruo(1,1,1);
        unCampo.colocarMonstruo(m);
        Botin b = new Botin();

        p.matar(m, b);

        b.ejecutar(unCampo);

        assertTrue(c.esta(m));

    }
    /*
    public void testPosAtaqueAtacarNoLanzaError(){

        PosAtaque p = new PosAtaque();
        boolean lanzoError = false;

        try{

            p.atacar();

        }catch(MonstruoNoSeEncuentraEnArenaDeJuegoError e ){

            lanzoError = true;

        }

        assertFalse(lanzoError);
    }
    */
    //Pruebas de ataque

    public void testPosAtaqueAtacarPosAtaqueAitsuContraAgujaAsesinaYAitsuMuere(){
        PosAtaque posicionAtacante = new PosAtaque();
        PosAtaque posicionAtacada = new PosAtaque();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(aitsu);
        unCampo.colocarMonstruo(agujaAsesina);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacante, aitsu, agujaAsesina);
        b.ejecutar(unCampo);

        assertTrue(c.esta(aitsu));
    }

    public void testPosAtaqueAtacarPosAtaqueAgujaAsesinaContraAlasDeLaLlamaPerversaYAlasDeLaLlamaPerversaMuere(){
        PosAtaque posicionAtacante = new PosAtaque();
        PosAtaque posicionAtacada = new PosAtaque();
        Monstruo alasDeLlamaPerversa = new Monstruo(700, 600, 2);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(alasDeLlamaPerversa);
        unCampo.colocarMonstruo(agujaAsesina);
        alasDeLlamaPerversa.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();


        Botin b = agujaAsesina.atacar(alasDeLlamaPerversa);
        b.ejecutar(unCampo);

        assertTrue(c.esta(alasDeLlamaPerversa));
    }
    /*
    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnAtaqueYMuerenAmbos(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(agresorOscuro);
        unCampo.colocarMonstruo(agujaAsesina);
        agresorOscuro.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(unCampo);

        assertTrue(c.esta(agresorOscuro));
        assertTrue(c.esta(agujaAsesina));
    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnDefensaYNingunoMuere(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(aitsu);
        unCampo.colocarMonstruo(agujaAsesina);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(unCampo);

        assertFalse(c.esta(aitsu));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYMuereAgresorOscuro(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(agresorOscuro);
        unCampo.colocarMonstruo(agujaAsesina);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(unCampo);

        assertTrue(c.esta(agresorOscuro));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYElBotinNoQuitaVida(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 1000);
        Jugador atacado = new Jugador("", 1000);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 1000);
        assertEquals(atacado.verVida(), 1000);

    }

    public void testPeleaAitsuAtacadoEnAtaqueContraAgujaAsesinaAtacanteEnAtaqueYElBotinQuita1100DeVidaAlAtacado(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000 - 1100);

    }

    public void testPeleaAitsuAtacanteEnAtaqueContraAgujaAsesinaAtacadoEnAtaqueYElBotinQuita1100DeVidaAlAtacante(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = aitsu.atacar(agujaAsesina);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000 - 1100);
        assertEquals(atacado.verVida(), 10000);

    }


    public void testPeleaAitsuEnDefensaContraAgujaAsesinaEnAtaqueYElBotinNoQuitaVida(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000);

    }

    public void testAitsuEnPosDefensaIntentaAtacarAAgujaAsesinaYSeLevantaUnaExcepcion(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        aitsu.colocarEnPosDefensa();

        boolean lanzoError = false;

        try{

            aitsu.atacar(agujaAsesina);

        }catch(MonstruoNoSeEncuentraEnArenaDeJuegoError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }

    public void testAitsuEnPosAtaqueIntentaAtacarAAgujaAsesinaYNoSeLevantaUnaExcepcion(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        boolean lanzoError = false;

        try{

            aitsu.atacar(agujaAsesina);

        }catch(MonstruoNoSeEncuentraEnArenaDeJuegoError e){

            lanzoError = true;

        }

        assertFalse(lanzoError);

    }
    */
}