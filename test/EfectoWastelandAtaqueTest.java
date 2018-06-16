import junit.framework.TestCase;

public class EfectoWastelandAtaqueTest extends TestCase {
    public void testEfectoWastelandAtaqueActivarAumentaElAtaqueDeUnMonstruoEnDoscientos(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo mokeyMokey = new Monstruo(300,100,3);
        unCampo.colocarMonstruo(aitsu);
        unCampo.colocarMonstruo(mokeyMokey);
        aitsu.colocarEnPosAtaque();
        mokeyMokey.colocarEnPosAtaque();

        EfectoSobreMonstruo efectoWastelandAtaque = new EfectoWastelandAtaque();
        efectoWastelandAtaque.activar(aitsu);

        Botin unBotin = aitsu.atacar(mokeyMokey);
        unBotin.ejecutar(unCampo);

        assertTrue(unCementerio.esta(aitsu));
        assertTrue(unCementerio.esta(mokeyMokey));

    }

    public void testEfectoWastelandAtaqueDesactivarDisminuyeElAtaqueDeUnMonstruoEnDoscientos(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo mokeyMokey = new Monstruo(300,100,3);
        unCampo.colocarMonstruo(aitsu);
        unCampo.colocarMonstruo(mokeyMokey);
        aitsu.colocarEnPosAtaque();
        mokeyMokey.colocarEnPosAtaque();

        EfectoSobreMonstruo efectoWastelandAtaque = new EfectoWastelandAtaque();
        efectoWastelandAtaque.activar(aitsu);
        efectoWastelandAtaque.desactivar(aitsu);

        Botin unBotin = aitsu.atacar(mokeyMokey);
        unBotin.ejecutar(unCampo);

        assertTrue(unCementerio.esta(aitsu));
        assertFalse(unCementerio.esta(mokeyMokey));

    }
}
