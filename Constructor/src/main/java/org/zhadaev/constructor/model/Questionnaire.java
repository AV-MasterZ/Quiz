package org.zhadaev.constructor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @OneToMany(mappedBy = "questionnaire", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Question> questions;

    public void addQuestion(final Question question) {
        if (question == null) return;
        if (questions == null) {
            questions = new HashSet<>();
        }
        question.setQuestionnaire(this);
        questions.add(question);
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(final Set<Question> questions) {
        this.questions = questions;
    }
}
