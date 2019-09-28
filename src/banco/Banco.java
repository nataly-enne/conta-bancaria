package banco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco implements Imprimivel {
    private ArrayList<ContaBancaria> contas;


    public Banco() {
        contas = new ArrayList<ContaBancaria>();
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
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
            if (c.getConta() == numeroConta) {
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


    public void criarContaBancaria(int tipoConta) {
        Scanner in = new Scanner(System.in);
        String nome, cpf;
        System.out.println("Digite o nome do titular da conta: ");
        nome = in.nextLine();
        System.out.println("Digite o cpf do titular: ");
        cpf = in.nextLine();
        if(tipoConta == 1){
            ContaCorrente cc = new ContaCorrente();
            if( cc.inicializarConta(nome, cpf, this)) {
                this.inserir(cc);
            }
        }else if(tipoConta == 2){
            ContaPoupanca cp = new ContaPoupanca();
            if(cp.inicializarConta(nome, cpf, this)){
                this.inserir(cp);
            }
        }else{
            System.out.println("Opção inexistente!");
        }
    }

    //TODO implementar métodos
//    public List<ContaBancaria> procurarContaPorTitular(String nome) {
//
//    }
//
//    public List<ContaBancaria> procurarContaPorCpf(String cpf) {
//        for (ContaBancaria c: this) {
//            if(c.getCpfTitular().equals(cpf)){
//                c.toString();
//            }
//        }
//    }
}