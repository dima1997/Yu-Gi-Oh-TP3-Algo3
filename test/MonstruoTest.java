import junit.framework.TestCase;

public class MonstruoTest extends TestCase {

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYAitsuMuere(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(c);

        assertTrue(c.esta(aitsu));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAlasDeLaLlamaPerversaEnAtaqueYAlasDeLaLlamaPerversaMuere(){

        Monstruo alasDeLlamaPerversa = new Monstruo(700, 600, 2);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        alasDeLlamaPerversa.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(alasDeLlamaPerversa);
        b.ejecutar(c);

        assertTrue(c.esta(alasDeLlamaPerversa));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnAtaqueYMuerenAmbos(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(c);

        assertTrue(c.esta(agresorOscuro));
        assertTrue(c.esta(agujaAsesina));
    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnDefensaYAitsuMuere(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(c);

        assertTrue(c.esta(aitsu));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYMuerenAmbos(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(c);

        assertTrue(c.esta(agresorOscuro));
        assertTrue(c.esta(agujaAsesina));
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

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYElBotinQuita1100DeVidaAlAtacado(){

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

/*    public void testMonstruoDormidoDanioContraOtroMonstruoEnPosAtaqueLevantaError(){
        Monstruo m1 = new Monstruo(1,1,1);
        Monstruo m2 = new Monstruo(1,1,1);

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
        Monstruo m1 = new Monstruo(1,1,1);
        Monstruo m2 = new Monstruo(1,1,1);

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

        Monstruo m1 = new Monstruo(10,1,1);
        Monstruo m2 = new Monstruo(20,1,1);
        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertEquals(m1.danioContra(m2), 0);

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosAtaqueConMenorAtaqueDevuelveLaDiferenciaDeAtaques(){
        int ataqueGrande = 20;
        int ataqueChico = 10;
        Monstruo m1 = new Monstruo(ataqueGrande,1,1);
        Monstruo m2 = new Monstruo(ataqueChico,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        int danioEsperado = ataqueGrande - ataqueChico;

        assertEquals(danioEsperado , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosAtaqueConIgualAtaqueDevuelveCero(){
        int mismoAtaque = 10;

        Monstruo m1 = new Monstruo(mismoAtaque,1,1);
        Monstruo m2 = new Monstruo(mismoAtaque,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosDefensaConMenorDefensaQueSuAtaqueDevuelveCero(){

        Monstruo m1 = new Monstruo(10,1,1);
        Monstruo m2 = new Monstruo(10,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosDefensaConMayorDefensaQueSuAtaqueDevuelveCero(){

        Monstruo m1 = new Monstruo(10,1,1);
        Monstruo m2 = new Monstruo(10,20,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueDanioContraOtroMonstruoEnPosDefensaConMismaDefensaQueSuAtaqueDevuelveCero(){

        Monstruo m1 = new Monstruo(10,1,1);
        Monstruo m2 = new Monstruo(1,10,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        assertEquals(0 , m1.danioContra(m2));

    }

    public void testMonstruoEnPosAtaqueEsDestruidoPorOtroMonstruoPosAtaqueConMayorAtaqueEsTrue(){
        int ataqueGrande = 20;
        int ataqueChico = 10;
        Monstruo m1 = new Monstruo(ataqueChico,1,1);
        Monstruo m2 = new Monstruo(ataqueGrande,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosAtaqueEsDestruidoPorOtroMonstruoPosAtaqueConMismoAtaqueEsTrue(){
        int mismoAtaque = 10;
        Monstruo m1 = new Monstruo(mismoAtaque,1,1);
        Monstruo m2 = new Monstruo(mismoAtaque,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosAtaqueEsDestruidoPorOtroMonstruoEnPosAtaqueConMenorAtaqueEsFalse(){
        int ataqueGrande = 20;
        int ataqueChico = 10;

        Monstruo m1 = new Monstruo(ataqueGrande,1,1);
        Monstruo m2 = new Monstruo(ataqueChico,1,1);

        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        assertFalse(m1.esDestruidoPor(m2));
    }
    public void testMonstruoEnPosDefensaEsDestruidoPorOtroMonstruoPosAtaqueConMayorAtaqueQueMiDefensaEsTrue(){
        Monstruo m1 = new Monstruo(1,10,1);
        Monstruo m2 = new Monstruo(20,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosDefensaEsDestruidoPorOtroMonstruoPosAtaqueConIgualAtaqueQueMiDefensaEsTrue(){
        Monstruo m1 = new Monstruo(1,10,1);
        Monstruo m2 = new Monstruo(10,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        assertTrue(m1.esDestruidoPor(m2));
    }

    public void testMonstruoEnPosDefensaEsDestruidoPorOtroMonstruoPosAtaqueConMenorAtaqueQueMiDefensaEsFalse(){
        Monstruo m1 = new Monstruo(1,20,1);
        Monstruo m2 = new Monstruo(10,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        assertFalse(m1.esDestruidoPor(m2));
    }*/


}
