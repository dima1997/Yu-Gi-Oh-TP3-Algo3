public class Magica implements Carta {

    private Efecto efecto;

    Magica(Efecto e){

        this.efecto = e;

    }

    void activar(){

        this.efecto.activar();

    }



}
