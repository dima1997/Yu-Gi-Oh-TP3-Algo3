import junit.framework.TestCase;

public class EfectoAgujeroNegroWrapperTest extends TestCase {
    public void testEfectoAgujeroNegroWrapperActivarDestruyeTodasLasCartasDeLosCamposDeAmbosJugadores(){
        TurnoSingleton.reiniciar();
        TurnoSingleton unTurno = TurnoSingleton.getInstance();

        Campo campoUno = new Campo();
        Jugador jugadorUno = new Jugador("1",8000, campoUno);
        Campo campoDos = new Campo();
        Jugador jugadorDos = new Jugador("2",8000, campoDos);

        Monstruo mokeyMokey = new Monstruo(300,100,3);
        Monstruo aitsu = new Monstruo(100,100,5);
        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);

        unTurno.setJugadores(jugadorUno, jugadorDos);

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(mokeyMokey);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(aitsu);

        //CambioDeTurno
        unTurno.siguiente();

        unTurno.colocarMonstruoBocaArribaEnPosAtaque(agresorOscuro);
        unTurno.colocarMonstruoBocaArribaEnPosAtaque(agujaAsesina);

        EfectoAgujeroNegroWrapper unEfectoAgujeroNegroWraper = new EfectoAgujeroNegroWrapper();

        unEfectoAgujeroNegroWraper.activar();

        assertFalse(campoUno.esta(mokeyMokey));
        assertFalse(campoUno.esta(aitsu));
        assertFalse(campoDos.esta(agresorOscuro));
        assertFalse(campoDos.esta(agujaAsesina));

        TurnoSingleton.reiniciar();
    }

}
