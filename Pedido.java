import java.util.ArrayList;

public class Pedido {
	private ArrayList<Entrada> entradas = new ArrayList<>();

    public Pedido() {}

    public void adicionaEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public double calculaValorTotal() {
        double total = 0;
        for (Entrada entrada : entradas) {
            total += entrada.calculaValor();
        }
        return total;
    }
	
	
}
