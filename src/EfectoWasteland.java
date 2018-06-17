public class EfectoWasteland implements Efecto {
    private final Campo campoPropio;
    private final Campo campoOponente;

    public EfectoWasteland(Campo campoPropio, Campo campoOponente) {
        this.campoPropio = campoPropio;
        this.campoOponente = campoOponente;
    }

    public void activar(){
        this.campoPropio.aumentarAtaque(200);
        this.campoOponente.aumentarDefensa(300);
    }

    public void activarEn(MonstruoComun monstruo) {

        if (this.campoPropio.esta(monstruo)) {

            monstruo.aumentarAtaque(200);
        }

        if (this.campoOponente.esta(monstruo)) {

            monstruo.aumentarDefensa(300);

        }


    }
}
