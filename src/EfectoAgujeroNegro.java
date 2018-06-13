public class EfectoAgujeroNegro implements Efecto{

    public void activar(){

        ArenaSingleton arena = ArenaSingleton.getInstance();
        arena.destruirTodas();

    }

}
