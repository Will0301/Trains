import java.util.*;
import java.util.stream.Collectors;

public class GaragemVagoes {
    private ArrayList<Vagao> vagoes;
    private int maximo;

    public GaragemVagoes(int max) {
        vagoes = new ArrayList<>();
        maximo = max;
    }

    public void addVagaoAGaragem(Vagao vagao) {

        for (Vagao v : vagoes) {
            if (v.getIdentificador() == vagao.getIdentificador()) {
                System.out.println("Já existe vagão com o id inserido!");
                return;
            }
        }

        vagoes.add(vagao);
    }

    public Vagao getById(int id) {
        for (Vagao vagao : vagoes) {
            if (vagao.getIdentificador() == id) {
                return vagao;
            }
        }
        return null;
    }

    public List<Vagao> listarVagoesLivres() {
        List<Vagao> filtro = new LinkedList<>();
        for (Vagao v : vagoes) {
            if (v.livre()) {
                filtro.add(v);
            }
        }
        return filtro;
    }

}
