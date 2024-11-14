public class EntradaInteira extends Entrada {
    public EntradaInteira(int assento, double precoBase) {
        super(assento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase; // Preço integral
    }
}
