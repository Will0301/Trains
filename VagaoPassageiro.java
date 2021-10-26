public class VagaoPassageiro extends Vagao {
    protected int QuantidadePassageiros;


    public VagaoPassageiro(int identificador, double capacidadeCarga) {
        super(identificador, capacidadeCarga);
    }

    public void setQuantidadePassegeiros(int numPassegeiros){ this.QuantidadePassageiros = numPassegeiros; }

    public int getQuantidadePassegeiros(){ return QuantidadePassageiros; }

    @Override
    public String toString() {
        if (livre()){
            return "\nVagao de passageiro [LIVRE, capacidadeCarga=" + capacidadeCarga + ", identificador=" + identificador + ",número de passageiros=" + QuantidadePassageiros + "]";
        }
        return "\nVagao de passageiros [Engatado na composicao: "+composicao.getIdentificador()+", capacidadeCarga=" + capacidadeCarga + ", identificador= "+ identificador + " passageiros a bordo= " + QuantidadePassageiros + "]\n";
    }
}
