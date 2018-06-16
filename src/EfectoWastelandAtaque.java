public class EfectoWastelandAtaque implements EfectoSobreMonstruo {

    private final int aumento;

    public EfectoWastelandAtaque(){
        this.aumento = 200;
    }

    public void activar(Monstruo unMonstruo){
        unMonstruo.aumentarAtaque(this.aumento);
    }

    public void desactivar(Monstruo unMonstruo){
        unMonstruo.reducirAtaque(this.aumento);
    }
}
