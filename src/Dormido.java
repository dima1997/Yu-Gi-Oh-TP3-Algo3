public class Dormido implements Posicion {

    public int obtenerAtaque(){

        throw new MonstruoNoPuedeAtacarError();

    }

    public int obtenerDefensa(){

        throw new MonstruoNoPuedeAtacarError();

    }

    public int recibirAtaque(Posicion otraPosicion){

        throw new MonstruoNoPuedeAtacarError();

    }

}
