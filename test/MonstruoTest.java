import junit.framework.TestCase;

public class MonstruoTest extends TestCase {
    public void testMonstruoDormidoDanioContraOtroMonstruoEnPosAtaqueLevantaError(){
        Monstruo m1 = new Monstruo(1,1,1);
        Monstruo m2 = new Monstruo(1,1,1);

        m2.colocarEnPosAtaque();

        boolean lanzoError = false;

        try{

            m1.danioContra(m2);

        } catch (MonstruoNoPuedeAtacarError e){

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

        } catch (MonstruoNoPuedeAtacarError e){

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
    }
}
