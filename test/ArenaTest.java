import junit.framework.TestCase;

public class ArenaTest extends TestCase {
    public void testArenaContieneEsTrueCuandoLaCartaRecibaFueColocadaEnLaArena(){
        Arena unaArena = new Arena();
        Carta unaCarta = new Magica();

        unaArena.colocarCarta(unaCarta);

        assertTrue(unaArena.contiene(unaCarta));
    }

    public void testArenaContieneEsFalseCuandoLaCartaRecibaNoFueColocadaEnLaArena(){
        Arena unaArena = new Arena();
        Carta unaCarta = new Trampa();

        assertFalse(unaArena.contiene(unaCarta));
    }

    public void testArenaJugadorUnoAtacaConMonstruoAJugadorDosConMonstruoEnPosAtaqueYMenorAtaqueRecibiendoLaDiferenciaDeAtaqueEnDanioEsteUltimoYDestruyendoASuMonstruo(){
        Arena unaArena = new Arena();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaqueGrandes = 200;
        int puntosAtaqueChicos = 400;

        Monstruo monstruoUno = new Monstruo(puntosAtaqueGrandes,100,2);
        Monstruo monstruoDos = new Monstruo(puntosAtaqueChicos,200,3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosAtaque();
        
        unaArena.hacerCombatir(monstruoUno,jugadorUno,monstruoDos,jugadorDos);

        int vidaFinalJugadorDosEsperada = vidaInicial - (puntosAtaqueGrandes - puntosAtaqueChicos);

        assertFalse(unaArena.estaEnElCementerio(monstruoUno));

        assertTrue(unaArena.estaEnElCementerio(monstruoDos));
        assertFalse(unaArena.contiene(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaFinalJugadorDosEsperada , jugadorDos.verVida());
    }
    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosAtaqueYMayorAtaqueRecibiendoLaDiferenciaDeAtaqueEnDanioElPrimeroYDestruyendoSuMonstruo(){
        Arena unaArena = new Arena();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaqueGrandes = 200;
        int puntosAtaqueChicos = 400;

        Monstruo monstruoUno = new Monstruo(puntosAtaqueChicos,100,2);
        Monstruo monstruoDos = new Monstruo(puntosAtaqueGrandes,200,3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosAtaque();
        
        unaArena.hacerCombatir(monstruoUno,jugadorUno,monstruoDos,jugadorDos);

        int vidaFinalJugadorUnoEsperada = vidaInicial - (puntosAtaqueGrandes - puntosAtaqueChicos);

        assertTrue(unaArena.estaEnElCementerio(monstruoUno));
        assertFalse(unaArena.contiene(monstruoUno));

        assertFalse(unaArena.estaEnElCementerio(monstruoDos));

        assertEquals(vidaFinalJugadorUnoEsperada , jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }
    
    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosAtaqueConMismoAtaqueSoloSeDestruyenLosMonstruos(){
        Arena unaArena = new Arena();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaque = 300;

        Monstruo monstruoUno = new Monstruo(puntosAtaque,100,2);
        Monstruo monstruoDos = new Monstruo(puntosAtaque,200,3);
        
        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosAtaque();

        unaArena.hacerCombatir(monstruoUno,jugadorUno,monstruoDos,jugadorDos);

        assertTrue(unaArena.estaEnElCementerio(monstruoUno));
        assertFalse(unaArena.contiene(monstruoUno));

        assertTrue(unaArena.estaEnElCementerio(monstruoDos));
        assertFalse(unaArena.contiene(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }

    public void testArenaJugadorUnoAtacaConMonstruoAJugadorDosConMonstruoEnPosDeDefensaYMenorDefensaQueSuAtaqueSoloDestruyeEsteUlitmoMonstruo(){
        Arena unaArena = new Arena();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaque = 400;
        int puntosDefensa = 200;

        Monstruo monstruoUno = new Monstruo(puntosAtaque,100,2);
        Monstruo monstruoDos = new Monstruo(100,puntosDefensa,3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosDefensa();

        unaArena.hacerCombatir(monstruoUno,jugadorUno,monstruoDos,jugadorDos);

        assertFalse(unaArena.estaEnElCementerio(monstruoUno));

        assertTrue(unaArena.estaEnElCementerio(monstruoDos));
        assertFalse(unaArena.contiene(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }
    public void testArenaHacerCombatirJugadorUnoConMonstruoYJugadorDosConMonstruoEnPosDeDefensaConDefensaMayorASuAtaqueNoAfectaEnNadaALosMonstruosYJugadores(){
        Arena unaArena = new Arena();
        int vidaInicial = 8000;
        Jugador jugadorUno = new Jugador("1", vidaInicial);
        Jugador jugadorDos = new Jugador("2", vidaInicial);

        int puntosAtaque = 200;
        int puntosDefensa = 400;

        Monstruo monstruoUno = new Monstruo(puntosAtaque,100,2);
        Monstruo monstruoDos = new Monstruo(100,puntosDefensa,3);

        monstruoUno.colocarEnPosAtaque();
        monstruoDos.colocarEnPosDefensa();

        unaArena.hacerCombatir(monstruoUno,jugadorUno,monstruoDos,jugadorDos);

        assertFalse(unaArena.estaEnElCementerio(monstruoUno));
        assertFalse(unaArena.estaEnElCementerio(monstruoDos));

        assertEquals(vidaInicial, jugadorUno.verVida());
        assertEquals(vidaInicial, jugadorDos.verVida());
    }
}
