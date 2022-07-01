package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "answer_id")
        private long id;

        private String value;

        private boolean correct;

        @ManyToOne
        @JoinColumn(name = "question_id")
        private Question question;

}
