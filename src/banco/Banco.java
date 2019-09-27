package banco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco implements Imprimivel {
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<ContaBancaria>();
    }

    public boolean inserir(ContaBancaria conta) {
        if (contas.contains(conta)) {
            System.out.println("Conta já existe");
            return false;
        }

        contas.add(conta);
        System.out.println("Conta criada");
        return true;
    }

    public boolean remover(ContaBancaria conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            System.out.println("Conta removida");
            return true;
        }

        System.out.println("Deu merda!");
        return false;
    }

    public ContaBancaria procurarConta(int numeroConta) {
        for (ContaBancaria c : contas) {
            if (c.getNumeroConta() == numeroConta) {
                return c;
            }
        }

        return null;
    }

    @Override
    public void mostrarDados() {

        for (ContaBancaria c : contas) {
            if (c instanceof ContaPoupanca) {
                ((ContaPoupanca) c).mostrarDados();
            } else {
                ((ContaCorrente) c).mostrarDados();
            }
        }
    }

    public ContaBancaria criarConta(String nomeTitular, String CPFTitular){
        int tipoConta = -1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual tipo da conta? 1 - Conta Poupança 2 - Conta Corrente");

        tipoConta = scanner.nextInt();

        if(tipoConta == 1){
            int numeroConta;
            double limite;

            System.out.println("Digite o número da conta:");
            numeroConta = scanner.nextInt();

            System.out.println("Digite o limite da conta:");
            limite = scanner.nextDouble();

            ContaBancaria ca = new ContaPoupanca(numeroConta, limite, nomeTitular, CPFTitular, LocalDateTime.now());
            return ca;
        }
        else if(tipoConta == 2){
            int numeroConta;
            double taxaOperacao;

            System.out.println("Digite o número da conta:");
            numeroConta = scanner.nextInt();

            System.out.println("Digite o taxaOperacao da conta:");
            taxaOperacao = scanner.nextDouble();

            ContaBancaria ca = new ContaCorrente(numeroConta, taxaOperacao, nomeTitular, CPFTitular, LocalDateTime.now());
            return ca;
        }
        else{
            return null;
        }

    }
    public void encerrarConta(String CPFTitular){
        return ;
    }
}