public class Vagao extends ElementoDeComposicao{
	protected double capacidadeCarga;

	public Vagao(int identificador, double capacidadeCarga) {
		super.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga; //numPessoas * 70;
		super.composicao = null;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	@Override
	public boolean livre(){
		return composicao == null;
	}

	@Override
	public void setComposicao(Composicao composicao) {
		this.composicao = composicao;
	}

	@Override
	public String toString() {
		if (livre()){
			return "\nVagao [LIVRE, capacidadeCarga=" + capacidadeCarga + ", identificador=" + identificador + "]";
		}
		return "\nVagao [Engatado na composicao: "+composicao.getIdentificador()+", capacidadeCarga=" + capacidadeCarga + ", identificador= "+ identificador + "]\n";
	}
}
