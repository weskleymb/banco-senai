package model;

public class Cliente implements Persistivel {

    private Integer id;
    private String nome;
    private String cpf;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        builder.append("[");
        builder.append("nome: ");
        builder.append(this.nome);
        builder.append(", ");
        builder.append("cpf: ");
        builder.append(this.cpf);
        builder.append("]");
        return builder.toString().toUpperCase();
    }

}
