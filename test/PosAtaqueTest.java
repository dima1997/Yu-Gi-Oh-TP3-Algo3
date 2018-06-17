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

        Botin b = posicionAtacante.atacar(posicionAtacada, aitsu, agujaAsesina);
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

        Botin b = posicionAtacante.atacar(posicionAtacada, agujaAsesina, alasDeLlamaPerversa);
        b.ejecutar(unCampo);

        assertTrue(c.esta(alasDeLlamaPerversa));
    }

    public void testPosAtaqueAtacarPosAtaqueAgujaAsesinaContraAgresorOscuroYMuerenAmbos(){
        PosAtaque posicionAtacante = new PosAtaque();
        PosAtaque posicionAtacada = new PosAtaque();
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(agresorOscuro);
        unCampo.colocarMonstruo(agujaAsesina);
        agresorOscuro.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada, agujaAsesina, agresorOscuro);
        b.ejecutar(unCampo);

        assertTrue(c.esta(agresorOscuro));
        assertTrue(c.esta(agujaAsesina));
    }

    public void testPosAtaqueAtacarPosDefensaAitsuContraAgujaAsesinaYNingunoMuere(){
        PosicionStrategy posicionAtacante = new PosAtaque();
        PosicionStrategy posicionAtacada = new PosDefensa();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(aitsu);
        unCampo.colocarMonstruo(agujaAsesina);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        Botin b = posicionAtacante.atacar(posicionAtacada,aitsu,agujaAsesina);
        b.ejecutar(unCampo);

        assertFalse(c.esta(aitsu));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPosAtaqueAtacarPosDefensaAgujaAsesinaContraAgresorOscuroYMuereAgresorOscuro(){
        PosicionStrategy posicionAtacante = new PosAtaque();
        PosicionStrategy posicionAtacada = new PosDefensa();
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(agresorOscuro);
        unCampo.colocarMonstruo(agujaAsesina);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada,agujaAsesina,agresorOscuro);
        b.ejecutar(unCampo);

        assertTrue(c.esta(agresorOscuro));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPosAtaqueAtacarPosDefensaAgujaAsesinaContraAgresorOscuroYElBotinNoQuitaVida(){
        PosicionStrategy posicionAtacante = new PosAtaque();
        PosicionStrategy posicionAtacada = new PosDefensa();
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 1000);
        Jugador atacado = new Jugador("", 1000);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada,agujaAsesina,agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 1000);
        assertEquals(atacado.verVida(), 1000);

    }

    public void testPosAtaqueAtacarPosAtaqueAgujaAsesinaContraAitsuYElBotinQuita1100DeVidaAlAtacado(){
        PosicionStrategy posicionAtacante = new PosAtaque();
        PosicionStrategy posicionAtacada = new PosAtaque();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada,agujaAsesina,aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000 - 1100);

    }

    public void testPosAtaqueAtacarPosAtaqueAitsuContraYElBotinQuita1100DeVidaAlAtacante(){
        PosicionStrategy posicionAtacante = new PosAtaque();
        PosicionStrategy posicionAtacada = new PosAtaque();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada,aitsu,agujaAsesina);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000 - 1100);
        assertEquals(atacado.verVida(), 10000);

    }


    public void testPosAtaqueAtacarPosDefensaAgujaAsesinaContraAitsuYElBotinNoQuitaVida(){
        PosicionStrategy posicionAtacante = new PosAtaque();
        PosicionStrategy posicionAtacada = new PosDefensa();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada,agujaAsesina,aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000);

    }

}