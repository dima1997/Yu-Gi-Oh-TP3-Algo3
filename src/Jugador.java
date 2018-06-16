public class Jugador {

    private final Campo campo;
    private int vida;
    private String nombre;

    public Jugador(String nombre, int vida) {
        this.vida = vida;
        this.nombre = nombre;
        this.campo = new Campo();
    }

    public Jugador(String nombre, int vida, Campo campoJugador){
        this.vida = vida;
        this.nombre = nombre;
        this.campo = campoJugador;
    }

    public void recibirAtaque(int puntosRestarAtacante) {

        this.vida = this.vida - puntosRestarAtacante;

    }

    public int verVida() {

        return this.vida;

    }

    public void colocarCarta(Monstruo unMonstruo) {
        unMonstruo.colocarEnCampo(this.campo);
    }

    public void aplicarEfectoSobreCampo(EfectoSobreCampo efectoSobreCampo) {
        efectoSobreCampo.activar(this.campo);
    }
}
