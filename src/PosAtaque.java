public class PosAtaque implements Posicion {

    public int obtenerPuntos(int danio, int defensa){

        return danio;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return Math.abs(resultadoDeBatalla);

    }

}