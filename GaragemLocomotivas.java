import java.util.*;
import java.util.stream.Collectors;


public class GaragemLocomotivas {
    private ArrayList<Locomotiva> locomotivas;
    private int maximo;

    public GaragemLocomotivas(int max) {
        locomotivas = new ArrayList<>();
        maximo = max;
    }

    public void addLocomotivaAGaragem(Locomotiva locomotiva){

        for (Locomotiva l : locomotivas) {
            if (l.getIdentificador() == locomotiva.getIdentificador()) {
                System.out.println("Já existe locomotiva com o id inserido!");
                return;
            }
        }

        locomotivas.add(locomotiva);
    }

    public Locomotiva getById(int id){
        for (Locomotiva locomotiva : locomotivas) {
            if(locomotiva.getIdentificador() == id) {
                return locomotiva;
            }
        }
        return null;
    }

    public List<Locomotiva> listarLocomotivasLivres() {
        List<Locomotiva> filtro = new LinkedList<>();
        for (Locomotiva l : locomotivas) {
            if (l.livre()) {
                filtro.add(l);
            }
        }
        return filtro;
    }
}
