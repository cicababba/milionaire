package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "question_id")
        private long id;

        private String value;

        private int score;

        @OneToMany(mappedBy = "question")
        private List<Answer> answers;

        @ManyToMany(mappedBy = "questions")
        private List<Game> games;
}
