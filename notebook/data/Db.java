package notebook.data;

public interface Db {
    void save(Object obj) throws DbException;

    Object[] findAll() throws DbException;

    void removeAll() throws DbException;

    void removeByIndex() throws DbException;
}
