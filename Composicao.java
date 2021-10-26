import java.util.ArrayList;

public class Composicao {

	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;
	private int identificador;

	public Composicao(int identificador) {
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeLocomotivas() {
		return locomotivas.size();
	}

	public Locomotiva getLocomotiva(int posicao) {
		if (posicao >= 0 && posicao < locomotivas.size()) {
			return locomotivas.get(posicao);
		} else {
			return null;
		}
	}

	public int getQtdadeVagoes() {
		return vagoes.size();
	}

	public Vagao getVagao(int posicao) {
		if (posicao >= 0 && posicao < vagoes.size()) {
			return vagoes.get(posicao);
		} else {
			return null;
		}
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		if (locomotiva == null) {
			System.out.println("Locomotiva não existe!");
			return false;
		}
		if (!locomotiva.livre()) {
			System.out.println("Locomotiva já pertence a uma composição!");
			return false;
		}
		if (temVagao()) {
			System.out.println("Composição já possuí ao menos um vagão engatado!");
			return false;
		}
		locomotivas.add(locomotiva);
		locomotiva.setComposicao(this);
		return true;
	}

	public boolean excedeCapacidadeMaxima(Vagao vagaoEngatado) {
		double capacidadeDeCargaDasLocomotivas = 0.;
		double pesoVagoes = 0;

		for (int i = 0; i < locomotivas.size(); i++) {
			capacidadeDeCargaDasLocomotivas += locomotivas.get(i).getPesoMaximo() * (1 - (0.1 * i));
			if (i == 9) break;
		}

		for (Vagao vagao : vagoes) {
			pesoVagoes += vagao.getCapacidadeCarga();
		}

		return capacidadeDeCargaDasLocomotivas < pesoVagoes + vagaoEngatado.getCapacidadeCarga();
	}

	public boolean excedeQuantidadeMaxima() {
		double qtdMaxima = 0.;

		for (int i = 0; i < locomotivas.size(); i++) {
			qtdMaxima += locomotivas.get(i).getQtdadeMaxVagoes() * (1 - (0.1 * i));
			if (i == 9) break;
		}

		return qtdMaxima < vagoes.size() + 1;
	}

	public boolean engataVagao(Vagao vagao) {
		if (vagao == null) {
			System.out.println("Vagão não existe!");
			return false;
		}
		if (excedeCapacidadeMaxima(vagao)) {
			System.out.println("Inserir um novo vagão excederá a capacidade máxima de peso");
			return false;
		}
		if(excedeQuantidadeMaxima()) {
			System.out.println("Inserir um novo vagão excederá a quantidade máxima");
			return false;
		}
		vagoes.add(vagao);
		vagao.setComposicao(this);
		return true;
	}

	public boolean desengatar() {
		if (locomotivas.isEmpty()) {
			System.out.println("Essa composição não possuí mais elementos para serem desengatados");
			return false;
		} else if (vagoes.isEmpty()) {
			locomotivas.remove(locomotivas.size() - 1);
			return true;
		} else {
			vagoes.remove(vagoes.size() - 1);
			return true;
		}
	}

	private boolean temVagao() {
		return !this.vagoes.isEmpty();
	}

	public boolean estaVazia(){
		return temVagao() && locomotivas.isEmpty();
	}

	public String toString() {
		StringBuilder aux = new StringBuilder("Composicao: ");
		aux.append(this.getIdentificador()).append("\n");
		aux.append("Locomotivas:\n");

		for (int i = 0; i < this.getQtdadeLocomotivas(); i++) {
			aux.append("    ").append(this.getLocomotiva(i).toString()).append("\n");
		}

		aux.append("Vagoes:\n") ;

		for (int i = 0; i < this.getQtdadeVagoes(); i++) {
			aux.append("    ").append(this.getVagao(i).toString()).append("\n");
		}
		return aux.toString();
	}
}
