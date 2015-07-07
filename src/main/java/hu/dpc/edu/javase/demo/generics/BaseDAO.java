package hu.dpc.edu.javase.demo.generics;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author IQJB
 */
public abstract class BaseDAO<E extends Entity<ID>, ID> implements DAO<E, ID>{
    private final Class<E>type;
    
    private Map<ID,E> entities = new HashMap<>();

    protected BaseDAO(Class<E> type) {
        this.type = type;
    }
    
    @Override
    public E create() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void persist(E entity) {
        final ID id = entity.getId();
        if (entities.containsKey(id)) {
            throw new EntityExistsException(type, id);
        }
        entities.put(id, entity);
    }
    
    @Override
    public void update(E entity) {
        final ID id = entity.getId();
        if (!entities.containsKey(id)) {
            throw new EntityDoesNotExistException(type, id);
        }
        entities.put(id, entity);
    }
    
    @Override
    public E findById(ID id) {
        if (!entities.containsKey(id)) {
            throw new EntityDoesNotExistException(type, id);
        }
        return entities.get(id);
    }
}
