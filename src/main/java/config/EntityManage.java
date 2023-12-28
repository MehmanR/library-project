package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EntityManage {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static EntityManage instance;

    private EntityManage() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

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
