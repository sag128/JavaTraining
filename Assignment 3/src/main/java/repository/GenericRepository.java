package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericRepository {


    protected static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("blockbusterDb");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> entityManagerFactory.close()));
    }

    public <T> T save(T t) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            // merge is a 2-in-1 method, can be used for insert as well as update
            T savedObj = entityManager.merge(t);
            entityManager.flush();
            tx.commit();
            return savedObj;

        }
        finally {
            entityManager.close();
        }
    }


    public <T> T fetch(Class<T> clazz, Object pk) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            T t = entityManager.find(clazz,pk);
            return t;
        }
        finally {
            entityManager.close();
        }
    }




}
