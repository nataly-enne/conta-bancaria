package contas;

import bancos.Banco;
import interfaces.Imprimivel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {
    private double limite = 0;

    //Métodos especiais


    public ContaPoupanca() {
        super();
    }

    public double getLimite()   {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    //Métodos públicos
    public boolean sacar(double valor) {
        if (valor > getSaldo() + limite) {
            System.out.println("Valor excede limite da conta");
            return false;
        }

        setSaldo(getSaldo()-valor);
        System.out.println(valor+" sacado com sucesso");
        return true;
    }

    public boolean depositar(double valor) {
        setSaldo(getSaldo()+valor);
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
        System.out.println("Numero da conta: "+getConta()+"\nNome do titular: " + getNomeTitular() + "\nCpf do titular: " +
                getCpfTitular() + "\nSaldo: "+getSaldo()+"\nLimite: "+getLimite());
        System.out.println("Data de abertura: " + getDataAbertura());
        if(isAtiva()){
            System.out.println("Conta ativa");
        }else{
            System.out.println("Data de encerramento: " +  getDataEncerramento());
            System.out.println("Conta desativada");
        }
    }


    @Override
    public boolean inicializarConta(String nomeTitular, String cpfTitular, Banco banco) {
        Scanner scanner = new Scanner(System.in);
        int numeroDaConta = -1;
        double limite = 0;
        boolean possivelCriarConta = true;
        LocalDateTime data = LocalDateTime.now();
        String formatedDateTime;
        DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        formatedDateTime = data.format(dff);
        data.parse(formatedDateTime, dff);//TODO verificar se a formatação está funcionando

        System.out.println("Digite o número da conta: ");
        numeroDaConta = scanner.nextInt();
        if(banco.getContas().isEmpty()){
            possivelCriarConta = true;
        }else{
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

            System.out.println("Digite o limite:  ");
            limite = scanner.nextDouble();
            this.setLimite(limite);
            this.setAtiva(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean encerrarConta(String cpf) {
        if(this.isAtiva()){
            LocalDateTime data = LocalDateTime.now();
            String formatedDateTime;
            DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            formatedDateTime = data.format(dff);
            data.parse(formatedDateTime, dff);//TODO verificar se a formatação está funcionando
            this.setAtiva(false);
            this.setDataEncerramento(data);
            return true;
        }
        System.out.println("Conta já está inativa!");
        return false;
    }
}
