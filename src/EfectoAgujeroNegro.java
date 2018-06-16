public class EfectoAgujeroNegro implements EfectoSobreCampo {

    public void activar(Campo unCampo){
        unCampo.destruirTodas();
    }
}
