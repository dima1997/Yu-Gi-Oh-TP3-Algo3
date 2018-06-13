import junit.framework.TestCase;

public class MonstruoTest extends TestCase {

    public void testMonstruoAtacarLanzaExcepcionConMonstruoRecienCreado(){

        Monstruo m1 = new Monstruo();
        Monstruo m2 = new Monstruo();

        boolean lanzoError = false;

        try{

            m1.atacar(m2);

        }catch (MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }

    public void testMonstruoAtacarNoLanzaExcepcionSiAmbosEstanEnPosAtaque(){

        Monstruo m1 = new Monstruo();
        Monstruo m2 = new Monstruo();
        m1.colocarEnPosAtaque();
        m2.colocarEnPosAtaque();

        boolean lanzoError = false;

        try{

            m1.atacar(m2);

        }catch (MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertFalse(lanzoError);

    }

    public void testMonstruoAtacarLanzaExcepcionConMonstruoEnPosDefensa(){

        Monstruo m1 = new Monstruo();
        Monstruo m2 = new Monstruo();
        m1.colocarEnPosDefensa();
        m2.colocarEnPosDefensa();

        boolean lanzoError = false;

        try{

            m1.atacar(m2);

        }catch (MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }

    public void testMonstruoEnPosAtaqueAtacarNoLanzaExcepcionConMonstruoEnPosDefensa(){

        Monstruo m1 = new Monstruo();
        Monstruo m2 = new Monstruo();
        m1.colocarEnPosAtaque();
        m2.colocarEnPosDefensa();

        boolean lanzoError = false;

        try{

            m1.atacar(m2);

        }catch (MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertFalse(lanzoError);

    }

    public void testMonstruoAtacarAMonstruoDormidoLanzaExcepcion(){

        Monstruo m1 = new Monstruo();
        Monstruo m2 = new Monstruo();
        m1.colocarEnPosAtaque();

        boolean lanzoError = false;

        try{

            m1.atacar(m2);

        }catch (MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }


}
