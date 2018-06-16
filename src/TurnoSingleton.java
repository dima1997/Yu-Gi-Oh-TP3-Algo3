public class TurnoSingleton {
    private Jugador jugadorDeTurno;
    private Jugador jugadorOponente;

    //Logica del Singleton
    private static TurnoSingleton INSTANCE = null;

    private TurnoSingleton(){
        this.jugadorDeTurno = new Jugador("1",8000);
        this.jugadorOponente = new Jugador("2",8000);

    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TurnoSingleton();
        }
    }

    public static TurnoSingleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    public static void reiniciar(){
        INSTANCE = null;
    }

    public void setJugadores(Jugador jugadorDeTurno, Jugador jugadorOponente) {
        this.jugadorDeTurno = jugadorDeTurno;
        this.jugadorOponente = jugadorOponente;
    }

    public void colocarMonstruoBocaArribaEnPosAtaque(Monstruo unMonstruo) {
        unMonstruo.colocarEnPosAtaque();
        /*unMonstruo.colocarBocaArriba();*/
        this.jugadorDeTurno.colocarCarta(unMonstruo);
    }

    public void aplicarEfectoSobreCampoDeTurno(EfectoSobreCampo efectoSobreCampo) {
        this.jugadorDeTurno.aplicarEfectoSobreCampo(efectoSobreCampo);
    }

    public void aplicarEfectoSobreCampoOponente(EfectoSobreCampo efectoSobreCampo) {
        this.jugadorOponente.aplicarEfectoSobreCampo(efectoSobreCampo);
    }

    public void siguiente() {
        Jugador jugadorTemporal = this.jugadorDeTurno;
        this.jugadorDeTurno = this.jugadorOponente;
        this.jugadorOponente = jugadorTemporal;
    }

    public void combatir(Monstruo monstruoDeTurno, Monstruo monstruoOponente) {

        this.jugadorDeTurno.aplicarEfectosDeCampo(monstruoDeTurno);
        this.jugadorOponente.aplicarEfectosDeCampo(monstruoOponente);

        Botin unBotin = monstruoDeTurno.atacar(monstruoOponente);
        this.aplicarEfectoSobreCampoDeTurno(unBotin);
        this.aplicarEfectoSobreCampoOponente(unBotin);
        unBotin.infligirDanios(this.jugadorDeTurno, this.jugadorOponente);

        this.jugadorDeTurno.desaplicarEfectosDeCampo(monstruoDeTurno);
        this.jugadorOponente.desaplicarEfectosDeCampo(monstruoOponente);

    }

    public void agregarEfectoDeCampoEnJugadorDeTurno(EfectoSobreMonstruo efectoDeCampo) {
        this.jugadorDeTurno.agregarEfectoDeCampo(efectoDeCampo);
    }

    public void colocarMonstruoBocaArribaEnPosDefensa(Monstruo unMonstruo) {
        unMonstruo.colocarEnPosDefensa();
        /*unMonstruo.colocarBocaArriba();*/
        this.jugadorDeTurno.colocarCarta(unMonstruo);
    }

    public void agregarEfectoDeCampoEnJugadorOponente(EfectoSobreMonstruo efectoDeCampo) {
        this.jugadorOponente.agregarEfectoDeCampo(efectoDeCampo);
    }
}
