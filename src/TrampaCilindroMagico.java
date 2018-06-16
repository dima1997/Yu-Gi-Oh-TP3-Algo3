public class TrampaCilindroMagico extends Trampa{

    private final Jugador jugadorDeCartaTrampa;
    private final Jugador oponente;

    TrampaCilindroMagico(Jugador jugadorConCarta, Jugador oponente){

        this.jugadorDeCartaTrampa = jugadorConCarta;
        this.oponente = oponente;

    }

    void activar(Botin botin, Monstruo atacante, Monstruo atacado){

        botin.quitarMuerto(atacado);

        botin.setDanioAtacante(atacante.obtenerPuntos());

    }


}

