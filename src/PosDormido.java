public class PosDormido implements PosicionStrategy {

    public int obtenerPuntos(int danio, int defensa) {

        throw new MonstruoNoSeEncuentraEnArenaDeJuegoError();

    }

    public int danioDePersonaje(int dif) {

        return 0;

    }

    public void matar(Monstruo enemigo, Botin b) {
    }

    public Botin atacar(PosicionStrategy posicionAtacada, Monstruo atacante, Monstruo atacado) {

        throw new MonstruoNoSeEncuentraEnArenaDeJuegoError();

    }

}
