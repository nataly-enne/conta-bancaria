package banco;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void iniciar() {
        Banco b = new Banco();
        int op = 5;
        int tipoConta;
        int tipoPesquisa;
        List<ContaBancaria> contas;

        Scanner in = new Scanner(System.in);
        System.out.println("====================Bem-vindo(a) ao Banco B=========================");
        do {
            System.out.println(">>>>>>>>>>Por favor, selecione a operação que deseja realizar através das opções abaixo: ");
            System.out.println("(1) - Criar conta\n(2)- Selecionar conta\n(3)-Remover conta\n(4)-Gerar relatório\n(5)-Finalizar");
            op = in.nextInt();
            switch (op){
                case 1:
                    System.out.println("===============Criação de conta=================");
                    System.out.println("\n Digite o tipo de conta a ser criada:\n(1) - Conta corrente\n(2) - Conta poupança");
                    tipoConta = in.nextInt();
                    b.criarContaBancaria(tipoConta);
                case 2:
                    System.out.println("================Selecionar conta=================");
                    System.out.println("Selecione a opção para pesquisar conta:\n(1) - Pesquisar por nome do titular\n(2) - Pesquisar por cpf do titular\n(3) - Pesquisar por número da conta");
                    tipoPesquisa = in.nextInt();
                    switch (tipoPesquisa){
                        case 1:
                            String nome;
                            System.out.println("Digite o nome do titular:");
                            nome = in.nextLine();
                            b.procurarContaPorTitular(nome);//TODO implementar
                            break;
                        case 2:
                            String cpf;
                            System.out.println("Digite o cpf do titular:");
                            cpf = in.nextLine();
                            b.procurarContaPorCpf(cpf);//TODO implementar
                            break;
                        case 3:
                            int numeroConta;
                            System.out.println("Digite o número da conta");
                            numeroConta = in.nextInt();
                            b.procurarConta(numeroConta);
                            break;
                        default:
                            System.out.println("Opção inexistente");
                    }
            }
        }while(op != 5);
    }
}
