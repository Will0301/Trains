import java.util.*;

public class App {

    private static PatioComposicoes composicaoList = new PatioComposicoes(100);
    private static GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas(100);
    private static GaragemVagoes garagemVagoes = new GaragemVagoes(100);
    private static Scanner teclado = new Scanner(System.in);
    private static Random random = new Random();

/**
 integrantes do grupo:
 - Eduardo Henrique da Silva Cardoso - 20101119-4
 - Patricia Brandt de Lima -20107987-8
 - Willian Weyh - 21103154
  
  Modo de execucao: Compilar a class App, onde esta localizado o void.
 
 
**/       public static void main(String[] args) throws Exception {
        populaGaragemLocomotiva();
        populaGaragemVagoes();
        menu();
    }

    public static void populaGaragemLocomotiva() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < i; j++) {
                int peso = random.nextInt();
                if (peso < 0) {
                    peso = peso * (-1);
                }
                int vagoes = random.nextInt();
                if (vagoes < 0) {
                    vagoes = vagoes* (-1);
                }
                garagemLocomotivas.addLocomotivaAGaragem(new Locomotiva(random.nextInt(50) + 1, peso, vagoes ));
            }
        }
    }

    public static void populaGaragemVagoes() {
        for (int i = 0; i < 30; i++) {
            garagemVagoes.addVagaoAGaragem(new Vagao(random.nextInt(50) + 1, Math.round(random.nextDouble() * 1000)));
        }
    }


    public static void menu() {
        System.out.println("    o O O   ___     ___     ___     ___     ___     ___     ___     ___  \n" +
                "   o       | B |   | E |   | M |   | V |   | I |   | N |   | D |   | O | \n" +
                "  TS__[O]  |___|   |___|   |___|   |___|   |___|   |___|   |___|   |___| \n" +
                " {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|\n" +
                "./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'");

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\nDigite 1 para criar composicao");
            System.out.println("\nDigite 2 para editar uma composicao");
            System.out.println("\nDigite 3 para listar as composicoes");
            System.out.println("\nDigite 4 para desfazer composicao");
            System.out.println("\nDigite 5 para sair\n");
            opcao = teclado.nextInt();
            mainMenuOptions(opcao);
        }
    }


    private static void mainMenuOptions(int opcao) {
        Composicao composicao;
        Locomotiva locomotiva;
        Vagao vagao;
        int input;
        switch (opcao) {
            case 1:
                System.out.println("Digite um identificador para sua nova composição:");
                input = teclado.nextInt();
                composicao = new Composicao(input);
                System.out.println("Digite o identificador da locomotiva que deseja engatar na nova composição");
                System.out.println("Locomotivas disponiveis no momento:");
                System.out.println(garagemLocomotivas.listarLocomotivasLivres());

                input = teclado.nextInt();
                locomotiva = garagemLocomotivas.getById(input);
                if (composicao.engataLocomotiva(locomotiva)) {
                    composicaoList.add(composicao);
                }

                System.out.println(composicao);
                break;
            case 2:
                System.out.println("Digite um identificador da composição que deseja editar:");
                input = teclado.nextInt();
                composicao = composicaoList.getById(input);

                if (composicao != null) {
                    opcao = 0;
                    while (opcao != 5) {
                        System.out.println("Entrando no editor de composições\nDigite a opção que deseja");
                        System.out.println("Digite 1 para Inserir uma locomotiva");
                        System.out.println("Digite 2 para Inserir um vagão");
                        System.out.println("Digite 3 para Listar locomotivas livres");
                        System.out.println("Digite 4 para Listar vagões livres");
                        System.out.println("Digite 5 para Encerrar a edição da composição");
                        opcao = teclado.nextInt();
                        compositionEditionMenu(opcao, composicao);
                    }
                }

                break;
            case 3:
                //listar composições
                composicaoList.listarVagoesLivres();
                break;
            case 4:
                //Desfazer composição
                System.out.println("Digite um identificador da composição que deseja desfazer:");
                input = teclado.nextInt();
                if (composicaoList.removerComposicaoPorId(input)){
                    System.out.println("Composição de Id: " + input + " foi devidamente desfeita");
                } else {
                    System.out.println("Composição não foi encontrada.");
                }
                break;
            case 5:
                System.out.println("Obrigado por utilizar nosso gerenciador de composições. Volte sempre.");
                //Finalizar programa
                break;
            default:
                System.out.println("Voce digitou uma opção inválida. Digite novamente, por favor.");
        }
    }

    private static void compositionEditionMenu(int opcao, Composicao composicao) {
        Locomotiva locomotiva;
        Vagao vagao;
        int input;
        switch (opcao) {
            case 1:
                //inserir locomotiva
                System.out.println("Digite o identificador da locomotiva");
                System.out.println("Locomotivas disponiveis no momento:");
                System.out.println(garagemLocomotivas.listarLocomotivasLivres());
                input = teclado.nextInt();
                locomotiva = garagemLocomotivas.getById(input);
                if (composicao.engataLocomotiva(locomotiva)) {
                    System.out.println("Locomotiva engatada com sucesso");
                }
                break;
            case 2:
                int resposta = 0;
                int passageiro = 0;
                System.out.println("Digite o identificador do vagão que deseja engatar na nova composição");
                System.out.println("Vagoes disponiveis no momento:");
                System.out.println(garagemVagoes.listarVagoesLivres());
                input = teclado.nextInt();
                vagao = garagemVagoes.getById(input);
                int id = vagao.getIdentificador();
                double carga = vagao.getCapacidadeCarga();
                System.out.println("É um vagão de passageiros?\n (1) não \n (2) sim");
                resposta = teclado.nextInt();

                switch (resposta) {
                    case 1:
                        if (composicao.engataVagao(vagao)) {
                            System.out.println("Vagão engatado com sucesso");
                        }
                        break;
                    case 2:
                        System.out.println("Quantos passageiros estarão a bordo?");
                        passageiro = teclado.nextInt();
                        int peso = passageiro * 70;
                        while (passageiro * 70 > carga){
                            System.out.println("Peso máximo excedido");
                            System.out.println("Quantos passageiros estarão a bordo?");
                            passageiro = teclado.nextInt();
                        }
                        VagaoPassageiro VagaoPassageiro = new VagaoPassageiro(id, carga);
                        VagaoPassageiro.setQuantidadePassegeiros(passageiro);
                        if (composicao.engataVagao(VagaoPassageiro)) {
                            System.out.println("Vagão engatado com sucesso");
                        }
                        break;
                }
                break;
                    case 3:
                //listar locomotivas livres
                System.out.println(garagemLocomotivas.listarLocomotivasLivres());
                break;
            case 4:
                //listar vagoes livres
                System.out.println(garagemVagoes.listarVagoesLivres());
                break;
            default:
                //Finalizar edição
                System.out.println("Retornando ao menu principal");
                break;
        }
    }
}
