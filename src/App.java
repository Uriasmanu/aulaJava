import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        IniciaDados dados = new IniciaDados();
        dados.iniciar();

        Menu opcoes = new Menu();
        opcoes.menuOperacoes(dados); // Passa a instância de IniciaDados para Menu
    }
}

class IniciaDados {
    String nome, conta;
    double saldoInicial;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seja bem-vindo(a)");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Digite o seu nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite o tipo da conta: ");
        conta = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        saldoInicial = Double.parseDouble(scanner.nextLine());
    }
}

class Menu {
    int opcoes;
    double saldoInicial, valorTransferir, valorReceber;
    String nome;

    public void menuOperacoes(IniciaDados dados) {
        // Agora, você pode acessar o saldo inicial através da instância de IniciaDados
        saldoInicial = dados.saldoInicial;
        nome = dados.nome;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Consultar o saldo");
            System.out.println("2 - Receber valor");
            System.out.println("3 - Transferir valor");
            System.out.println("4 - Sair");

            opcoes = Integer.parseInt(scanner.nextLine());

            switch (opcoes) {
                case 1:
                System.out.println("-------------------------------------------------------------");
                    System.out.println(nome + " O seu saldo Atual é: " + saldoInicial);
                    break;
                case 2:
                System.out.println("-------------------------------------------------------------");
                    System.out.print(nome + " qual o valor você tem a receber?: ");
                    valorReceber = Double.parseDouble(scanner.nextLine());

                    saldoInicial = saldoInicial + valorReceber;
                System.out.println("-------------------------------------------------------------");
                    System.out.println(nome + " O seu saldo Atual é: " + saldoInicial);
                    break;
                case 3:
                System.out.println("-------------------------------------------------------------");
                    System.out.print(nome + " Qual valor deseja transferir?: ");
                    valorTransferir = Double.parseDouble(scanner.nextLine());

                    if (valorTransferir > saldoInicial) {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println(nome + " você não tem saldo o suficiente para essa transeção");
                    }
                    else{
                        saldoInicial = saldoInicial - valorTransferir;
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Transferencia feita com sucesso");
                        System.out.println(nome + " O seu saldo Atual é: " + saldoInicial);
                        
                    }

                    break;
                case 4:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Escolheu uma opção inválida. Tente novamente.");
            }
        } while (opcoes != 4);
    }
}
