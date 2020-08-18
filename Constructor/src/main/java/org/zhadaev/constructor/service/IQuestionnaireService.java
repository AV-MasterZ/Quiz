package org.zhadaev.constructor.service;

import org.springframework.stereotype.Service;
import org.zhadaev.constructor.model.Questionnaire;

import java.util.List;

@Service
public interface IQuestionnaireService {

    List<Questionnaire> findAll();
    Questionnaire findById(final Long id);
    boolean save(final Questionnaire questionnaire);
    boolean delete(final Questionnaire questionnaire);

}
