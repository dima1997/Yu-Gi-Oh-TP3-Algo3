import junit.framework.TestCase;

public class EfectoWastelandDefensaTest extends TestCase {
    public void testEfectoWastelandDefensaAumentaLaDefensaDeUnMonstruoEnTresCientos(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);

        Monstruo goblinFalso = new Monstruo(400, 400, 1);
        Monstruo mokeyMokey = new Monstruo(300,100,3);
        Monstruo mokeyMokeyConUnPuntoMasEnDefensa = new Monstruo(300,101,3);

        goblinFalso.colocarEnPosAtaque();
        mokeyMokey.colocarEnPosDefensa();
        mokeyMokeyConUnPuntoMasEnDefensa.colocarEnPosDefensa();

        EfectoSobreMonstruo efectoWastelandDefensa = new EfectoWastelandDefensa();
        efectoWastelandDefensa.activar(mokeyMokey);
        efectoWastelandDefensa.activar(mokeyMokeyConUnPuntoMasEnDefensa);

        Botin unBotin = goblinFalso.atacar(mokeyMokey);
        unBotin.ejecutar(unCampo);
        unBotin = goblinFalso.atacar(mokeyMokeyConUnPuntoMasEnDefensa);
        unBotin.ejecutar(unCampo);

        assertTrue(unCementerio.esta(mokeyMokey));
        assertFalse(unCementerio.esta(mokeyMokeyConUnPuntoMasEnDefensa));
    }

    public void testEfectoWastelandDefensaDesactivarReduceLaDefensaDeUnMonstruoEnTresCientos(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Monstruo goblinFalso = new Monstruo(400, 400, 1);
        Monstruo mokeyMokeyConUnPuntoMasEnDefensa = new Monstruo(300,101,3);

        goblinFalso.colocarEnPosAtaque();

        mokeyMokeyConUnPuntoMasEnDefensa.colocarEnPosDefensa();

        EfectoSobreMonstruo efectoWastelandDefensa = new EfectoWastelandDefensa();

        efectoWastelandDefensa.activar(mokeyMokeyConUnPuntoMasEnDefensa);
        efectoWastelandDefensa.desactivar(mokeyMokeyConUnPuntoMasEnDefensa);

        Botin unBotin = goblinFalso.atacar(mokeyMokeyConUnPuntoMasEnDefensa);
        unBotin.ejecutar(unCampo);

        assertTrue(unCementerio.esta(mokeyMokeyConUnPuntoMasEnDefensa));
    }
}
