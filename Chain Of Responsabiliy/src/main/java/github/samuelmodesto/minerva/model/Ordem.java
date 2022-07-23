package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Ordem {

    private TipoDeOrdem tipoDeOrdem;

    public Ordem(TipoDeOrdem tipoDeOrdem) {
        this.tipoDeOrdem = tipoDeOrdem;
    }

    public TipoDeOrdem getTipoDeOrdem() {
        return tipoDeOrdem;
    }

    public void setTipoDeOrdem(TipoDeOrdem tipoDeOrdem) {
        this.tipoDeOrdem = tipoDeOrdem;
    }
}
