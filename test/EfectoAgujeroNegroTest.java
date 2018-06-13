import junit.framework.TestCase;

public class EfectoAgujeroNegroTest extends TestCase {

    public void testActivarEfectoAgujeroNegroDestruyeTodosLosMonstruos(){

        ArenaSingleton arena = ArenaSingleton.getInstance();
        Monstruo uno = new Monstruo(10, 10, 1);
        Monstruo dos = new Monstruo(1,1,1);
        Monstruo tres = new Monstruo(2,2,2);
        arena.colocarMonstruo(uno);
        arena.colocarMonstruo(dos);
        arena.colocarMonstruo(tres);
        Efecto e = new EfectoAgujeroNegro();

        e.activar();

        assertTrue(arena.estaEnElCementerio(uno));
        assertTrue(arena.estaEnElCementerio(dos));
        assertTrue(arena.estaEnElCementerio(tres));

    }

}