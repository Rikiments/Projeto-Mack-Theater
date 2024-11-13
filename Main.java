import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Teatro teatro = new Teatro();
        ArrayList<Cliente> clientes = new ArrayList<>();

        while (true) {
            System.out.println(menu.telaInicial());
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            switch (opcao) {
                case 1:
                    // Cadastrar Espetáculo
                    System.out.println("Nome do Espetáculo:");
                    String nome = scanner.nextLine();
                    System.out.println("Data do Espetáculo (DD/MM/AAAA):");
                    String data = scanner.nextLine();
                    System.out.println("Hora do Espetáculo (HH:MM):");
                    String hora = scanner.nextLine();
                    System.out.println("Preço do Ingresso:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();  // Limpa o buffer

                    Espetaculo espetaculo = new Espetaculo(nome, data, hora, preco);
                    teatro.adicionarEspetaculo(espetaculo);
                    System.out.println("Espetáculo cadastrado com sucesso!");
                    break;

                case 2:
                    // Cadastrar Cliente
                    System.out.println("Nome do Cliente:");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("CPF do Cliente:");
                    String cpf = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, cpf);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 3:
                    // Compra de Entradas
                    teatro.apresentaEspetaculos();

                    System.out.print("Selecione um espetáculo: ");
                    int espetaculoNumero = scanner.nextInt();
                    scanner.nextLine();  // Limpa o buffer

                    teatro.selecionaEspetaculo(espetaculoNumero);
                    teatro.novaCompra();

                    // Apresenta os assentos disponíveis para o espetáculo selecionado
                    teatro.apresentaAssentosEspetaculo();

                    System.out.print("Selecione um assento: ");
                    int assento = scanner.nextInt();

                    System.out.println("Selecione o tipo de entrada:");
                    System.out.println("1 - Entrada Inteira");
                    System.out.println("2 - Entrada Meia  50% do valor da entrada");
                    System.out.println("3 - Entrada Professor 40% do valor da entrada");
                    int tipoEntrada = scanner.nextInt();

                    teatro.novaEntrada(tipoEntrada, assento);

                    System.out.println("Digite o CPF do cliente para associar ao pedido:");
                    scanner.nextLine();  // Limpa o buffer
                    String cpfCliente = scanner.nextLine();

                    double total = teatro.finalizaCompra(cpfCliente);
                    System.out.printf("Compra finalizada! Valor total: R$ %.2f%n", total);
                    break;

                case 4:
                    // Sair
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
