package org.zhadaev.constructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.constructor.model.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {
}
