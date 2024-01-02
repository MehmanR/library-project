package config;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

// Getting the EntityManagerFactory from a singleton in the PersistenceManager class
public class EntityManage {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    private EntityManage() {
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    private static EntityManage instance;

    public static EntityManage getInstance() {
        if (instance == null) {
            synchronized (EntityManage.class) {
                if (instance == null) {
                    instance = new EntityManage();
                }
            }
        }
        return instance;

    }


}

