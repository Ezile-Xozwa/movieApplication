package za.ac.cput.repository;

@Deprecated
public interface Repository <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
}
