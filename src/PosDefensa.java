public class PosDefensa implements Posicion {

    public int obtenerPuntos(int danio, int defensa){

        return defensa;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return 0;

    }

    public void atacar() {

        throw new MonstruoNoSeEncuentraEnArenaDeJuegoError();

    }
}
