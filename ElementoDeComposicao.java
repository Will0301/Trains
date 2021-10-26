abstract class ElementoDeComposicao {

    protected int identificador;

    protected Composicao composicao;

    public int getIdentificador(){return identificador;};

    public Composicao getComposicao() {return composicao; }

    abstract boolean livre();

    abstract void setComposicao(Composicao composicao);

    public String toString(){
        if (livre()){
            return "\n[LIVRE, identificador=" + identificador +"]";
        }
        return "\n[Engatada na composicao=" + composicao.getIdentificador() + ", identificador=" + identificador +"]\n";
    }


}
