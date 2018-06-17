

public class CartaCampo implements Carta {

    private Efecto efecto;

    public CartaCampo(Efecto e) {

        this.efecto = e;

    }

    public void activarEfecto() {

        this.efecto.activar();

    }

    public void activarEfectoEnMonstruo(MonstruoComun monstruo) {

        this.efecto.activarEn(monstruo);

    }
}
