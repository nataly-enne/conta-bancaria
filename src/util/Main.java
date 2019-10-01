package util;

import bancos.Banco;
import compares.*;
import contas.*;
import interfaces.*;
import java.util.*;

/**
*
*
*
* @authors Nátaly Enne, Marcos Vinicio, Hilton Thallyson
*
*
*
**/

public class Main {
    public static void main(String[] args) {

        //Variáveis auxiliares
        List<ContaBancaria> contas;

        Relatorio r = new Relatorio();
        CompareByName compareByName = new CompareByName();
        CompareByActive compareByActive = new CompareByActive();
        CompareByCpf compareByCpf = new CompareByCpf();
        CompareByNameThenCpf compareByNameThenCpf = new CompareByNameThenCpf();
        CompareByCpfThenStatus compareByCpfThenStatus = new CompareByCpfThenStatus();
        CompareByNameThenStatus compareByNameThenStatus = new CompareByNameThenStatus();

        //Criando banco
        Banco banco = new Banco();

        //Criando contas
        // primeira conta => numero da conta = 1, João, cpf = 123
        // segunda conta => numero da conta = 11, João, cpf =123
        // terceira conta => n da conta = 2, Alberto, cpf =223
        // quarta conta => n da conta = 3, Alberto, cpf = 133
        // Quinta conta => n da conta = 4, Maria, cpf = 231
        // Sexta conta => n da conta = 5, Maria, cpf = 143

        for(int i = 0; i < 6; i++) {
            if(i%2 == 0){
                banco.criarContaBancaria(2);
            }
            else{
                banco.criarContaBancaria(1);
            }
        }

        //Operações
        banco.procurarConta(11).encerrarConta("123");
        banco.procurarConta(5).encerrarConta("231");

        //Ordenado por Nome
        System.out.println("======== Ordenado por nome ============");
        Collections.sort(banco.getContas(), compareByName);
        r.gerarRelatorio(banco);
        System.out.println("===============================\n");

        //Ordenado por Cpf
        System.out.println("========== Ordenado por cpf ===========");
        Collections.sort(banco.getContas(), compareByCpf);
        r.gerarRelatorio(banco);
        System.out.println("=============================\n");

        //Ordenado por Nome depois Cpf
        System.out.println("========== Ordenado por nome e depois cpf ==============");
        Collections.sort(banco.getContas(), compareByNameThenCpf);
        r.gerarRelatorio(banco);
        System.out.println("====================================\n");

        //Ordenado por atividade
        System.out.println("=========== Ordenado por atividade ===============");
        Collections.sort(banco.getContas(), compareByActive);
        r.gerarRelatorio(banco);
        System.out.println("================================\n");

        //Ordenado por nome e depois atividade
        System.out.println("=========== Ordenado por nome e depois atividade");
        Collections.sort(banco.getContas(), compareByNameThenStatus);
        r.gerarRelatorio(banco);
        System.out.println("===============================\n");

        //Ordenado por cpf e depois atividade
        System.out.println("========= Ordenado por cpf e depois atividade");
        Collections.sort(banco.getContas(), compareByCpfThenStatus);
        r.gerarRelatorio(banco);
        System.out.println("===============================\n");

        //Pesquisar cpf
        contas = banco.procurarContaPorCpf("123");
        System.out.println("========= Pesquisa por CPF:");
        for (ContaBancaria c: contas) {
            if(c instanceof ContaCorrente){
                r.gerarRelatorio((ContaCorrente) c);
            }
            else{
                r.gerarRelatorio((ContaPoupanca) c);
            }
        }

        System.out.println("===============================\n");

        //Pesquisar por nome do titular
        contas = banco.procurarContaPorTitular("Alberto");
        System.out.println("========= Pesquisa por Titular:");
        for (ContaBancaria c: contas) {
            if(c instanceof ContaCorrente){
                r.gerarRelatorio((ContaCorrente) c);
            }
            else{
                r.gerarRelatorio((ContaPoupanca) c);
            }
        }
        System.out.println("===============================\n");

    }

}
