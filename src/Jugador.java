class Jugador {

    private int vida;
    private String nombre;
    private Campo campo;

    Jugador(String nombre, int vida) {
        this.vida = vida;
        this.nombre = nombre;
        this.campo = new Campo(new Cementerio());
    }

    void recibirAtaque(int puntosRestarAtacante) {

        this.vida = this.vida - puntosRestarAtacante;

    }

    int verVida() {

        return this.vida;

    }

    public Campo obtenerCampo() {

        return this.campo;

    }

    public void colocarMosntruoEnPosAtaque(MonstruoComun monstruo) {

        this.campo.colocarMonstruo(monstruo);
        monstruo.colocarEnPosAtaque();

    }

    public void colocarMosntruoEnPosDefensa(MonstruoComun monstruo) {

        this.campo.colocarMonstruo(monstruo);
        monstruo.colocarEnPosDefensa();

    }

}
