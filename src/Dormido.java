public class Dormido implements Posicion {

    public void atacar(Monstruo m){

        throw new MonstruoNoPuedeAtacarError();

    }

}
