package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;
import java.util.function.Consumer;

public class EM {

    private static EntityManager entityManager;

    private EM() {
    }

    public static EntityManager getInstance() {
        if(Objects.isNull(entityManager)) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("qbit_jpa");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
