import java.util.ArrayList;

public class Campo {

    private final ArrayList<Monstruo> monstruos;
    private final Cementerio cementerio;
    private ArrayList<Magica> magicas;

    public Campo(){
        this.cementerio = new Cementerio();
        this.monstruos = new ArrayList<Monstruo>();
        this.magicas = new ArrayList<Magica>();
    }

    public Campo(Cementerio unCementerio){
        this.cementerio = unCementerio;
        this.monstruos = new ArrayList<Monstruo>();
        this.magicas = new ArrayList<Magica>();
    }

    public boolean esta(Object unaCarta) {
        return this.monstruos.contains(unaCarta) || this.magicas.contains(unaCarta);
    }

    public void colocarMonstruo(Monstruo unMonstruo) {
        this.monstruos.add(unMonstruo);
    }

    public void destruir(Object unaCarta) {
        if (this.monstruos.contains(unaCarta)){
            this.monstruos.remove(unaCarta);
        }
        if (this.magicas.contains(unaCarta)){
            this.magicas.remove(unaCarta);
        }
        this.cementerio.enviar(unaCarta);
    }

    public void destruirTodas() {
        for (int i = 0; i < this.monstruos.size(); i++){
            this.cementerio.enviar(this.monstruos.get(i));
        }
        this.monstruos.clear();
        for (int i = 0; i < this.magicas.size(); i++){
            this.cementerio.enviar(this.magicas.get(i));
        }
        this.magicas.clear();

    }

    public void colocarMagicaBocaAbajo(Magica unaCarta) {
        this.magicas.add(unaCarta);
    }

    public void colocarMagicaBocaArriba(Magica unaCarta) {
        /*unaCarta.colocarBocaArriba();*/
        this.cementerio.enviar(unaCarta);
    }

    public void aumentarAtaque(int aumento) {
        for (int i=0; i<this.monstruos.size(); i++){
            Monstruo unMonstruo = this.monstruos.get(i);
            unMonstruo.aumentarAtaque(aumento);
        }
    }

    public void aumentarDefensa(int aumento) {
        for (int i=0; i<this.monstruos.size(); i++){
            Monstruo unMonstruo = this.monstruos.get(i);
            unMonstruo.aumentarDefensa(aumento);
        }
    }

	public ArrayList<Monstruo> obtenerListaDeMonstruosBocaArriba() {
		return monstruos;
	}
}
