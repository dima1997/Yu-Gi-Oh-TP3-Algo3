public class Dormido implements Posicion {

    public void atacar(Monstruo m){

        throw new MonstruoNoPuedeAtacarError();

    }

    public int obtenerAtaque(){
        return 0;
    }

    public int obtenerDefensa(){
        return 0;
    }

    public int recibirAtaque(Posicion otraPosicion){
        return 0;
    }

}
