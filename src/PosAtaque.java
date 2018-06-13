public class PosAtaque implements Posicion {

    private final Monstruo miMonstruo;

    public void atacar(Monstruo m){
    }

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
        int miDefensa = this.obtenerAtaque();

        if (miDefensa > suAtaque){
            return 0;
        }

        return suAtaque - miDefensa;
    }
}