//package util;
//
//import bancos.Banco;
//import interfaces.Relatorio;
//import contas.ContaBancaria;
//import contas.ContaCorrente;
//import contas.ContaPoupanca;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class Menu {
//    public void iniciar() {
//        Banco b = new Banco();
//        int op = 5;
//        int tipoConta;
//        int tipoPesquisa;
//        List<ContaBancaria> contas;
//        ContaBancaria cb = new ContaCorrente();
//
//
//        Scanner in = new Scanner(System.in);
//        System.out.println("==================== Bem-vindo(a) ao Banco B =========================");
//        do {
//            System.out.println(">>>>>>>>>>Por favor, selecione a operação que deseja realizar através das opções abaixo: ");
//            System.out.println("(1) - Criar conta\n(2)- Selecionar conta\n(3)-Remover conta\n(4)-Gerar relatório\n(5)-Finalizar");
//            op = in.nextInt();
//            switch (op){
//                case 1:
//                    System.out.println("=============== Criação de conta =================");
//                    System.out.println("\n Digite o tipo de conta a ser criada:\n(1) - Conta corrente\n(2) - Conta poupança");
//                    tipoConta = in.nextInt();
//                    b.criarContaBancaria(tipoConta);
//                case 2:
//                    System.out.println("================ Selecionar cont =================");
//                    System.out.println("Selecione a opção para pesquisar conta:\n(1) - Pesquisar por nome do titular\n(2) - Pesquisar por cpf do titular\n(3) - Pesquisar por número da conta");
//                    tipoPesquisa = in.nextInt();
//                    switch (tipoPesquisa){
//                        case 1:
//                            String nome;
//                            System.out.println("Digite o nome do titular:");
//                            nome = in.nextLine();
//                            contas = b.procurarContaPorTitular(nome);//TODO implementar
//                            break;
//                        case 2:
//                            String cpf;
//                            System.out.println("Digite o cpf do titular:");
//                            cpf = in.nextLine();
//                            contas = b.procurarContaPorCpf(cpf);//TODO implementar
//                            Relatorio r = new Relatorio();
//                            for (ContaBancaria c: contas) {
//                                if(c instanceof ContaPoupanca){
//                                    r.gerarRelatorio((ContaPoupanca) c);
//                                }else {
//                                    r.gerarRelatorio((ContaCorrente) c);
//                                }
//                            }
//                            break;
//                        case 3:
//                            int numeroConta;
//                            System.out.println("Digite o número da conta");
//                            numeroConta = in.nextInt();
//                            cb = b.procurarConta(numeroConta);
//                            break;
//                        default:
//                            System.out.println("Opção inexistente");
//                    }
//                    System.out.println("Selecione a operação que deseja realizar:\n(1) - Sacar\n(2) - Depositar\n " +
//                            "(3) - Transferir (4) - Mostrar dados da conta\n(5) - Voltar ao menu anterior");
//                    int opção = -1;
//                    opção = in.nextInt();
//                    switch(opção){
//                        case 1:
//                            System.out.println("Digite o valor a ser sacado: ");
//                            double valor;
//                            valor  = in.nextDouble();
//                            cb.sacar(valor);
//                            break;
//                        case 2:
//                            System.out.println("Digite o valor a ser depositado: ");
//                            valor = in.nextDouble();
//                            cb.depositar(valor);
//                            break;
//                        case 3:
//                            System.out.println("Digite o valor a ser transferido: ");
//                            valor = in.nextDouble();
//                            System.out.println("Digite o número da conta de destino: ");
//                            int numeroConta;
//                            numeroConta = in.nextInt();
//                            if(b.procurarConta(numeroConta) != null){
//                                cb.transferir(valor, b.procurarConta(numeroConta));
//                            }else{
//                                System.out.println("Conta destino não existe!");
//                            }
//                            break;
//                        case 4:
//                            System.out.println(">>>>>>> Status da conta <<<<<<<<<");
//                            Relatorio r = new Relatorio();
//                            if(cb instanceof ContaPoupanca){
//                                r.gerarRelatorio((ContaPoupanca) cb);
//                            }else{
//                                r.gerarRelatorio((ContaCorrente) cb);
//                            }
//                            break;
//                        case 5:
//                            System.out.println(">>>>>>>> Voltando ao menu anterior <<<<<<<<<<<<");
//                            break;
//                        default:
//                            System.out.println("Opção inexistente");
//                    }
//                case 3:
//                    System.out.println("========== Remoção de conta ============");
//                    System.out.println("Digite o número da conta que deseja deletar:");
//                    int numeroConta;
//                    ContaBancaria c;
//                    numeroConta = in.nextInt();
//
//                    c = b.procurarConta(numeroConta);
//
//                    if(c != null){
//                        c.encerrarConta(c.getCpfTitular());
//                        b.remover(c);
//                    }
//                    break;
//                case 4:
//                    System.out.println("============ Relatório de contas ===========");
//                    Relatorio r = new Relatorio();
//                    r.gerarRelatorio(b);
//                    break;
//                case 5:
//                    System.out.println("============= Finalizando menu ============");
//                    break;
//                default:
//                    System.out.println("Opção inexistente!");
//            }
//        }while(op != 5);
//    }
//}
