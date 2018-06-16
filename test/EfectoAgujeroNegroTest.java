import junit.framework.TestCase;

public class EfectoAgujeroNegroTest extends TestCase {

    public void testActivarEfectoAgujeroNegroEnviaTodosLosMonstruosDeLosCamposDeAmbosJugadoresAlCementerio(){
        Cementerio unCementerio =  new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Monstruo m1 = new Monstruo(1, 1, 1);
        Monstruo m2 = new Monstruo(1,1,1);
        Monstruo m3 = new Monstruo(2,2,2);
        unCampo.colocarMonstruo(m1);
        unCampo.colocarMonstruo(m2);
        unCampo.colocarMonstruo(m3);

        EfectoSobreCampo efectoAgujeroNegro = new EfectoAgujeroNegro();

        efectoAgujeroNegro.activar(unCampo);

        assertFalse(unCampo.esta(m1));
        assertFalse(unCampo.esta(m2));
        assertFalse(unCampo.esta(m3));

        assertTrue(unCementerio.esta(m1));
        assertTrue(unCementerio.esta(m2));
        assertTrue(unCementerio.esta(m3));

    }

}