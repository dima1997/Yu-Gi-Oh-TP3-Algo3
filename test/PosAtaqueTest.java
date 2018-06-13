import junit.framework.TestCase;

public class PosAtaqueTest extends TestCase {

    public void testPosAtaqueObtenerAtaqueDevuelveElAtaqueDelMonstruo(){

        Monstruo m1 = new Monstruo(100,1,1);
        PosAtaque d = new PosAtaque(m1);

        assertEquals(d.obtenerAtaque(), 100);

    }

    public void testPosAtaqueObtenerDefensaDevuelveElAtaqueDelMonstruo(){

        Monstruo m1 = new Monstruo(10,1,1);
        PosAtaque d = new PosAtaque(m1);

        assertEquals(d.obtenerDefensa(), 10);

    }

    public void testPosAtaqueRecibirAtaqueDevuelve0SiTieneMenorAtaque(){

        Monstruo m1 = new Monstruo(100,1,1);
        PosAtaque d1 = new PosAtaque(m1);
        Monstruo m2 = new Monstruo(10,1,1);
        PosAtaque d2 = new PosAtaque(m2);

        assertEquals(d1.recibirAtaque(d2), 0);

    }

    public void testPosAtaqueDe100ContraPosAtaqueDe10Devuelve90(){

        Monstruo m1 = new Monstruo(10,1,1);
        PosAtaque d1 = new PosAtaque(m1);
        Monstruo m2 = new Monstruo(100,1,1);
        PosAtaque d2 = new PosAtaque(m2);

        assertEquals(d1.recibirAtaque(d2), 90);

    }

}