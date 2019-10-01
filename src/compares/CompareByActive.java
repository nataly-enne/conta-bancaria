package compares;

import contas.ContaBancaria;

import java.util.Comparator;

public class CompareByActive implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        if(c1.isAtiva() && c2.isAtiva()){
            return 0;
        }else if(c1.isAtiva() && !c2.isAtiva()){
            return -1;
        }else{
            return 1;
        }
    }
}
