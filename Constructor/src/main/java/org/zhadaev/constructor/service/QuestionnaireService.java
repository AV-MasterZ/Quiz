package org.zhadaev.constructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhadaev.constructor.model.Answer;
import org.zhadaev.constructor.model.Question;
import org.zhadaev.constructor.model.QuestionType;
import org.zhadaev.constructor.model.Questionnaire;
import org.zhadaev.constructor.repository.IAnswerRepository;
import org.zhadaev.constructor.repository.IQuestionRepository;
import org.zhadaev.constructor.repository.IQuestionTypeRepository;
import org.zhadaev.constructor.repository.IQuestionnaireRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionnaireService implements IQuestionnaireService {

    @Autowired
    private IQuestionnaireRepository questionnaireRepository;

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Questionnaire findById(final Long id) {
        return questionnaireRepository.findById(id).orElse(new Questionnaire());
    }

    @Override
    public void save(final Questionnaire questionnaire) {

        Questionnaire questionnaireFromDB;
        if (questionnaire.getId() == null) {
            questionnaireFromDB = questionnaireRepository.save(questionnaire);
        } else {
            Questionnaire questionnaireToSave = questionnaireRepository.findById(questionnaire.getId()).get();
            questionnaireToSave.setTitle(questionnaire.getTitle());
            questionnaireFromDB = questionnaireRepository.save(questionnaireToSave);
        }

        for (Question q: questionnaire.getQuestions()) {
            QuestionType typeFromDB = questionTypeRepository.findByType(q.getType().getType());
            Question questionFromDB;
            if (q.getId() == null) {
                q.setType(typeFromDB);
                q.setQuestionnaire(questionnaireFromDB);
                questionFromDB = questionRepository.save(q);
            } else {
                Question questionToSave = questionRepository.findById(q.getId()).get();
                questionToSave.setQuestionnaire(questionnaireFromDB);
                questionToSave.setType(typeFromDB);
                questionToSave.setQuestion(q.getQuestion());
                questionFromDB = questionRepository.save(questionToSave);
            }

            for (Answer a: q.getAnswers()) {
                if (a.getId() == null) {
                    a.setQuestion(questionFromDB);
                    answerRepository.save(a);
                } else {
                    Answer answerToSave = answerRepository.findById(a.getId()).get();
                    answerToSave.setQuestion(questionFromDB);
                    answerToSave.setAnswer(a.getAnswer());
                    answerRepository.save(answerToSave);
                }
            }
        }
    }

    @Override
    public boolean delete(final Long id) {

        Optional<Questionnaire> questionnaireFromDB = questionnaireRepository.findById(id);

        if (questionnaireFromDB.isEmpty()) {
            return false;
        }

        questionnaireRepository.delete(questionnaireFromDB.get());

        return true;
    }
}
