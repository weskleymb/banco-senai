package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository extends AbstractRepository<Cliente> {

    private static List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        super.setLista(clientes);
    }

}
