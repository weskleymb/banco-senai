package model;

public abstract class Conta implements Persistivel {

    private Integer id;
    private Integer numero;
    private Cliente titular;
    private Double saldo;

    // Construtores (Criadores de Objetos)
    public Conta(Cliente titular, Double saldo) {
        this.titular = titular;
        this.saldo = 0.0;
        this.depositar(saldo);
    }

    // Métodos (verbos)

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
        this.numero = id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean depositar(Double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public Boolean sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public Boolean tranferir(Conta contaDestino, Double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public Integer getNumero() {
        return new Integer(numero);
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public Double getSaldo() {
        return new Double(saldo);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        builder.append("[");
        builder.append("numero: ");
        builder.append(this.numero);
        builder.append(", ");
        builder.append("titular: ");
        builder.append(this.titular.getNome());
        builder.append(", ");
        builder.append("saldo: ");
        builder.append(this.saldo);
        builder.append("]");
        return builder.toString().toUpperCase();
    }

}
