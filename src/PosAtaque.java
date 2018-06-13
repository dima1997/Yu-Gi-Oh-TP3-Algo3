public class PosAtaque implements Posicion {

    private final Monstruo miMonstruo;

    PosAtaque(Monstruo miMonstruo){

        this.miMonstruo = miMonstruo;

    }

    public int obtenerAtaque(){

        return this.miMonstruo.obtenerAtaque();

    }

    public int obtenerDefensa(){

        return this.miMonstruo.obtenerAtaque();

    }

    public int recibirAtaque(Posicion otraPosicion){
        int suAtaque = otraPosicion.obtenerAtaque();
        int miDefensa = this.obtenerDefensa();

        if (miDefensa > suAtaque){
            return 0;
        }

        return suAtaque - miDefensa;
    }
}