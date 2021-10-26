import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatioComposicoes {

    private ArrayList<Composicao> composicoes;

    public PatioComposicoes(int capacidadeMaxima) {
        this.composicoes = new ArrayList<>(capacidadeMaxima);
    }

    public void add(Composicao composicao) {
        composicoes.add(composicao);
    }

    public boolean removerComposicaoPorId(int identificador) {
        Composicao composicao;
        for (int i = composicoes.size() - 1; i >= 0; i--) {
            composicao = composicoes.get(i);
            if (composicao.getIdentificador() == identificador) {
                while (composicao.desengatar()) {
                    if (composicao.estaVazia()) {
                        composicoes.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Composicao getById(int id) {
        for (Composicao composicao : composicoes) {
            if (composicao.getIdentificador() == id) {
                return composicao;
            }
        }
        return null;
    }

    public void listarVagoesLivres() {
        composicoes.forEach(System.out::println);
    }
}
