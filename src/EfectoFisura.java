import java.util.ArrayList;

public class EfectoFisura implements EfectoSobreCampo {

	public void activar(Campo unCampo) {
		
		ArrayList<Monstruo> listaDeMonstruosBocaArriba = unCampo.obtenerListaDeMonstruosBocaArriba();

		listaDeMonstruosBocaArriba.sort(Monstruo.CompararPorAtaque);
		Monstruo monstruoADestruir = listaDeMonstruosBocaArriba.get(0);
		
		unCampo.destruir(monstruoADestruir);
	}

}
