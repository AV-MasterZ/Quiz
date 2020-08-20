package org.zhadaev.questionnaires.model;

import org.zhadaev.constructor.model.Answer;
import org.zhadaev.constructor.model.Questionnaire;
import org.zhadaev.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "users_answers")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionnaire_id", nullable = false)
    private Questionnaire questionnaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(final Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(final Answer answer) {
        this.answer = answer;
    }
}
