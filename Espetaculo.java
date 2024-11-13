import java.util.ArrayList;

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
    }

    public void apresentaAssentos() {
        System.out.println("||| Assentos Disponíveis |||");

        for (int i = 0; i < 5; i++) {  // Dividir em 5 linhas de 10 assentos cada
            for (int j = 0; j < 10; j++) {
                int assentoNum = 50 - (i * 10 + j);  // Calcula o número do assento de 50 a 1
                if (assentos[assentoNum - 1]) {       // Verifica se o assento está ocupado
                    System.out.print("XX ");
                } else {
                    System.out.printf("%02d ", assentoNum);
                }
            }
            System.out.println();
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        int indice = 50 - assento;  // Converte o número do assento para o índice correto
        if (indice < 0 || indice >= assentos.length || assentos[indice]) {
            System.out.println("Assento já ocupado ou inválido!");
            return null;
        }
        marcarAssento(indice);
        switch (tipo) {
            case 1: return new EntradaInteira(assento, preco);
            case 2: return new EntradaMeia(assento, preco);
            case 3: return new EntradaProfessor(assento, preco);
            default: return null;
        }
    }

    public void marcarAssento(int assento) {
        assentos[assento] = true;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return nome + " - " + data + " - " + hora + " R$ " + String.format("%.2f", preco);
    }
    // metodos getters and setters 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public boolean[] getAssentos() {
		return assentos;
	}

	public void setAssentos(boolean[] assentos) {
		this.assentos = assentos;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
