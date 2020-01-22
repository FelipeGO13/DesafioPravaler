package br.com.sgie.dao;


import java.io.Serializable;

public abstract class AbstractDAO<T extends Serializable> implements Operacoes<T> {

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }
}