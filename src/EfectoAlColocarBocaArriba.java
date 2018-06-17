public class EfectoAlColocarBocaArriba extends EfectoDecorator {

    private final MonstruoComun carta;

    public EfectoAlColocarBocaArriba(MonstruoComun m) {

        super(m);
        this.carta = m;

    }

    public void colocarEnPosAtaque(){

        this.carta.colocarEnPosAtaque();
        this.carta.activarEfecto();
    }


}
