package github.samuelmodesto.minerva.model;

public abstract class CafeTemplate {

    public void prepararCafe(){
        ferverAgua();
        adicionarLeite();
        adicionarAcucar();
        adicionarTipoCafe();
    }

    protected void ferverAgua(){
        System.out.println("Agua fervida!");
    }
    protected void adicionarLeite(){
        System.out.println("Leite adicionado");
    }
    protected void adicionarAcucar() {
        System.out.println("Açucar adicionado");
    }
    protected abstract void adicionarTipoCafe();
}
