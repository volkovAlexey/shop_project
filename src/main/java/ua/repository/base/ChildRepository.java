package ua.repository.base;

public interface ChildRepository<PID, ENTITY> {
    ENTITY insert(PID parentID, ENTITY entity);

    void deleteAllByParentID(PID parentID);
}
