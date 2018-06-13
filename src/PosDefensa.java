public class PosDefensa implements Posicion {

    private final Monstruo miMonstruo;

    PosDefensa(Monstruo miMonstruo){

        this.miMonstruo = miMonstruo;

    }

    public int obtenerAtaque(){

        return 0;

    }

    public int obtenerDefensa(){

        return miMonstruo.obtenerDefensa();

    }

    public int recibirAtaque(Posicion otraPosicion){

        return 0;

    }

}
