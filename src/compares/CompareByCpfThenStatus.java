package compares;

import contas.ContaBancaria;

import java.util.Comparator;

public class CompareByCpfThenStatus implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        CompareByCpf cpf = new CompareByCpf();
        CompareByActive active = new CompareByActive();

        if(cpf.compare(c1, c2) == 0){
            return active.compare(c1, c2);
        }
        else{
            return cpf.compare(c1, c2);
        }
    }
}
