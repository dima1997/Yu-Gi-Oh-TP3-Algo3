public class Monstruo implements Carta{

    private Posicion posicion;
    private int danio;
    private int defensa;
    private int estrellas;
    private Efecto efecto;

    Monstruo(int danio, int defensa, int estrellas){

        this.danio = danio;
        this.defensa = defensa;
        this.estrellas = estrellas;
        this.posicion = new Dormido();
        this.efecto = new EfectoNulo();

    }

    Monstruo(int danio, int defensa, int estrellas, Efecto efecto){

        this.danio = danio;
        this.defensa = defensa;
        this.estrellas = estrellas;
        this.posicion = new Dormido();
        this.efecto = efecto;

    }

    void colocarEnPosAtaque(){

        this.posicion = new PosAtaque(this);

    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa(this);

    }


    void atacar(Monstruo m2) {

        this.posicion.atacar(m2);

    }

    int obtenerAtaque() {

        return this.danio;

    }

    int obtenerDefensa() {

        return this.defensa;

    }

    int danioContra(Monstruo m){
        Posicion miPosicion = this.posicion;
        Posicion suPosicion = m.posicion;

        return suPosicion.recibirAtaque(miPosicion);
    }

    boolean esDestruidoPor(Monstruo m){
        int miDefensa = this.posicion.obtenerDefensa();
        int suAtaque = m.posicion.obtenerAtaque();

        return miDefensa <= suAtaque;
    }


}
