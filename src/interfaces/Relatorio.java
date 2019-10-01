package interfaces;

import interfaces.Imprimivel;

public class Relatorio {
    public void gerarRelatorio(Imprimivel imprimivel) {
        imprimivel.mostrarDados();
    }
}
