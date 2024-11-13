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
        if (espetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo disponível.");
            return;
        }

        System.out.println("\n--- Espetáculos Disponíveis ---");
        for (int i = 0; i < espetaculos.size(); i++) {
            Espetaculo esp = espetaculos.get(i);
            System.out.printf("%d) %s - %s %s R$ %.2f%n", i + 1, esp.getNome(), esp.getData(), esp.getHora(), esp.getPreco());
        }
    }

    public void selecionaEspetaculo(int numero) {
        if (numero > 0 && numero <= espetaculos.size()) {
            espetaculoSelecionado = espetaculos.get(numero - 1);
            System.out.println("Espetáculo selecionado: " + espetaculoSelecionado.getNome());
        } else {
            System.out.println("Número de espetáculo inválido.");
        }
    }

    public void apresentaAssentosEspetaculo() {
        if (espetaculoSelecionado != null) {
            System.out.println("||| Assentos Disponíveis |||");
            espetaculoSelecionado.apresentaAssentos();
        } else {
            System.out.println("Nenhum espetáculo selecionado.");
        }
    }

    public void novaEntrada(int tipo, int assento) {
        if (espetaculoSelecionado != null && carrinho != null) {
            Entrada entrada = espetaculoSelecionado.novaEntrada(tipo, assento);
            if (entrada != null) {
                carrinho.adicionaEntrada(entrada);
            }
        } else {
            System.out.println("Selecione um espetáculo e inicie uma compra primeiro.");
        }
    }

    public double finalizaCompra(String cpf) {
        if (carrinho != null) {
            double total = carrinho.calculaValorTotal();
            // Aqui, o cliente seria associado ao pedido
            return total;
        }
        return 0;
    }
}
