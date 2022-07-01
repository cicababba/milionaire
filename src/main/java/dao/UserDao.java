package dao;

import entity.Game;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private EntityManager em = EM.getInstance();

    @Override
    public Optional<User> get(int id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public List<User> getAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        EM.executeInsideTransaction(entityManager -> entityManager.persist(user));
    }

    @Override
    public void update(User user, String[] params) {
        user.setEmail(Objects.requireNonNull(params[0], "Email cannot be null"));
        user.setUsername(Objects.requireNonNull(params[1], "Username cannot be null"));
        EM.executeInsideTransaction(entityManager -> entityManager.merge(user));
    }

    @Override
    public void delete(User user) {
        EM.executeInsideTransaction(entityManager -> entityManager.remove(user));
    }

    public void saveGame(User user, Game game) {
        user.getGames().add(game);
        EM.executeInsideTransaction(entityManager -> entityManager.merge(user));
    }
}
