public class EfectoAgujeroNegro implements Efecto{

    private final Campo unCampo;
    private final Campo otroCampo;

    public EfectoAgujeroNegro(Campo unCampo, Campo otroCampo){
        this.unCampo = unCampo;
        this.otroCampo = otroCampo;
    }

    public void activar(){/*
        this.unCampo.destruirTodas();
        this.otroCampo.destruirTodas();
        /*
        ArenaSingleton arena = ArenaSingleton.getInstance();
        arena.destruirTodas();
        */
    }

    public void activarEn(MonstruoComun m){}
}
