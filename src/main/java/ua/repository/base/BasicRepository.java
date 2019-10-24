package ua.repository.base;

import java.util.List;

public interface BasicRepository<ID, ENTITY> {
    List<ENTITY> findAll();

    ENTITY getOne(ID id);

    void delete(ID id);

    ENTITY update(ID id, ENTITY type);
}
