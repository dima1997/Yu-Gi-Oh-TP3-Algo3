import junit.framework.TestCase;

public class MagicaTest extends TestCase {

    public void testCartaMagicaSeAutoDestruyeYVaAlCementerioAlColocarlaBocaArriba(){

        Efecto efectoDeMagia = new EfectoAgujeroNegro();

        Magica cartaMagica = new Magica(efectoDeMagia);

        ArenaSingleton arena = ArenaSingleton.getInstance();

        cartaMagica.colocarBocaArriba();

        arena.estaEnElCementerio(cartaMagica);

    }

}
