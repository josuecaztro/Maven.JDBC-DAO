package daos;

import java.util.List;

public interface DAO<T> {
    public T findById(int id);

    public List<T> findAll();

    public T update(Person dto);

    public T create(Person dto);

    public void delete(int id);
}
