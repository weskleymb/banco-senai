package view;

import java.util.Scanner;

public class MenuPrincipal {

    public void run() {

        StringBuilder builder = new StringBuilder();

        builder.append("|===MENU PRINCIPAL===|\n");
        builder.append("| 1 - Clientes       |\n");
        builder.append("| 2 - Contas         |\n");
        builder.append("| 3 - SAIR           |\n");
        builder.append("|====================|\n");
        builder.append("Escolha uma opção: ");

        System.out.println(builder.toString());

        Scanner entrada = new Scanner(System.in);

        Integer escolha = entrada.nextInt();

        chamarSubMenu(escolha);

    }

    private void chamarSubMenu(Integer opcao) {
        switch (opcao) {
            case 1:
                new MenuCliente().run();
                break;
            case 2:
                new MenuConta().run();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Opção inválida");
        }
    }

}
