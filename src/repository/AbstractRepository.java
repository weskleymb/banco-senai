package repository;

import model.Persistivel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends Persistivel> {

    private static Integer id = 0;
    private List<T> ts;

    protected void setLista(List<T> lista) {
        ts = lista;
    }

    public void salvar(T t) {
        t.setId(++id);
        ts.add(t);
    }

    public void excluir(T t) {
        ts.remove(t);
    }

    public void editar(T t) {
        T x = listarUm(t.getId());
        if (x != null) {
            Integer indice = ts.indexOf(x);
            ts.set(indice, t);
        }
    }

    public T listarUm(Integer id) {
        for (T t : ts) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public List<T> listarTodos() {
        return new ArrayList<T>(ts);
    }

}
