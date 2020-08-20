package org.zhadaev.questionnaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.constructor.model.Questionnaire;

@Repository
public interface IUserAnswerRepository extends JpaRepository<Questionnaire, Long> {
}
