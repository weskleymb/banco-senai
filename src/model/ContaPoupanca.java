package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente titular, Double saldo) {
        super(titular, saldo);
    }

    public void render() {
        final Double TAXA_RENDIMENTO = 0.005 * super.getSaldo();
        super.depositar(TAXA_RENDIMENTO);
    }

}
