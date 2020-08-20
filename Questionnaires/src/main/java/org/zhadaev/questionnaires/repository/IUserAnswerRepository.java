package org.zhadaev.questionnaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.questionnaires.model.UserAnswer;

import java.util.Set;

@Repository
public interface IUserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    Set<UserAnswer> findByQuestionnaireId(final Long id);
}
