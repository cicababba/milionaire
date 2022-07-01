package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "question")
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "question_id")
        private long id;

        private String value;

        private int score;

        @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
        private List<Answer> answers;

        @ManyToMany(mappedBy = "questions")
        private List<Game> games;
}
