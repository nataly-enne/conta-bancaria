package banco;

import java.util.Comparator;

public class CompareByNameThenCpf implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria c1, ContaBancaria c2) {
        if(new CompareByName().compare(c1, c2) == 0){
            return new CompareByCpf().compare(c1, c2);
        }else{
            return c1.getNomeTitular().compareTo(c2.getNomeTitular());
        }
    }
}
