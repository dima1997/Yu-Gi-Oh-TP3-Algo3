import junit.framework.TestCase;

public class MagicaTest extends TestCase {

    public void testCartaMagicaSeAutoDestruyeYVaAlCementerioAlColocarlaBocaArriba(){

        Efecto efectoDeMagia = new EfectoAgujeroNegro(new Campo(new Cementerio()), new Campo(new Cementerio()));

        Magica cartaMagica = new Magica(efectoDeMagia);

        ArenaSingleton arena = ArenaSingleton.getInstance();

        cartaMagica.colocarBocaArriba();

        arena.estaEnElCementerio(cartaMagica);

    }

}
