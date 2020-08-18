package org.zhadaev.constructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhadaev.constructor.model.Questionnaire;
import org.zhadaev.constructor.repository.IQuestionnaireRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireService implements IQuestionnaireService {

    @Autowired
    private IQuestionnaireRepository questionnaireRepository;

    @Override
    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Questionnaire findById(final Long id) {
        return questionnaireRepository.findById(id).orElse(new Questionnaire());
    }

    @Override
    public boolean save(final Questionnaire questionnaire) {

        Optional<Questionnaire> questionnaireFromDB = questionnaireRepository.findById(questionnaire.getId());

        if (questionnaireFromDB.isPresent()) {
            return false;
        }

        questionnaireRepository.save(questionnaire);

        return true;
    }

    @Override
    public boolean delete(final Questionnaire questionnaire) {

        Optional<Questionnaire> questionnaireFromDB = questionnaireRepository.findById(questionnaire.getId());

        if (questionnaireFromDB.isEmpty()) {
            return false;
        }

        questionnaireRepository.delete(questionnaire);

        return true;
    }
}
