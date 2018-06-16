import junit.framework.TestCase;

public class TrampaCilindroMagicoTest extends TestCase {

    public void testActivarTrampaCilindroMagicoNiegaUnAtaqueYElOponenteRecibeDanioEnSusPuntosDeVida(){

        Jugador jugador = new Jugador("1", 2);
        Jugador oponente = new Jugador("2", 500);

        Cementerio cementerio = new Cementerio();

        Campo campo = new Campo(cementerio);

        Monstruo monstruo = new Monstruo(2,1,2);
        Monstruo monstruoOponente = new Monstruo(100, 1, 1);
        TrampaCilindroMagico cilindro = new TrampaCilindroMagico(jugador, oponente);

        monstruo.colocarEnPosAtaque();
        monstruoOponente.colocarEnPosAtaque();

        Botin botin = monstruoOponente.atacar(monstruo);
        cilindro.activar(botin, monstruoOponente, monstruo);
        botin.infligirDanios(oponente, jugador);
        botin.ejecutar(campo);

        assertEquals(oponente.verVida(), 400);

        assertFalse(cementerio.esta(monstruo));


    }


}
