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
        this.posicion = new PosDormido();
        this.efecto = new EfectoNulo();

    }

    Monstruo(int danio, int defensa, int estrellas, Efecto efecto){

        this.danio = danio;
        this.defensa = defensa;
        this.estrellas = estrellas;
        this.posicion = new PosDormido();
        this.efecto = efecto;

    }

    void colocarEnPosAtaque(){

        this.posicion = new PosAtaque();

    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa();

    }

    int obtenerPuntos() {

        return this.posicion.obtenerPuntos(this.danio, this.defensa);

    }

    void aumentarAtaque(int aumento) {

        this.danio += aumento;

    }

    void aumentarDefensa(int aumento) {

        this.defensa += aumento;

    }

    Botin atacar(Monstruo enemigo) {

        this.posicion.atacar();
        Botin botin = new Botin();

        int dif = this.obtenerPuntos() - enemigo.obtenerPuntos();

        if(dif >= 0){

            this.matar(enemigo, botin);
            botin.setDanioAtacado(enemigo.posicion.danioDePersonaje(dif));

        }
        if(dif <= 0){

            enemigo.matar(this, botin);
            botin.setDanioAtacante(this.posicion.danioDePersonaje(dif));

        }

        return botin;

    }

    private void matar(Monstruo enemigo, Botin b) {

        this.posicion.matar(enemigo, b);

    }

    public void colocarEnCampo(Campo unCampo) {
        unCampo.colocarMonstruo(this);
    }
}
