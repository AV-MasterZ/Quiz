package org.zhadaev.questionnaires.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhadaev.constructor.model.Answer;
import org.zhadaev.constructor.model.Questionnaire;
import org.zhadaev.constructor.service.IAnswerService;
import org.zhadaev.constructor.service.IQuestionnaireService;
import org.zhadaev.questionnaires.model.UserAnswer;
import org.zhadaev.questionnaires.repository.IUserAnswerRepository;
import org.zhadaev.user.model.User;
import org.zhadaev.user.service.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserAnswerService implements IUserAnswerService {

    @Autowired
    private IUserAnswerRepository userAnswerRepository;

    @Autowired
    private IQuestionnaireService questionnaireService;

    @Autowired
    private IAnswerService answerService;

    @Autowired
    private UserService userService;

    @Override
    public List<UserAnswer> findAll() {
        return userAnswerRepository.findAll();
    }

    @Override
    public UserAnswer findById(final Long id) {
        return userAnswerRepository.findById(id).orElse(new UserAnswer());
    }

    @Override
    public void save(final List<String> answers, final Long id, final String username) {

        Questionnaire questionnaire = questionnaireService.findById(id);
        User user = (User) userService.loadUserByUsername(username);
        Set<UserAnswer> userAnswers = new HashSet<>();
        for (String answerId: answers) {
            UserAnswer ua = new UserAnswer();
            ua.setUser(user);
            ua.setQuestionnaire(questionnaire);
            Answer answer = answerService.findById(Long.parseLong(answerId));
            ua.setAnswer(answer);
            userAnswers.add(ua);
        }

        Set<UserAnswer> oldUserAnswers = userAnswerRepository.findByQuestionnaireId(id);

        if (!oldUserAnswers.isEmpty()) {
            for (UserAnswer oldua: oldUserAnswers) {
                userAnswerRepository.delete(oldua);
            }
        }

        for (UserAnswer newua: userAnswers) {
            userAnswerRepository.save(newua);
        }

    }

    @Override
    public boolean delete(final Long id) {
        Optional<UserAnswer> ua = userAnswerRepository.findById(id);
        if (ua.isEmpty()) return false;
        userAnswerRepository.delete(ua.get());
        return true;
    }

}
