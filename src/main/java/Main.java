import entity.Game;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("qbit_jpa");
        em = emf.createEntityManager();
        System.out.println("Hello World!");
    }
}
