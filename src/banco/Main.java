package banco;

public class Main {

    public static void main(String[] args) {
//        ContaCorrente cc = new ContaCorrente(1254546, 10);
//        ContaPoupanca cp = new ContaPoupanca(1231545, 200);
        ContaBancaria ca;
        Banco b = new Banco();
        ca = b.criarConta("Nataly", "123");
        b.inserir(ca);

//        cc.depositar(200);
//        cp.depositar(150);
//
//        cc.sacar(50);
//        cp.sacar(300);
//
        Relatorio r = new Relatorio();
//
//        r.gerarRelatorio(cc);
//        r.gerarRelatorio(cp);
//
//        cc.transferir(100,cp);

        b.mostrarDados();
    }
}
