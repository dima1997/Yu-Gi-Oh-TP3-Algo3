import junit.framework.TestCase;

public class EfectoWastelandTest extends TestCase {
    public void testEfectoWastelandAumentaEnDoscientosElAtaqueDeMisMonstruosYAumentaEnTrescientosLaDefensaDeLosMonstruosDelOponente(){
        Campo campoPropio = new Campo(new Cementerio());
        Campo campoOponente = new Campo(new Cementerio());

        Efecto efectoWaste = new EfectoWasteland(campoPropio, campoOponente);

        Monstruo mPropio = new Monstruo(400,100,3);
        Monstruo mOponenete = new Monstruo(100,100,3);

        campoPropio.colocarMonstruo(mPropio);
        campoOponente.colocarMonstruo(mOponenete);

        mPropio.colocarEnPosAtaque();

        //Inicial
        mOponenete.colocarEnPosAtaque();
        int danioContraSuAtaque = mPropio.danioContra(mOponenete);
        assertEquals(300, danioContraSuAtaque);

        mOponenete.colocarEnPosDefensa();
        int defensaOponente = mOponenete.obtenerDefensa();
        assertEquals(100, defensaOponente);

        efectoWaste.activar();

        //Final
        mOponenete.colocarEnPosAtaque();
        danioContraSuAtaque = mPropio.danioContra(mOponenete);
        //El ataque de mis monstruos aumenta en 200
        assertEquals(500, danioContraSuAtaque);

        mOponenete.colocarEnPosDefensa();
        defensaOponente = mOponenete.obtenerDefensa();
        //La defensa de los monstruos del oponente aumenta en 300
        assertEquals(400, defensaOponente);


    }
}
