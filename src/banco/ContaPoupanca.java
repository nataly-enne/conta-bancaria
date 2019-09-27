package banco;

import java.time.LocalDateTime;

public class ContaPoupanca extends ContaBancaria implements Imprimivel  {
    private double limite;

    public ContaPoupanca(int numeroConta, double limite, String nomeT, String cpf, LocalDateTime atual){
        super(numeroConta, nomeT, cpf, atual);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public boolean sacar(double valor) {
        if (valor > getSaldoConta() + limite) {
            System.out.println("Valor excede limite da conta");
            return false;
        }

        setSaldoConta(getSaldoConta()-valor);
        System.out.println(valor+" sacado com sucesso");
        return true;
    }

    public boolean depositar(double valor) {
        setSaldoConta(getSaldoConta()+valor);
        System.out.println(valor+"Depositado com sucesso");
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
        System.out.println("Numero da conta: "+getNumeroConta()+"\nSaldo: "+getSaldoConta()+"\nLimite: "+getLimite());
    }
}
