public interface PosicionStrategy {

    int obtenerPuntos(int danio, int defensa);

    int danioDePersonaje(int dif);

    void matar(Monstruo enemigo, Botin b);

    Botin atacar(PosicionStrategy posicionAtacada, Monstruo atacante, Monstruo atacado);
}
