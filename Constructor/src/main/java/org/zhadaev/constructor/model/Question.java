package org.zhadaev.constructor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qtype_id", nullable = false)
    private QuestionType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionnaire_id", nullable = false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Answer> answers;

    public void addAnswer(final Answer answer) {
        if (answer == null) return;
        if (answers == null) {
            answers = new HashSet<>();
        }
        answer.setQuestion(this);
        answers.add(answer);
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(final QuestionType type) {
        this.type = type;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(final Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(final Set<Answer> answers) {
        this.answers = answers;
    }
}
