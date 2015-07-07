/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.generics;

/**
 *
 * @author IQJB
 */
public class EntityDoesNotExistException extends DAOException {

    private final Class type;
    private final Object id;

    public EntityDoesNotExistException(Class type, Object id) {
        super(type.getSimpleName() + " does not exist with id " + id);
        this.type = type;
        this.id = id;
    }

    public EntityDoesNotExistException(Class type, Object id, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
        this.id = id;
    }

    public Class getType() {
        return type;
    }

    public Object getId() {
        return id;
    }
}
