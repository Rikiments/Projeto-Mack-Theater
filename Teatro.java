import java.util.ArrayList;
	class Teatro {
	
    private ArrayList<Espetaculo> espetaculos; // Lista de espetáculos disponíveis
    private Pedido carrinho = null;
    private Espetaculo espetaculoSelecionado = null;

    public Teatro() {
        espetaculos = new ArrayList<>();
    }

    public void adicionarEspetaculo(Espetaculo espetaculo) {
        espetaculos.add(espetaculo);
    }

    public void novaCompra() {
        carrinho = new Pedido();
    }

    public void apresentaEspetaculos() {
        if (espetaculos.isEmpty()) { //verifica se a lista de espetaculo esta vazia 
            System.out.println("Nenhum espetáculo disponível.");
            return;
        }
        
        //loop que percorre cada espetaculo na lista 
        System.out.println("\n--- Espetáculos Disponíveis ---");
        for (int i = 0; i < espetaculos.size(); i++) {
            Espetaculo esp = espetaculos.get(i); // obtem o espetaculo atual 
            System.out.printf("%d) %s - %s %s R$ %.2f%n", i + 1, esp.getNome(), esp.getData(), esp.getHora(), esp.getPreco()); // exibe a informação do espetaculo
        }
    }

    public void selecionaEspetaculo(int numero) { /// Verifica se o número fornecido é valido 
        if (numero > 0 && numero <= espetaculos.size()) {
            espetaculoSelecionado = espetaculos.get(numero - 1); //Se o número for válido, seleciona o espetáculo correspondente
            System.out.println("Espetáculo selecionado: " + espetaculoSelecionado.getNome());
        } else {
            System.out.println("Número de espetáculo inválido.");
        }
    }

    public void apresentaAssentosEspetaculo() {
        if (espetaculoSelecionado != null) {
            System.out.println("||| Assentos Disponíveis |||"); //Se um espetáculo foi selecionado, exibe uma mensagem indicando que os assentos disponíveis serão mostrados
            espetaculoSelecionado.apresentaAssentos(); //// Chama o método 'apresentaAssentos()' do espetáculo selecionado para exibir o estado atual dos assentos
        } else {
            System.out.println("Nenhum espetáculo selecionado.");
        }
    }

    public void novaEntrada(int tipo, int assento) {
        if (espetaculoSelecionado != null && carrinho != null) {
            Entrada entrada = espetaculoSelecionado.novaEntrada(tipo, assento);
            if (entrada != null) {
                carrinho.adicionaEntrada(entrada);
                System.out.println("Entrada adicionada ao carrinho.");
            }
        } else {
            System.out.println("Selecione um espetáculo e inicie uma compra primeiro.");
        }
    }

    public double finalizaCompra(String cpf) {
        if (carrinho != null) { /// Verifica se há um espetáculo selecionado e se um carrinho de compras foi iniciado.
            double total = carrinho.calculaValorTotal();// // O método 'novaEntrada' da classe 'Espetaculo' verifica a disponibilidade do assento.
            return total;
        }
        return 0;
    }
}
