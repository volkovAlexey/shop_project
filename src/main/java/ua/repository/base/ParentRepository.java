package ua.repository.base;

public interface ParentRepository<ENTITY> {
    ENTITY insert(ENTITY entity);
}
