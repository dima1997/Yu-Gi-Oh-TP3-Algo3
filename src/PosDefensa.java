public class PosDefensa implements Posicion {

    public void atacar(Monstruo m){

        throw new MonstruoNoPuedeAtacarError();

    }

}
