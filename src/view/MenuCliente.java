package view;

import model.Cliente;
import repository.ClienteRepository;

import java.util.Scanner;

public class MenuCliente {

    private Scanner entrada = new Scanner(System.in);
    private ClienteRepository repository = new ClienteRepository();

    public void run() {

        StringBuilder builder = new StringBuilder();

        builder.append("|===MENU CLIENTE===|\n");
        builder.append("| 1 - Cadastrar    |\n");
        builder.append("| 2 - Buscar       |\n");
        builder.append("| 3 - Buscar Todos |\n");
        builder.append("| 4 - Editar       |\n");
        builder.append("| 5 - RETORNAR     |\n");
        builder.append("|==================|\n");
        builder.append("Escolha uma opção: ");

        System.out.println(builder.toString());

        Integer escolha = Integer.parseInt(entrada.nextLine());

        orquestrador(escolha);

    }

    private void orquestrador(Integer escolha) {
        switch (escolha) {
            case 1:
                cadastrar();
                break;
            case 2:
                buscarCliente();
                break;
            case 3:
                buscarTodos();
                break;
            case 4:
                editarCliente();
                break;
            case 5:
                new MenuPrincipal().run();
                break;
        }
        run();
    }

    private void editarCliente() {
        System.out.println("Informe o ID do cliente desejado: ");
        Cliente cliente = repository.listarUm(Integer.parseInt(entrada.nextLine()));
        if (cliente == null) {
            System.out.println("Cliente não encontrado");
        } else {
            edita(cliente);
        }
    }

    private void edita(Cliente cliente) {
        Character resposta;
        System.out.println("Deseja alterar o nome " + cliente.getNome().toUpperCase() + "? ");
        resposta = entrada.nextLine().toLowerCase().charAt(0);
        if (resposta.equals('s')) {
            System.out.println("Informe o novo nome: ");
            cliente.setNome(entrada.nextLine());
        }
        System.out.println("Deseja alterar o CPF " + cliente.getCpf().toUpperCase() + "? ");
        resposta = entrada.nextLine().toLowerCase().charAt(0);
        if (resposta.equals('s')) {
            System.out.println("Informe o novo CPF: ");
            cliente.setCpf(entrada.nextLine());
        }
        repository.editar(cliente);
    }

    private void buscarCliente() {
        System.out.println("Informe o ID do cliente desejado: ");
        Cliente cliente = repository.listarUm(Integer.parseInt(entrada.nextLine()));
        if (cliente == null) {
            System.out.println("Cliente não encontrado");
        } else {
            System.out.println(cliente);
        }
    }

    private void buscarTodos() {
        for (Cliente cliente : repository.listarTodos()) {
            System.out.println(cliente);
        }
    }

    private void cadastrar() {
        Cliente cliente = new Cliente();
        System.out.println("Informe o nome do Titular: ");
        cliente.setNome(entrada.nextLine());
        System.out.println("Informe o CPF: ");
        cliente.setCpf(entrada.nextLine());
        System.out.println("Informe seu endereço: ");
        cliente.setEndereco(entrada.nextLine());

        repository.salvar(cliente);
    }


}
