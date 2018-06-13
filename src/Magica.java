public class Magica implements Carta {

    private Efecto efecto;

    Magica(Efecto e){

        this.efecto = e;

    }

    void colocarBocaArriba(){

        this.efecto.activar();
        
        this.autodestruir();

    }

    private void autodestruir() {

        ArenaSingleton arena = ArenaSingleton.getInstance();

        arena.enviarAlCementario(this);

    }


}
