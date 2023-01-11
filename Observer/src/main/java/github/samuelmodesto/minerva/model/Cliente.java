package github.samuelmodesto.minerva.model;

public class Cliente {

    private String nome;
    private String email;
    private String numCel;

    public Cliente(String nome, String email, String numCel) {
        this.nome = nome;
        this.email = email;
        this.numCel = numCel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumCel() {
        return numCel;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }

}
