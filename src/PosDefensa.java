public class PosDefensa implements Posicion {

    public int obtenerPuntos(int danio, int defensa){

        return defensa;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return 0;

    }

    public void matar(Monstruo enemigo, Botin b) {
    }

    public void atacar() {

        throw new MonstruoNoSeEncuentraEnArenaDeJuegoError();

    }
}
