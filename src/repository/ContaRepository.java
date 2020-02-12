package repository;

import model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepository extends AbstractRepository<Conta> {

    private static List<Conta> contas = new ArrayList<>();

    public ContaRepository() {
        super.setLista(contas);
    }

}
