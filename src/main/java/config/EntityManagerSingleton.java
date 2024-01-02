package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EntityManagerSingleton {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    private EntityManagerSingleton() {
        // Örneğin, "postgres" persistence unit ismi kullanılarak EntityManagerFactory oluşturuluyor
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            synchronized (EntityManagerSingleton.class) {
                if (entityManager == null || !entityManager.isOpen()) {
                    new EntityManagerSingleton();
                }
            }
        }
        return entityManager;
    }

    public static void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }
}

