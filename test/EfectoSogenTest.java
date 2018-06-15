import junit.framework.TestCase;

public class EfectoSogenTest extends TestCase {
    public void testEfectSogenAumentaEnQuinientosLaDefensaDeMisMonstruosYAumentaEnDoscientosElAtaqueDeLosMonstruosDelOponente(){
        Campo campoPropio = new Campo(new Cementerio());
        Campo campoOponente = new Campo(new Cementerio());

        Efecto efectoSogen = new EfectoSogen(campoPropio, campoOponente);

        Monstruo mPropio = new Monstruo(100,100,3);
        Monstruo mOponenete = new Monstruo(400,100,3);

        campoPropio.colocarMonstruo(mPropio);
        campoOponente.colocarMonstruo(mOponenete);

        mOponenete.colocarEnPosAtaque();

        //Inicial
        mPropio.colocarEnPosAtaque();
        int danioContraMiAtaque = mOponenete.danioContra(mPropio);
        assertEquals(300, danioContraMiAtaque);

        mPropio.colocarEnPosDefensa();
        int defensaPropia = mPropio.obtenerDefensa();
        assertEquals(100, defensaPropia);

        efectoSogen.activar();

        //Final
        mPropio.colocarEnPosAtaque();
        danioContraMiAtaque = mOponenete.danioContra(mPropio);
        //El ataque de los monstruos del oponente aumenta en 200
        assertEquals(500, danioContraMiAtaque);

        mPropio.colocarEnPosDefensa();
        defensaPropia = mPropio.obtenerDefensa();
        //La defensa de mis monstruos oponente aumenta en 500
        assertEquals(600, defensaPropia);


    }
}
