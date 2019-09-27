package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ContaBancaria {
    private int numeroConta;
    private double saldoConta;
    private String nomeTitutlar, CPFTitular;
    private LocalDateTime dataCadastro, dataEncerramento;
    private boolean ativada;

    public ContaBancaria(int numeroConta, String nome, String cpf, LocalDateTime atual) {
        this.numeroConta = numeroConta;
        this.saldoConta = 0;
        this.nomeTitutlar = nome;
        this.CPFTitular = cpf;
        this.dataCadastro = atual;
        this.dataEncerramento = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        dtf.format(dataCadastro);

        assert false;
        dtf.format(dataEncerramento);
    }

    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);
    public abstract boolean transferir(double valor, ContaBancaria destino);


        public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    protected void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
}
