package org.zhadaev.questionnaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.questionnaires.model.UserAnswer;

import java.util.Set;

@Repository
public interface IUserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    Set<UserAnswer> findByUserId(final Long id);
    UserAnswer findByUserIdAndAnswerId(final Long userId, final Long answerId);
}
