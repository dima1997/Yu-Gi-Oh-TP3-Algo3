import junit.framework.TestCase;

public class MonstruoTest extends TestCase {

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYAitsuMuere(){

        MonstruoComun aitsu = new MonstruoComun(100, 100, 5);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(c);

        assertTrue(c.esta(aitsu));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAlasDeLaLlamaPerversaEnAtaqueYAlasDeLaLlamaPerversaMuere(){

        MonstruoComun alasDeLlamaPerversa = new MonstruoComun(700, 600, 2);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Cementerio c = new Cementerio();
        alasDeLlamaPerversa.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(alasDeLlamaPerversa);
        b.ejecutar(c);

        assertTrue(c.esta(alasDeLlamaPerversa));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnAtaqueYMuerenAmbos(){

        MonstruoComun agresorOscuro = new MonstruoComun(1200, 1200, 4);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(c);

        assertTrue(c.esta(agresorOscuro));
        assertTrue(c.esta(agujaAsesina));
    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnDefensaYNingunoMuere(){

        MonstruoComun aitsu = new MonstruoComun(100, 100, 5);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(c);

        assertFalse(c.esta(aitsu));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYMuereAgresorOscuro(){

        MonstruoComun agresorOscuro = new MonstruoComun(1200, 1200, 4);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(c);

        assertTrue(c.esta(agresorOscuro));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYElBotinNoQuitaVida(){

        MonstruoComun agresorOscuro = new MonstruoComun(1200, 1200, 4);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Jugador atacante = new Jugador("", 1000);
        Jugador atacado = new Jugador("", 1000);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 1000);
        assertEquals(atacado.verVida(), 1000);

    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYElBotinQuita1100DeVidaAlAtacado(){

        MonstruoComun aitsu = new MonstruoComun(100, 100, 5);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000 - 1100);

    }

    public void testPeleaAitsuEnDefensaContraAgujaAsesinaEnAtaqueYElBotinNoQuitaVida(){

        MonstruoComun aitsu = new MonstruoComun(100, 100, 5);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
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

        MonstruoComun aitsu = new MonstruoComun(100, 100, 5);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
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

        MonstruoComun aitsu = new MonstruoComun(100, 100, 5);
        MonstruoComun agujaAsesina = new MonstruoComun(1200, 1000, 4);
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

    public void testInsectoComeHombresDestruyeUnMonstruoEnElCampoAlPosicionarloBocaArriba(){

        Cementerio cementerioOponente = new Cementerio();

        Campo campoOponente = new Campo(cementerioOponente);

        Efecto destruirMonstruo = new EfectoDestruirMonstruo(campoOponente);
        MonstruoComun insecto = new MonstruoComun(2,2,2, destruirMonstruo);
        Monstruo insectoComeHombres = new EfectoAlColocarBocaArriba(insecto);
        MonstruoComun mOponente = new MonstruoComun(2,2,2);

        campoOponente.colocarMonstruo(mOponente);
        mOponente.colocarEnPosAtaque();
        insectoComeHombres.colocarEnPosAtaque();

        assertTrue(cementerioOponente.esta(mOponente));


    }

/*    public void testMonstruoDormidoDanioContraOtroMonstruoEnPosAtaqueLevantaError(){
        MonstruoComun m1 = new MonstruoComun(1,1,1);
        MonstruoComun m2 = new MonstruoComun(1,1,1);

        m2.colocarEnPosAtaque();

        boolean lanzoError = false;

        try{

            m1.danioContra(m2);

        } catch (MonstruoNoSeEncuentraEnArenaDeJuegoError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }
    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoDormidaLevantaError(){
        MonstruoComun m1 = new MonstruoComun(1,1,1);
        MonstruoComun m2 = new MonstruoComun(1,1,1);

        m1.colocarEnPosAtaque();

        boolean lanzoError = false;

        try{

            m1.danioContra(m2);

        } catch (MonstruoNoSeEncuentraEnArenaDeJuegoError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }

    public void testMonstruoDeDanio10DanioContraMonstruoDeDanio20EnPosAtaqueDevuelve0(){

        MonstruoComun m1 = new MonstruoComun(10,1,1);
        MonstruoComun m2 = new MonstruoComun(20,1,1);
        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertEquals(m1.danioContra(m2), 0);

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosAtaqueConMenorAtaqueDevuelveLaDiferenciaDeAtaques(){
        int ataqueGrande = 20;
        int ataqueChico = 10;
        MonstruoComun m1 = new MonstruoComun(ataqueGrande,1,1);
        MonstruoComun m2 = new MonstruoComun(ataqueChico,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        int danioEsperado = ataqueGrande - ataqueChico;

        assertEquals(danioEsperado , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosAtaqueConIgualAtaqueDevuelveCero(){
        int mismoAtaque = 10;

        MonstruoComun m1 = new MonstruoComun(mismoAtaque,1,1);
        MonstruoComun m2 = new MonstruoComun(mismoAtaque,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosDefensaConMenorDefensaQueSuAtaqueDevuelveCero(){

        MonstruoComun m1 = new MonstruoComun(10,1,1);
        MonstruoComun m2 = new MonstruoComun(10,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosDefensaConMayorDefensaQueSuAtaqueDevuelveCero(){

        MonstruoComun m1 = new MonstruoComun(10,1,1);
        MonstruoComun m2 = new MonstruoComun(10,20,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosDefensaConMismaDefensaQueSuAtaqueDevuelveCero(){

        MonstruoComun m1 = new MonstruoComun(10,1,1);
        MonstruoComun m2 = new MonstruoComun(1,10,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueEsDestruidoPorOtroMonstruoPosAtaqueConMayorAtaqueEsTrue(){
        int ataqueGrande = 20;
        int ataqueChico = 10;
        MonstruoComun m1 = new MonstruoComun(ataqueChico,1,1);
        MonstruoComun m2 = new MonstruoComun(ataqueGrande,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosAtaqueEsDestruidoPorOtroMonstruoPosAtaqueConMismoAtaqueEsTrue(){
        int mismoAtaque = 10;
        MonstruoComun m1 = new MonstruoComun(mismoAtaque,1,1);
        MonstruoComun m2 = new MonstruoComun(mismoAtaque,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosAtaqueEsDestruidoPorOtroMonstruoEnPosAtaqueConMenorAtaqueEsFalse(){
        int ataqueGrande = 20;
        int ataqueChico = 10;

        MonstruoComun m1 = new MonstruoComun(ataqueGrande,1,1);
        MonstruoComun m2 = new MonstruoComun(ataqueChico,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertFalse(m1.esDestruidoPor(m2));
    }
    public void testMonstruoEnPosDefensaEsDestruidoPorOtroMonstruoPosAtaqueConMayorAtaqueQueMiDefensaEsTrue(){
        MonstruoComun m1 = new MonstruoComun(1,10,1);
        MonstruoComun m2 = new MonstruoComun(20,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosDefensaEsDestruidoPorOtroMonstruoPosAtaqueConIgualAtaqueQueMiDefensaEsTrue(){
        MonstruoComun m1 = new MonstruoComun(1,10,1);
        MonstruoComun m2 = new MonstruoComun(10,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosDefensaEsDestruidoPorOtroMonstruoPosAtaqueConMenorAtaqueQueMiDefensaEsFalse(){
        MonstruoComun m1 = new MonstruoComun(1,20,1);
        MonstruoComun m2 = new MonstruoComun(10,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        assertFalse(m1.esDestruidoPor(m2));
    }*/


}
