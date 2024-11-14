import java.util.ArrayList;

public class Pedido {
	private ArrayList<Entrada> entradas = new ArrayList<>(); // Lista que guarda todas as entradas (ingressos) de um pedido específico.


    public Pedido() {} // construtor padrao 

    public void adicionaEntrada(Entrada entrada) { // Adiciona uma entrada (ingresso) ao pedido.
        entradas.add(entrada);
    }

    public double calculaValorTotal() { //  Calcula o valor total do pedido, somando o valor de todas as entra
        double total = 0;
        for (Entrada entrada : entradas) { // Percorre cada entrada na lista e chama 'calculaValor' para obter o preço
            total += entrada.calculaValor();
        }
        return total;
    }
	
	
}
