package org.zhadaev.constructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhadaev.constructor.model.Answer;
import org.zhadaev.constructor.repository.IAnswerRepository;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public Answer findById(final Long id) {
        return answerRepository.getOne(id);
    }
}
