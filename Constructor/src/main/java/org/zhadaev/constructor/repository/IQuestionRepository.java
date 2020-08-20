package org.zhadaev.constructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.constructor.model.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
