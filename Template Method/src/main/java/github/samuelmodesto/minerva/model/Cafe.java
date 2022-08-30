package github.samuelmodesto.minerva.model;

public abstract class Cafe {

    public void prepararCafeTemplate() {
        ferverAgua();
        adicionarLeite();
        adicionarAcucar();
        adicionarTipoCafe();
    }

    private void ferverAgua() {
        System.out.println("Agua fervida!");
    }

    private void adicionarLeite() {
        System.out.println("Leite adicionado");
    }

    private void adicionarAcucar() {
        System.out.println("Açucar adicionado");
    }

    protected abstract void adicionarTipoCafe();
}
