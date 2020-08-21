package org.zhadaev.questionnaires.service;

import org.springframework.stereotype.Service;
import org.zhadaev.questionnaires.model.UserAnswer;

import java.util.List;
import java.util.Set;

@Service
public interface IUserAnswerService {
    List<UserAnswer> findAll();
    UserAnswer findById(final Long id);
    void save(final List<String> answers, final Long id, final String username);
    boolean delete(final Long id);
    Set<UserAnswer> findByUserId(final Long id);
}
