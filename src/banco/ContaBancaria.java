package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ContaBancaria {
    private int conta;
    private double saldo;
    private String nomeTitular, cpfTitular;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private boolean ativa;

    //Métodos Especiais

    public ContaBancaria() {
        this.conta = -1;
        this.saldo = 0;
        this.nomeTitular = "";
        this.cpfTitular = "";
        this.ativa = false;
        this.dataAbertura = null;
        this.dataEncerramento = null;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    //Métodos Públicos
    public abstract boolean sacar(double value);
    public abstract boolean depositar (double value);
    public abstract boolean transferir(double value, ContaBancaria conta);
    public abstract boolean inicializarConta(String nomeTitular, String cpfTitular, Banco banco);
    public abstract boolean encerrarConta(String cpf);


}
