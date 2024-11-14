
public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];
    
    //metodo construtor 
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
    int totalAssentos = 50; // Total de assentos disponíveis (5 filas x 10 colunas)
    
    // Quando o número do assento não está entre 1 e 50, indica inválido
    if (assento < 1 || assento > totalAssentos) {
        System.out.println("Assento inválido. Escolha um número entre 1 e 50.");
        return null;
    }

    // Verifica se o assento está ocupado
    if (assentos[assento - 1]) {
        System.out.println("Assento já ocupado.");
        return null;
    }

    // Marca o assento como ocupado
    assentos[assento - 1] = true;

    // Cria a nova entrada com base no tipo selecionado
    Entrada entrada = null;
    switch (tipo) {
        case 1:
            entrada = new EntradaInteira(assento, preco); // Entrada inteira
            break;
        case 2:
            entrada = new EntradaMeia(assento, preco); // Entrada meia
            break;
        case 3:
            entrada = new EntradaProfessor(assento, preco); // Entrada com desconto para professor
            break;
        default:
            System.out.println("Tipo de entrada inválido.");
            return null;
    }
    
    return entrada;
}



    public void marcarAssento(int assento) {
        assentos[assento] = true;
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
	
	public double getPreco() {
        return preco;
    }

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
