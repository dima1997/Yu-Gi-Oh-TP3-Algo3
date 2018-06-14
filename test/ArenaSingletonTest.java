import junit.framework.TestCase;

public class ArenaSingletonTest extends TestCase {

    public void testArenaContieneEsTrueCuandoLaCartaRecibaFueColocadaEnLaArena() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();

        Carta unaCarta = new Magica(new EfectoNulo());
        Monstruo otraCarta = new Monstruo(1, 1, 1);

        unaArena.colocarMonstruo(otraCarta);
        unaArena.colocarTrampaMagica(unaCarta);

        assertTrue(unaArena.contiene(unaCarta));
        assertTrue(unaArena.contiene(otraCarta));
        ArenaSingleton.reiniciar();
    }

    public void testArenaContieneEsFalseCuandoLaCartaRecibaNoFueColocadaEnLaArena() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Carta unaCarta = new Trampa();
        Monstruo otraCarta = new Monstruo(1, 1, 1);

        assertFalse(unaArena.contiene(unaCarta));
        assertFalse(unaArena.contiene(otraCarta));
        ArenaSingleton.reiniciar();
    }

    public void testArenaJugadorUnoAtacaConMonstruoAJugadorDosConMonstruoEnPosAtaqueYMenorAtaqueRecibiendoLaDiferenciaDeAtaqueEnDanioEsteUltimoYDestruyendoASuMonstruo() {
        ArenaSingleton.reiniciar();
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
        ArenaSingleton.reiniciar();
    }

    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosAtaqueYMayorAtaqueRecibiendoLaDiferenciaDeAtaqueEnDanioElPrimeroYDestruyendoSuMonstruo() {
        ArenaSingleton.reiniciar();
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
        ArenaSingleton.reiniciar();
    }

    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosAtaqueConMismoAtaqueSoloSeDestruyenLosMonstruos() {
        ArenaSingleton.reiniciar();
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
        ArenaSingleton.reiniciar();
    }

    public void testArenaJugadorUnoAtacaConMonstruoAJugadorDosConMonstruoEnPosDeDefensaYMenorDefensaQueSuAtaqueSoloDestruyeEsteUlitmoMonstruo() {
        ArenaSingleton.reiniciar();
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
        ArenaSingleton.reiniciar();
    }

    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosDeDefensaConDefensaMayorASuAtaqueNoAfectaEnNadaALosMonstruosYJugadores() {
        ArenaSingleton.reiniciar();
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
        ArenaSingleton.reiniciar();
    }


    public void testArenaDestruirTodasDestruyetodasLaCartasPreviamenteColocadas() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();

        Monstruo m1 = new Monstruo(1, 1, 1);
        Monstruo m2 = new Monstruo(1, 1, 1);

        m1.colocarEnPosDefensa();
        m2.colocarEnPosAtaque();

        unaArena.colocarMonstruo(m1);
        unaArena.colocarMonstruo(m2);

        unaArena.destruirTodas();

        assertFalse(unaArena.contiene(m1));
        assertFalse(unaArena.contiene(m2));
        assertTrue(unaArena.estaEnElCementerio(m1));
        assertTrue(unaArena.estaEnElCementerio(m2));
        ArenaSingleton.reiniciar();
    }

    public void testArenaSacrificarUnaDestruyeUnMonstruo() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Monstruo m1 = new Monstruo(1, 1, 1);

        unaArena.colocarMonstruo(m1);
        unaArena.sacrificar(1);

        assertTrue(unaArena.estaEnElCementerio(m1));
        ArenaSingleton.reiniciar();
    }

    public void testArenaSacrificarDosDestruyeDosMonstruos() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Monstruo m1 = new Monstruo(1, 1, 1);
        Monstruo m2 = new Monstruo(1, 1, 1);

        unaArena.colocarMonstruo(m1);
        unaArena.colocarMonstruo(m2);
        unaArena.sacrificar(2);

        assertTrue(unaArena.estaEnElCementerio(m1));
        assertTrue(unaArena.estaEnElCementerio(m2));
        ArenaSingleton.reiniciar();
    }

    public void testArenaColocarMonstruoDe5EstrellasSacrificaUnsMonstruoDelTablero() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Monstruo m1 = new Monstruo(1, 1, 1);
        Monstruo m2 = new Monstruo(1, 1, 5);

        unaArena.colocarMonstruo(m1);
        unaArena.colocarMonstruo(m2);

        assertTrue(unaArena.estaEnElCementerio(m1));
        ArenaSingleton.reiniciar();
    }

    public void testArenaColocarMonstruoDe7EstrellasSacrificaDosMonstruosDelTablero() {
        ArenaSingleton.reiniciar();
        ArenaSingleton unaArena = ArenaSingleton.getInstance();
        Monstruo m1 = new Monstruo(1, 1, 1);
        Monstruo m2 = new Monstruo(1, 1, 1);
        Monstruo m3 = new Monstruo(1, 1, 7);

        unaArena.colocarMonstruo(m1);
        unaArena.colocarMonstruo(m2);
        unaArena.colocarMonstruo(m3);

        assertTrue(unaArena.estaEnElCementerio(m1));
        assertTrue(unaArena.estaEnElCementerio(m2));
        ArenaSingleton.reiniciar();
    }
}
