import dao.QuestionDao;
import dao.UserDao;
import entity.Answer;
import entity.Game;
import entity.Question;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static UserDao userDao = new UserDao();
    public static void main(String[] args) {
//        User user = User.builder().email("cicababba").username("cicababba").build();
//        userDao.save(user);
        initQuestions();
    }



    static void initQuestions() {

        QuestionDao questionDao = new QuestionDao();

        if(!questionDao.getAll().isEmpty()) {
            System.out.println("Questions already inserted");
            return;
        }
        List<String> questions = List.of("L'operazione militare americana che ha caratterizzato la Guerra del Golfo era denominata",
                "Quale tra questi non è un romanzo di K. Follet",
                "In quale materiale è realizzato il più celebre David di Donatello?");

        List<Answer> question1Answers = List.of(
                Answer.builder().value("Operazione Deserto").correct(false).build(),
                Answer.builder().value("Vento del Deserto").correct(false).build(),
                Answer.builder().value("Tempesta del Deserta").correct(true).build(),
                Answer.builder().value("Missione Deserta").correct(false).build()
        );

        List<Answer> question2Answers = List.of(
                Answer.builder().value("Il volo del calabrone").correct(false).build(),
                Answer.builder().value("La caduta dei giganti").correct(false).build(),
                Answer.builder().value("L'ultimo cavaliere").correct(true).build(),
                Answer.builder().value("Nel bianco").correct(false).build()
        );

        List<Answer> question3Answers = List.of(
                Answer.builder().value("Avorio").correct(false).build(),
                Answer.builder().value("Marmo").correct(false).build(),
                Answer.builder().value("Bronzo").correct(true).build(),
                Answer.builder().value("Gesso").correct(false).build()
        );

        List<Question> questionsEntity = new ArrayList<>();

        Question question1 = Question.builder().value(questions.get(0)).answers(question1Answers).build();
        Question question2 = Question.builder().value(questions.get(1)).answers(question2Answers).build();
        Question question3 = Question.builder().value(questions.get(2)).answers(question3Answers).build();

        question1Answers.forEach(answer -> answer.setQuestion(question1));
        question2Answers.forEach(answer -> answer.setQuestion(question2));
        question3Answers.forEach(answer -> answer.setQuestion(question3));

        questionsEntity.add(question1);
        questionsEntity.add(question2);
        questionsEntity.add(question3);

        questionsEntity.forEach(questionDao::save);
        System.out.println("Questions inserted!!");
    }
}
