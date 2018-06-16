import junit.framework.TestCase;

public class EfectoWastelandTest extends TestCase {
    public void testEfectoWastelandAumentaEnDoscientosElAtaqueDeMisMonstruosYAumentaEnTrescientosLaDefensaDeLosMonstruosDelOponente(){

        Campo campoPropio = new Campo(new Cementerio());
        Campo campoOponente = new Campo(new Cementerio());

        Efecto efectoWaste = new EfectoWasteland(campoPropio, campoOponente);

        Monstruo mPropio = new Monstruo(400,100,3);
        Monstruo mOponenete = new Monstruo(10,100,3);

        campoPropio.colocarMonstruo(mPropio);
        campoOponente.colocarMonstruo(mOponenete);

        mPropio.colocarEnPosAtaque();
        mOponenete.colocarEnPosDefensa();

        efectoWaste.activar();

        assertEquals(mPropio.obtenerPuntos(), 600);
        assertEquals(mOponenete.obtenerPuntos(), 400);


    }
}
