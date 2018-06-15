public class EfectoSogen implements Efecto {
    private final Campo campoPropio;
    private final Campo campoOponente;

    public EfectoSogen(Campo campoPropio, Campo campoOponente) {
        this.campoPropio = campoPropio;
        this.campoOponente = campoOponente;
    }

    public void activar(){
        this.campoPropio.aumentarDefensa(500);
        this.campoOponente.aumentarAtaque(200);
    }
}
