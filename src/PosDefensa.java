public class PosDefensa implements PosicionStrategy {

    public int obtenerPuntos(int danio, int defensa){

        return defensa;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return 0;

    }

    public void matar(Monstruo enemigo, Botin b) {
    }

    public Botin atacar(PosicionStrategy posicionAtacada, Monstruo atacante, Monstruo atacado) {

        throw new MonstruoNoSeEncuentraEnArenaDeJuegoError();

    }
}
