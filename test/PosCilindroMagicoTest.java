import junit.framework.TestCase;

public class PosCilindroMagicoTest extends TestCase {
    public void testPosCilindroMagicoAtacarAgujaAsesinaContraAitsuYNingunoMuere(){
        PosicionStrategy posicionAtacante = new PosCilindroMagico();
        PosicionStrategy posicionAtacada = new PosAtaque();
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        Campo unCampo = new Campo(c);
        unCampo.colocarMonstruo(aitsu);
        unCampo.colocarMonstruo(agujaAsesina);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada, aitsu, agujaAsesina);
        b.ejecutar(unCampo);

        assertFalse(c.esta(aitsu));
        assertFalse(c.esta(agujaAsesina));
    }
    public void testPosCilindroMagicoAtacarPosAtaqueAgujaAsesinaContraAgresoroscuroYElJugadorAtacanteRecibeElAtaqueCompletoDeAgujaAsesina(){
        PosicionStrategy posicionAtacante = new PosCilindroMagico();
        PosicionStrategy posicionAtacada = new PosDefensa();
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 2000);
        Jugador atacado = new Jugador("", 2000);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = posicionAtacante.atacar(posicionAtacada,agujaAsesina,agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 2000-1200);
        assertEquals(atacado.verVida(), 2000);
    }
}
