package compares;

import contas.ContaBancaria;

import java.util.Comparator;

public class CompareByNameThenStatus implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        CompareByName name = new CompareByName();
        CompareByActive active = new CompareByActive();

        if(name.compare(c1, c2) == 0){
            return active.compare(c1, c2);
        }
        else{
            return name.compare(c1, c2);
        }
    }
}
