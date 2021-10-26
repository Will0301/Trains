public class Locomotiva extends ElementoDeComposicao {
	private double pesoMaximo;
	private int qtdadeMaxVagoes;

	public Locomotiva(int identificador, double pesoMaximo, int qtdadeVagoes) {
		super.identificador = identificador;
		this.pesoMaximo = pesoMaximo;
		this.qtdadeMaxVagoes = qtdadeVagoes;
		super.composicao = null;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public int getQtdadeMaxVagoes() {
		return qtdadeMaxVagoes;
	}

	@Override
	public boolean livre(){ return composicao == null; }

	@Override
	public void setComposicao(Composicao composicao) {
		this.composicao = composicao;
	}

	@Override
	public String toString() {
		if (livre()){
			return "\nLocomotiva [LIVRE, identificador=" + identificador + ", pesoMaximo="
					+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]";
		}
		return "\nLocomotiva [Engatada na composicao=" + composicao.getIdentificador() + ", identificador=" + identificador + ", pesoMaximo="
				+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]\n";
	}
}
