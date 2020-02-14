package view;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import repository.ClienteRepository;
import repository.ContaRepository;

import java.util.Scanner;

public class MenuConta {

    private Scanner entrada = new Scanner(System.in);
    private ContaRepository repository = new ContaRepository();
    private ClienteRepository clienteRepository = new ClienteRepository();

    public void run() {

        StringBuilder builder = new StringBuilder();

        builder.append("|====MENU CONTA====|\n");
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
                cadastrarConta();
                break;
            case 3:
                buscarTodasContas();
                break;
            case 5:
                new MenuPrincipal().run();
                break;
        }
        run();
    }

    private void cadastrarConta() {
        System.out.print("Informe o ID do cliente: ");
        Cliente titular = clienteRepository.listarUm(Integer.parseInt(entrada.nextLine()));
        if (titular == null) {
            System.out.println("Cliente não encontrado!");
            System.out.println("REPITA A OPERAÇÃO");
        } else {
            System.out.print("Informe o saldo inicial: ");
            Double saldo = Double.parseDouble(entrada.nextLine());
            criarConta(titular, saldo);
        }
    }

    private void criarConta(Cliente titular, Double saldo) {
        ContaCorrente conta = new ContaCorrente(titular, saldo);
        repository.salvar(conta);
        System.out.println("Conta salva com SUCESSO!!!");
    }


    private void buscarTodasContas() {
        for (Conta conta : repository.listarTodos()) {
            System.out.println(conta);
        }
    }

}
