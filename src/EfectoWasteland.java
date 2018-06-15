public class EfectoWasteland implements Efecto {
    private final Campo campoPropio;
    private final Campo campoOponente;

    public EfectoWasteland(Campo campoPropio, Campo campoOponente) {
        this.campoPropio = campoPropio;
        this.campoOponente = campoOponente;
    }

    public void activar(){
        campoPropio.aumentarAtaque(200);
        campoOponente.aumentarDefensa(300);
    }
}
