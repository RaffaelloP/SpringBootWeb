package org.its.jpahelpers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named("jpaHelper")
public class JpaHelperImpl implements JpaHelper {

    private final EntityManagerFactory emf;

    public JpaHelperImpl(){
        emf = Persistence.createEntityManagerFactory("JPAEXAMPLE");
    }

    public EntityManager getEntityManager(){
        return  emf.createEntityManager();
    }
}
