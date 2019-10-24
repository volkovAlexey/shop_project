package ua.service.base;

import java.util.List;

public interface BasicService<ID, ENTITY> {
    List<ENTITY> getAll();

    ENTITY getEntry(ID id);

    void delete(ID id);

    ENTITY addEntry(ENTITY value);

    ENTITY update(ID id, ENTITY entity);
}
