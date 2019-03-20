package org.its.dl.user;

import org.its.jpahelpers.JpaHelper;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Named("userDl")
public class UserDLImpl implements UserDL {
    HashMap<Integer, UtenteDL> listaUtenteDL = new HashMap<Integer, UtenteDL>();
    int maxId= 1;
    private JpaHelper jpaHelper;

    public UserDLImpl(@Named("jpaHelper") JpaHelper jpaHelper) {
        this.jpaHelper = jpaHelper;
    }

    @Override
    public List<UtenteDL> getAll() {
        //return new ArrayList<UtenteDL>(listaUtenteDL.values());
        EntityManager em = jpaHelper.getEntityManager();
        Query query =em.createQuery("SELECT p FROM UtenteDL p");
        return query.getResultList();
    }

    public UtenteDL add(UtenteDL utenteDL) {
        UtenteDL utenteDLToPersist = new UtenteDL(utenteDL);
        EntityManager em = jpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.persist(utenteDLToPersist);
        em.getTransaction().commit();

//        utenteDL.setId(maxId);
//        maxId++;
//        listaUtenteDL.put(utenteDL.getId(), utenteDL);
        UtenteDL result = getUserById(utenteDLToPersist.getId());
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager em  = jpaHelper.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "DELETE FROM UtenteDL p WHERE id=:id");
        query.setParameter(
                "id",id);
        query.executeUpdate();
        em.getTransaction().commit();

        if(getUserById(id) == null) return true;
        else return false;
//        if (!listaUtenteDL.containsKey(id)){
//                return  false;
//            } else{
//            listaUtenteDL.remove(id);
//            return true;
//        }
    }

    public UtenteDL getUserById(Integer id) {
        EntityManager em  = jpaHelper.getEntityManager();
        Query query = em.createQuery(
                "SELECT p FROM UtenteDL p WHERE id=:id");
        query.setParameter(
                "id",id);
        if(query.getResultList().size()==0) return null;
        return (UtenteDL) query.getResultList().get(0);
    }

    @Override
    public void update(UtenteDL utenteDL) throws Exception {
        EntityManager em = jpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.merge(utenteDL);
        em.getTransaction().commit();

//        if(getUserById(utenteDL.getId()) == utenteDL){
//            return;
//        } else  throw new Exception("Update non riuscito");


//        if (!listaUtenteDL.containsKey(utenteDL.getId())) {
//            throw new Exception("UtenteDL non presente");
//        }
//        listaUtenteDL.put(utenteDL.getId(), utenteDL);
    }

}

