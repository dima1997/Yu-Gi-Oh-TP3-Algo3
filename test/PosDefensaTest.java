import junit.framework.TestCase;

public class PosDefensaTest extends TestCase {

    public void testPosDefensaAtaqueDevuelve0SinImportarElMonstruo(){

        Monstruo m1 = new Monstruo(1,1,1);
        PosDefensa d = new PosDefensa(m1);

        assertEquals(d.obtenerAtaque(), 0);

    }

    public void testPosDefensaDefensaDevuelveLosPuntosDeDefensaDelMosntruo(){

        Monstruo m1 = new Monstruo(1,20,1);
        PosDefensa d = new PosDefensa(m1);

        assertEquals(d.obtenerDefensa(), 20);

    }

    public void testPosDefensaRecibirAtaqueDevuelve0SinImportarLaPosicionContraria(){

        Monstruo m1 = new Monstruo(1,20,1);
        PosDefensa d1 = new PosDefensa(m1);
        PosDefensa d2 = new PosDefensa(m1);

        assertEquals(d1.recibirAtaque(d2), 0);

    }

}