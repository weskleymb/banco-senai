package view;

import model.Cliente;
import repository.ClienteRepository;

public class Principal {

    public static void main(String[] args) {

        carregaClientes();
        new MenuPrincipal().run();

    }

    private static void carregaClientes() {

        ClienteRepository repository = new ClienteRepository();

        Cliente emanuel = new Cliente();
        emanuel.setNome("emanuel");
        emanuel.setCpf("123123123");

        repository.salvar(emanuel);

        Cliente paulo = new Cliente();
        paulo.setNome("paulo");
        paulo.setCpf("999888777");

        repository.salvar(paulo);

    }

}
