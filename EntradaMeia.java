public class EntradaMeia extends Entrada {
    public EntradaMeia(int assento, double precoBase) {
        super(assento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase * 0.5; // 50% de desconto
    }
}
