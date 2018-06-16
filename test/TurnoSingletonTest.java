import junit.framework.TestCase;

public class TurnoSingletonTest extends TestCase {
    public void testTurnoSingletonColocarMonstruoBocaArribaEnPosAtaqueMokeyMokeyColocaAlMokeyMokeyEnDichoEstadoEnElCampoDelJugadorDeTurno(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();

        Campo campoUno = new Campo();
        Jugador jugadorUno = new Jugador("1",8000, campoUno);
        Campo campoDos = new Campo();
        Jugador jugadorDos = new Jugador("2",8000, campoDos);
        unTurno.setJugadores(jugadorUno, jugadorDos);
        Monstruo mokeyMokey = new Monstruo(300,100,3);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);

        assertTrue(campoUno.esta(mokeyMokey));
        assertFalse(campoDos.esta(mokeyMokey));
        TurnoSingleton.reiniciar();
    }

    public void testTurnoSingletonSiguienteCambioElJugadorDeTurnoAJugadorOponenteYJugadorOponenteAJugadorDeTurno(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();

        Campo campoUno = new Campo();
        Jugador jugadorUno = new Jugador("1",8000, campoUno);
        Campo campoDos = new Campo();
        Jugador jugadorDos = new Jugador("2",8000, campoDos);
        unTurno.setJugadores(jugadorUno, jugadorDos);
        Monstruo mokeyMokey = new Monstruo(300,100,3);
        Monstruo aitsu = new Monstruo(100,100,5);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);
        unTurno.siguiente();

        //Testeo el Singleton
        TurnoSingleton mismoTurno = TurnoSingleton.getInstance();

        mismoTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);

        assertTrue(campoDos.esta(aitsu));
        assertFalse(campoUno.esta(aitsu));

        assertTrue(campoUno.esta(mokeyMokey));
        assertFalse(campoDos.esta(mokeyMokey));

        TurnoSingleton.reiniciar();
    }

    public void testTurnoSingletonAplicarEfectoSobreCampoDeTurnoEfectoAgujeroNegroAplicaDichoEfectoEnElCampoDelJugadorDeTurno(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();

        Campo campoUno = new Campo();
        Jugador jugadorUno = new Jugador("1",8000, campoUno);
        unTurno.setJugadores(jugadorUno, new Jugador("2",8000));

        Monstruo mokeyMokey = new Monstruo(300,100,3);
        Monstruo aitsu = new Monstruo(100,100,5);
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(agresorOscuro);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(agujaAsesina);

        EfectoSobreCampo efectoAgujeroNegro = new EfectoAgujeroNegro();

        //Testeo Singleton
        TurnoSingleton mismoTurno = TurnoSingleton.getInstance();
        mismoTurno.aplicarEfectoSobreCampoDeTurno(efectoAgujeroNegro);

        assertFalse(campoUno.esta(mokeyMokey));
        assertFalse(campoUno.esta(aitsu));
        assertFalse(campoUno.esta(agresorOscuro));
        assertFalse(campoUno.esta(agresorOscuro));

        TurnoSingleton.reiniciar();
    }
    public void testTurnoSingletonAplicarEfectoSobreCampoOponenteEfectoAgujeroNegroAplicaDichoEfectoEnElCampoDelJugadorOponente() {
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();

        Campo campoUno = new Campo();
        Jugador jugadorUno = new Jugador("1", 8000, campoUno);
        Campo campoDos = new Campo();
        Jugador jugadorDos = new Jugador("2", 8000, campoDos);
        unTurno.setJugadores(jugadorUno,jugadorDos);

        Monstruo mokeyMokey = new Monstruo(300, 100, 3);
        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);

        //Cambio de turno
        unTurno.siguiente();

        //Testeo Songleton
        TurnoSingleton mismoTurno = TurnoSingleton.getInstance();

        mismoTurno.colocarMonstruoBocaArribaEnPosAtaque(agresorOscuro);
        mismoTurno.colocarMonstruoBocaArribaEnPosAtaque(agujaAsesina);

        EfectoSobreCampo efectoAgujeroNegro = new EfectoAgujeroNegro();

        mismoTurno.aplicarEfectoSobreCampoOponente(efectoAgujeroNegro);

        assertFalse(campoUno.esta(mokeyMokey));
        assertFalse(campoUno.esta(aitsu));
        assertTrue(campoDos.esta(agresorOscuro));
        assertTrue(campoDos.esta(agresorOscuro));

        TurnoSingleton.reiniciar();
    }

    public void testTurnoSingletonCombatirAitsuEnAtaqueContraAgujaAsesinaEnAtaqueResultadoBotinMuereAitsuYJugadorDeTurnoPierdeVida(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();
        Campo campoUno =  new Campo();
        Jugador jugadorUno = new Jugador("1", 8000, campoUno);
        Campo campoDos =  new Campo();
        Jugador jugadorDos = new Jugador("2", 8000, campoDos);

        unTurno.setJugadores(jugadorUno,jugadorDos);

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);
        unTurno.siguiente();
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(agujaAsesina);
        unTurno.siguiente();

        unTurno.combatir(aitsu,agujaAsesina);

        assertFalse(campoUno.esta(aitsu));
        assertTrue(campoDos.esta(agujaAsesina));
        assertEquals(8000-1100, jugadorUno.verVida());
        assertEquals(8000, jugadorDos.verVida());
        TurnoSingleton.reiniciar();
    }

    public void testTurnoSingletonCombatirAitsuEnAtaqueContraMokeyMokeyEnAtaqueTrasAgregarEfectoDeCampoEnJugadorDeTurnoEfectoWasteLandAtaqueResultadoBotinMuerenAmbosYNingunJugadorPierdeVida(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();
        Campo campoUno =  new Campo();
        Jugador jugadorUno = new Jugador("1", 8000, campoUno);
        Campo campoDos =  new Campo();
        Jugador jugadorDos = new Jugador("2", 8000, campoDos);

        unTurno.setJugadores(jugadorUno,jugadorDos);

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo mokeyMokey = new Monstruo(300, 100, 4);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);
        unTurno.siguiente();
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);
        unTurno.siguiente();

        EfectoSobreMonstruo efectoWastelandAtaque = new EfectoWastelandAtaque();

        unTurno.agregarEfectoDeCampoEnJugadorDeTurno(efectoWastelandAtaque);

        unTurno.combatir(aitsu,mokeyMokey);

        assertFalse(campoUno.esta(aitsu));
        assertFalse(campoDos.esta(mokeyMokey));
        assertEquals(8000, jugadorUno.verVida());
        assertEquals(8000, jugadorDos.verVida());
        TurnoSingleton.reiniciar();
    }

    public void testTurnoSingletonCombatirMokeyMokeyEnDefensaContraAitsuEnDefensaTrasAgregarEfectoDeCampoEnJugadorOponenteEfectoWasteLandDefensa(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();
        Campo campoUno =  new Campo();
        Jugador jugadorUno = new Jugador("1", 8000, campoUno);
        Campo campoDos =  new Campo();
        Jugador jugadorDos = new Jugador("2", 8000, campoDos);

        unTurno.setJugadores(jugadorUno,jugadorDos);

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo aitsuConUnPuntoMasDefensa = new Monstruo(100, 101, 5);
        Monstruo goblinFalso = new Monstruo(400, 400, 4);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(goblinFalso);
        unTurno.siguiente();
        unTurno.colocarMonstruoBocaArribaEnPosDefensa(aitsu);
        unTurno.colocarMonstruoBocaArribaEnPosDefensa(aitsuConUnPuntoMasDefensa);
        unTurno.siguiente();

        EfectoSobreMonstruo efectoWastelandDefensa = new EfectoWastelandDefensa();

        unTurno.agregarEfectoDeCampoEnJugadorOponente(efectoWastelandDefensa);

        unTurno.combatir(goblinFalso,aitsu);
        unTurno.combatir(goblinFalso,aitsuConUnPuntoMasDefensa);

        assertTrue(campoUno.esta(goblinFalso));
        assertFalse(campoDos.esta(aitsu));

        assertTrue(campoDos.esta(aitsuConUnPuntoMasDefensa));
        TurnoSingleton.reiniciar();
    }
}