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

        this.posicion = new PosAtaque();

    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa();

    }

    private int obtenerPuntos() {

        return this.posicion.obtenerPuntos(this.danio, this.defensa);

    }

    void aumentarAtaque(int aumento) {
        this.danio += aumento;
    }

    void aumentarDefensa(int aumento) {
        this.defensa += aumento;
    }

    Botin atacar(Monstruo enemigo) {

        Botin botin = new Botin();

        int dif = this.obtenerPuntos() - enemigo.obtenerPuntos();

        if(dif >= 0){

            botin.agregarMuerto(enemigo);
            botin.setDanioAtacado(enemigo.posicion.danioDePersonaje(dif));

        }
        if(dif <= 0){

            botin.agregarMuerto(this);
            botin.setDanioAtacante(this.posicion.danioDePersonaje(dif));

        }

        return botin;
    }

}
