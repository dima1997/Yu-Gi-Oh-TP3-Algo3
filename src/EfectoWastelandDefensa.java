public class EfectoWastelandDefensa implements EfectoSobreMonstruo {

    private final int aumento;

    public EfectoWastelandDefensa() {
        this.aumento = 300;
    }

    public void activar(Monstruo unMonstruo){
        unMonstruo.aumentarDefensa(this.aumento);
    }

    public void desactivar(Monstruo unMonstruo){
        unMonstruo.reducirDefensa(this.aumento);
    }
}
