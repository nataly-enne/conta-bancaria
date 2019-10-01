package contas;

import bancos.Banco;
import interfaces.Imprimivel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ContaCorrente extends ContaBancaria implements Imprimivel {
    private double taxaDeOperação = 5d;

    // Métodos especiais
    public ContaCorrente(){
        super();
    }

    public double getTaxaDeOperação() {
        return taxaDeOperação;
    }

    public void setTaxaDeOperação(double taxaDeOperação) {
        this.taxaDeOperação = taxaDeOperação;
    }

    // Métodos públicos
    public boolean sacar(double valor) {
        if (valor + taxaDeOperação > getSaldo()) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        setSaldo(getSaldo() - valor - taxaDeOperação);
        System.out.println("Valor de "+valor+" sacado com sucesso");
        return true;
    }

    public boolean depositar(double valor) {
        if (getSaldo() + valor < taxaDeOperação) {
            System.out.println("Depósito não realizado");
            return false;
        }

        setSaldo(getSaldo() + valor - taxaDeOperação);
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
        System.out.println("Numero da conta: " + getConta()+"\nNome do titular: " + getNomeTitular() + "\nCpf do titular: " +
                getCpfTitular() + "\nSaldo: "+getSaldo()+"\nTaxa de Operação: "+getTaxaDeOperação());


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatedDateTime = dtf.format(getDataAbertura());


        System.out.println("Data de abertura: " + formatedDateTime);
        if(isAtiva()){
            System.out.println("Conta ativa");
        }
        else{

            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formatedDateTime2 = dtf.format(getDataEncerramento());

            System.out.println("Data de encerramento: " +  formatedDateTime2);
            System.out.println("Conta desativada");
        }
    }

    @Override
    public boolean inicializarConta(String nomeTitular, String cpfTitular, Banco banco) {
        Scanner scanner = new Scanner(System.in);
        int numeroDaConta = -1;
        double taxaDeOperação = -1.0;
        boolean possivelCriarConta = true;
        int op = 2;

        LocalDateTime data = LocalDateTime.now();

        System.out.println("Digite o número da conta: ");
        numeroDaConta = scanner.nextInt();
        if(banco.getContas().isEmpty()){
            possivelCriarConta = true;
        }
        else{
            for (ContaBancaria c: banco.getContas()) {
                if(numeroDaConta == c.getConta()){
                    System.out.println("Já existe uma conta com esse número!");
                    possivelCriarConta = false;
                    break;
                }
            }
        }
        if(possivelCriarConta) {
            this.setNomeTitular(nomeTitular);
            this.setCpfTitular(cpfTitular);
            this.setDataAbertura(data);
            this.setConta(numeroDaConta);
            System.out.println("Digite a taxa de operação:  ");
            taxaDeOperação = scanner.nextDouble();
            this.setTaxaDeOperação(taxaDeOperação);
            this.setAtiva(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean encerrarConta(String cpf) {
        if(this.isAtiva()){
            LocalDateTime data = LocalDateTime.now();

            this.setAtiva(false);
            this.setDataEncerramento(data);
            return true;
        }
        System.out.println("Conta já está inativa!");
        return false;
    }

}
