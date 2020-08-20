package org.zhadaev.constructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.constructor.model.QuestionType;

@Repository
public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Long> {
    QuestionType findByType(final String type);
}
