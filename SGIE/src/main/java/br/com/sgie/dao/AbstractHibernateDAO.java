package br.com.sgie.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDAO<T extends Serializable> extends AbstractDAO<T> implements Operacoes<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    // API

    @Override
    public T findOne(final long id) {
    	getCurrentSession().flush();
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public T create(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
        getCurrentSession().flush();
        return entity;
    }

    @Override
    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}