import junit.framework.TestCase;

public class CampoTest extends TestCase {
    public void testCampoEstaMokeyMokeyEsFalseCuandoCreoCampo(){
        Campo unCampo = new Campo(new Cementerio());
        Monstruo unMokey = new Monstruo(300,100,3);

        assertFalse(unCampo.esta(unMokey));
    }

    public void testCampoEstaMokeyMokeyEsTrueCuandoColocoMonstruoMokeyMokeyEnCampo(){
        Campo unCampo = new Campo(new Cementerio());
        Monstruo unMokey = new Monstruo(300,100,3);

        unCampo.colocarMonstruo(unMokey);

        assertTrue(unCampo.esta(unMokey));
    }

    public void testCampoDestruirMokeyMokeyEnviaMokeyMokeyAlCementerioDeCampoYYaNoEstaEnCampo(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Monstruo unMokey = new Monstruo(300,100,3);

        unCampo.colocarMonstruo(unMokey);

        //Mokey esta en el campo
        assertTrue(unCampo.esta(unMokey));

        unCampo.destruir(unMokey);

        //Mokey ya no esta en el campo
        assertFalse(unCampo.esta(unMokey));

        //Mokey esta en el Cementerio con que se inicio Campo
        assertTrue(unCementerio.esta(unMokey));
    }

    public void testCampoDestruirTodasEnviaTodasLaCartasColocadasAlCementerio(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Monstruo unMokey = new Monstruo(300,100,3);
        Monstruo otroMokey = new Monstruo(300,100,3);

        unCampo.colocarMonstruo(unMokey);
        unCampo.colocarMonstruo(otroMokey);

        unCampo.destruirTodas();

        assertFalse(unCampo.esta(unMokey));
        assertFalse(unCampo.esta(otroMokey));

        assertTrue(unCementerio.esta(unMokey));
        assertTrue(unCementerio.esta(otroMokey));
    }
    /*
    public void testCampoEstaMagicaEsTrueCuandoColocoMagicaBocaAbajo(){
        Campo unCampo = new Campo(new Cementerio());
        Magica unaCarta = new Magica(new EfectoNulo());

        unCampo.colocarMagicaBocaAbajo(unaCarta);

        assertTrue(unCampo.esta(unaCarta));
    }*/
}
