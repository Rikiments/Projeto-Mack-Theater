public class EntradaProfessor extends Entrada {
    public EntradaProfessor(int assento, double precoBase) {
        super(assento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase * 0.6; // 40% de desconto
    }
}
