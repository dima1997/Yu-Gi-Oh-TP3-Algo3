public class Monstruo {

    private Posicion posicion;

    Monstruo(){

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
}
