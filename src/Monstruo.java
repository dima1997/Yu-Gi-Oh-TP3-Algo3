public class Monstruo implements Carta{

    private Posicion posicion;
    private int danio;
    private int defensa;
    private int estrellas;

    Monstruo(int danio, int defensa, int estrellas){

        this.danio = danio;
        this.defensa = defensa;
        this.estrellas = estrellas;
        this.posicion = new Dormido();

    }

    void colocarEnPosAtaque(){

        this.posicion = new PosAtaque(this);

    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa(this);

    }


    public void atacar(Monstruo m2) {

        this.posicion.atacar(m2);

    }
    /*Sin testear*/
    public int obtenerAtaque() {
        return this.danio;
    }
    /*Sin testear*/
    public int obtenerDefensa() {
        return this.defensa;
    }

    int danioContra(Monstruo m){
        Posicion miPosicion = this.posicion;
        Posicion suPosicion = m.posicion;
        return suPosicion.recibirAtaque(miPosicion);

        /*
        int miAtaque = this.posicion.obtenerAtaque();
        int suDefensa = m.posicion.obtenerDefensa();

        if (suDefensa > miAtaque){
            return 0;
        }

        return miAtaque - suDefensa;
        */
    }

    boolean esDestruidoPor(Monstruo m){
        int miDefensa = this.posicion.obtenerDefensa();
        int suAtaque = m.posicion.obtenerAtaque();

        return miDefensa <= suAtaque;
    }


}