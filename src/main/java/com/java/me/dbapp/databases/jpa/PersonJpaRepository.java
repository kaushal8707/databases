package com.java.me.dbapp.databases.jpa;
import com.java.me.dbapp.databases.jdbc.Person;
import com.java.me.dbapp.databases.jdbc.PersonJdbcDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PersonJpaRepository
{
     @PersistenceContext
     EntityManager entityManager;

    public Persons findById(int id)
    {
        return entityManager.find(Persons.class,id);
    }
    public Persons insert(Persons persons)
    {
        return entityManager.merge(persons);
    }
    public Persons update(Persons persons)
    {
        return entityManager.merge(persons);
    }
    public void deleteById(int id)
    {
        Persons persons=findById(id);
        entityManager.remove(persons);
    }
    public List<Persons> findAll()
    {
        TypedQuery<Persons> typedQuery=entityManager.createNamedQuery("find all persons",Persons.class);
        return typedQuery.getResultList();
    }

}
