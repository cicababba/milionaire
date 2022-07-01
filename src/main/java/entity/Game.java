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
@Table(name = "game")
public class Game {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "game_id")
        private long id;

        private int score;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToMany
        @JoinTable(name = "game_question",
                joinColumns = @JoinColumn(name = "game_id"),
                inverseJoinColumns = @JoinColumn(name = "question_id"))
        private List<Question> questions;

}
