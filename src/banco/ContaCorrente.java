package banco;

import java.time.LocalDateTime;

public class ContaCorrente extends ContaBancaria implements Imprimivel{
    private double taxaDeOperacao;

    public ContaCorrente(int numeroConta, double taxaDeOperacao, String nome, String cpf, LocalDateTime atual) {
        super(numeroConta, nome, cpf, atual);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public boolean sacar(double valor) {
        if (valor + taxaDeOperacao > getSaldoConta()) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        setSaldoConta(getSaldoConta() - valor - taxaDeOperacao);
        System.out.println("Valor de "+valor+" sacado com sucesso");
        return true;
    }

    public boolean depositar(double valor) {
        if (getSaldoConta() + valor < taxaDeOperacao) {
            System.out.println("Depósito não realizado");
            return false;
        }

        setSaldoConta(getSaldoConta() + valor - taxaDeOperacao);
        System.out.println(valor+" depositado com sucesso");
        return true;
    }

    public boolean transferir(double valor, ContaBancaria destino) {
        if (destino == null) {
            System.out.println("Conta inexistente");
            return false;
        }

        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência realizada");
            return true;
        }

        return false;

    }

    @Override
    public void mostrarDados() {
        System.out.println("Numero da conta: "+getNumeroConta()+"\nSaldo: "+getSaldoConta()+"\nTaxa de Operação: "+getTaxaDeOperacao());
    }
}
