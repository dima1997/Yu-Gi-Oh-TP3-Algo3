public class Jugador {

    private int vida;
    private String nombre;

    public Jugador(String nombre, int vida) {
        this.vida = vida;
        this.nombre = nombre;
    }

    public void recibirAtaque(int puntosRestarAtacante) {

        this.vida = this.vida - puntosRestarAtacante;

    }

    public int verVida() {

        return this.vida;

    }
}
