import junit.framework.TestCase;

public class EfectoWasteLandWrapperTest extends TestCase {
    public void testEfectoWastelandWrapperActivarAumenta200ElAtaqueDeLosMonstruosDelJugadorDeTurnoY300LaDefensaDeLosDelOponente(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();
        Campo campoUno =  new Campo();
        Jugador jugadorUno = new Jugador("1", 8000, campoUno);
        Campo campoDos =  new Campo();
        Jugador jugadorDos = new Jugador("2", 8000, campoDos);

        unTurno.setJugadores(jugadorUno,jugadorDos);

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo otroMonstruo = new Monstruo(100, 100, 5);
        Monstruo otroMonstruoMasUnoDefensa = new Monstruo(100, 201, 5);
        Monstruo mokeyMokey = new Monstruo(300,100,3);
        Monstruo otroMokeyMokey = new Monstruo(300, 100, 4);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(otroMokeyMokey);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);
        unTurno.siguiente();
        unTurno.colocarMonstruoBocaArribaEnPosDefensa(otroMonstruo);
        unTurno.colocarMonstruoBocaArribaEnPosDefensa(otroMonstruoMasUnoDefensa);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);
        unTurno.siguiente();

        EfectoWrapper efectoWasteland = new EfectoWastelandWrapper();
        efectoWasteland.activar();

        unTurno.combatir(otroMokeyMokey,otroMonstruo);
        unTurno.combatir(otroMokeyMokey,otroMonstruoMasUnoDefensa);
        unTurno.combatir(aitsu,mokeyMokey);

        assertFalse(campoUno.esta(aitsu));
        assertFalse(campoDos.esta(mokeyMokey));
        assertTrue(campoUno.esta(otroMokeyMokey));
        assertFalse(campoDos.esta(otroMonstruo));
        assertTrue(campoDos.esta(otroMonstruoMasUnoDefensa));

        TurnoSingleton.reiniciar();
    }
}
