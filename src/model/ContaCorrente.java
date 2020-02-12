package model;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente titular, Double saldo) {
        super(titular, saldo);
    }

    @Override
    public Boolean sacar(Double valor) {
        final Double TARIFA_SAQUE = valor * 0.01;
        Double valorSaque = valor + TARIFA_SAQUE;
        return super.sacar(valorSaque);
    }

}
