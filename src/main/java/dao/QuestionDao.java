package dao;

import entity.Question;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class QuestionDao implements Dao<Question> {

    private EntityManager em = EM.getInstance();

    @Override
    public Optional<Question> get(int id) {
        return Optional.ofNullable(em.find(Question.class, id));
    }

    @Override
    public List<Question> getAll() {
        Query query = em.createQuery("SELECT q FROM Question q");
        return query.getResultList();
    }

    @Override
    public void save(Question question) {
        EM.executeInsideTransaction(entityManager -> entityManager.persist(question));
    }

    @Override
    public void update(Question question, String[] params) {
//        question.setValue(Objects.requireNonNull(params[0], "Text cannot be null"));
//        question.setDifficulty(Objects.requireNonNull(params[1], "Difficulty cannot be null"));
//        EM.executeInsideTransaction(entityManager -> entityManager.merge(question));
    }

    @Override
    public void delete(Question question) {
        EM.executeInsideTransaction(entityManager -> entityManager.remove(question));
    }
}
