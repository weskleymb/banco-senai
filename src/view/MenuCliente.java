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
        builder.append("| 4 - RETORNAR     |\n");
        builder.append("|==================|\n");
        builder.append("Escolha uma opção: ");

        System.out.println(builder.toString());

        Scanner entrada = new Scanner(System.in);

        Integer escolha = entrada.nextInt();

        orquestrador(escolha);

    }

    private void orquestrador(Integer escolha) {
        switch (escolha) {
            case 1:
                cadastrar();
                break;
            case 3:
                buscarTodos();
                break;
            case 4:
                new MenuPrincipal().run();
                break;
        }
    }

    private void buscarTodos() {
        for (Cliente cliente : repository.listarTodos()) {
            System.out.println(cliente);
        }
        run();
    }

    private void cadastrar() {
        Cliente cliente = new Cliente();
        System.out.print("Informe o nome do Titular: ");
        cliente.setNome(entrada.nextLine());
        System.out.print("Informe o CPF: ");
        cliente.setCpf(entrada.nextLine());
        System.out.print("Informe seu endereço: ");
        cliente.setEndereco(entrada.nextLine());

        repository.salvar(cliente);
        run();
    }


}
