public class Monstruo {

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

        this.posicion = new PosAtaque();

    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa();

    }


    public void atacar(Monstruo m2) {

        this.posicion.atacar(m2);

    }

    int danioContra(Monstruo m){

        if (this.danio < m.danio){
            return 0;
        }

        return this.danio - m.danio;

    }
}
