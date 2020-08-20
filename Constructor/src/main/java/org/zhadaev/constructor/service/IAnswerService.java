package org.zhadaev.constructor.service;

import org.springframework.stereotype.Service;
import org.zhadaev.constructor.model.Answer;

@Service
public interface IAnswerService {
    Answer findById(final Long id);
}
