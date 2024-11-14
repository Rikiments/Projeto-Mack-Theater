public abstract class Entrada {
    protected int assento;
    protected double precoBase;

    public Entrada(int assento, double precoBase) {
        this.assento = assento;
        this.precoBase = precoBase;
    }

    public abstract double calculaValor();
}
