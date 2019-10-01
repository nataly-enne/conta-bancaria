package compares;

import contas.ContaBancaria;

import java.util.Comparator;

public class CompareByCpf implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        return c1.getCpfTitular().compareTo(c2.getCpfTitular());
    }
}
