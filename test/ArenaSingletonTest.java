import junit.framework.TestCase;

public class ArenaSingletonTest extends TestCase {

    public void testArenaContieneEsTrueCuandoLaCartaRecibaFueColocadaEnLaArena() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Carta unaCarta = new Magica(new EfectoNulo());

        unaArena.colocarCarta(unaCarta);

        assertTrue(unaArena.contiene(unaCarta));
    }

    public void testArenaContieneEsFalseCuandoLaCartaRecibaNoFueColocadaEnLaArena() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Carta unaCarta = new Trampa();

        assertFalse(unaArena.contiene(unaCarta));
    }

    public void testArenaJugadorUnoAtacaConMonstruoAJugadorDosConMonstruoEnPosAtaqueYMenorAtaqueRecibiendoLaDiferenciaDeAtaqueEnDanioEsteUltimoYDestruyendoASuMonstruo() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaqueGrandes = 400;
        int puntosAtaqueChicos = 200;

        Monstruo monstruoUno = new Monstruo(puntosAtaqueGrandes, 100, 2);
        Monstruo monstruoDos = new Monstruo(puntosAtaqueChicos, 100, 3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosAtaque();

        unaArena.hacerCombatir(jugadorUno, monstruoUno, jugadorDos, monstruoDos);

        int vidaFinalJugadorDosEsperada = vidaInicial - (puntosAtaqueGrandes - puntosAtaqueChicos);

        assertFalse(unaArena.estaEnElCementerio(monstruoUno));

        assertTrue(unaArena.estaEnElCementerio(monstruoDos));
        assertFalse(unaArena.contiene(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaFinalJugadorDosEsperada, jugadorDos.verVida());
    }

    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosAtaqueYMayorAtaqueRecibiendoLaDiferenciaDeAtaqueEnDanioElPrimeroYDestruyendoSuMonstruo() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaqueGrandes = 400;
        int puntosAtaqueChicos = 200;

        Monstruo monstruoUno = new Monstruo(puntosAtaqueChicos, 100, 2);
        Monstruo monstruoDos = new Monstruo(puntosAtaqueGrandes, 200, 3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosAtaque();

        unaArena.hacerCombatir(jugadorUno, monstruoUno, jugadorDos, monstruoDos);

        int vidaFinalJugadorUnoEsperada = vidaInicial - (puntosAtaqueGrandes - puntosAtaqueChicos);

        assertTrue(unaArena.estaEnElCementerio(monstruoUno));
        assertFalse(unaArena.contiene(monstruoUno));

        assertFalse(unaArena.estaEnElCementerio(monstruoDos));

        assertEquals(vidaFinalJugadorUnoEsperada, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }

    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosAtaqueConMismoAtaqueSoloSeDestruyenLosMonstruos() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaque = 300;

        Monstruo monstruoUno = new Monstruo(puntosAtaque, 100, 2);
        Monstruo monstruoDos = new Monstruo(puntosAtaque, 200, 3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosAtaque();

        unaArena.hacerCombatir(jugadorUno, monstruoUno, jugadorDos, monstruoDos);

        assertTrue(unaArena.estaEnElCementerio(monstruoUno));
        assertFalse(unaArena.contiene(monstruoUno));

        assertTrue(unaArena.estaEnElCementerio(monstruoDos));
        assertFalse(unaArena.contiene(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }

    public void testArenaJugadorUnoAtacaConMonstruoAJugadorDosConMonstruoEnPosDeDefensaYMenorDefensaQueSuAtaqueSoloDestruyeEsteUlitmoMonstruo() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaque = 400;
        int puntosDefensa = 200;

        Monstruo monstruoUno = new Monstruo(puntosAtaque, 100, 2);
        Monstruo monstruoDos = new Monstruo(100, puntosDefensa, 3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosDefensa();

        unaArena.hacerCombatir(jugadorUno, monstruoUno, jugadorDos, monstruoDos);

        assertFalse(unaArena.estaEnElCementerio(monstruoUno));

        assertTrue(unaArena.estaEnElCementerio(monstruoDos));
        assertFalse(unaArena.contiene(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }

    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosDeDefensaConDefensaMayorASuAtaqueNoAfectaEnNadaALosMonstruosYJugadores() {
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaque = 200;
        int puntosDefensa = 400;

        Monstruo monstruoUno = new Monstruo(puntosAtaque, 100, 2);
        Monstruo monstruoDos = new Monstruo(100, puntosDefensa, 3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosDefensa();

        unaArena.hacerCombatir(jugadorUno, monstruoUno, jugadorDos, monstruoDos);

        assertFalse(unaArena.estaEnElCementerio(monstruoUno));
        assertFalse(unaArena.estaEnElCementerio(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }


    public void testArenaDestruirTodasDestruyetodasLaCartasPreviamenteColocadas(){
        ArenaSingleton unaArena = ArenaSingleton.getInstance();

        Monstruo m1 = new Monstruo(1,1,1);
        Monstruo m2 = new Monstruo(1,1,1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        unaArena.colocarCarta(m1);
        unaArena.colocarCarta(m2);

        unaArena.destruirTodas();

        assertFalse(unaArena.contiene(m1));
        assertFalse(unaArena.contiene(m2));
        assertTrue(unaArena.estaEnElCementerio(m1));
        assertTrue(unaArena.estaEnElCementerio(m2));

    }

}
