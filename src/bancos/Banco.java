package bancos;

import contas.*;
import interfaces.Imprimivel;
import java.util.*;

public class Banco implements Imprimivel {
    private ArrayList<ContaBancaria> contas;


    public Banco() {
        contas = new ArrayList<>();
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

        System.out.println("Remoção não realizada!");
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
            }
            else {
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
        }
        else if(tipoConta == 2){
            ContaPoupanca cp = new ContaPoupanca();
            if(cp.inicializarConta(nome, cpf, this)){
                this.inserir(cp);
            }
        }
        else{
            System.out.println("Opção inexistente!");
        }
    }

    public List<ContaBancaria> procurarContaPorTitular(String nome) {

        Iterator<ContaBancaria> it  =  contas.iterator();

        // vai armazenar as contas com nomes iguais aqui
        ArrayList<ContaBancaria> armazenar = new ArrayList<ContaBancaria>();

        while (it.hasNext()){
                // dando split no nome do titular para pegar apenas o primeiro nome
                String[] splited_nome = it.next().getNomeTitular().split(" ");

                if(splited_nome[0].equals(nome)){
                        armazenar.add(it.next());
                }
        }

        return armazenar;
    }

    public List<ContaBancaria> procurarContaPorCpf(String cpf) {

        Iterator<ContaBancaria> it  = contas.iterator();

        // vai armazenar as contas com o mesmo cpf aqui
        ArrayList<ContaBancaria> armazenar = new ArrayList<ContaBancaria>();

        while (it.hasNext()){
            if(it.next().getCpfTitular().equals(cpf)){
                armazenar.add(it.next());
            }
        }
        return armazenar;
    }
}