package banco;

import java.util.Comparator;

public class CompareByName implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        return c1.getNomeTitular().compareTo(c2.getNomeTitular());
    }
}
