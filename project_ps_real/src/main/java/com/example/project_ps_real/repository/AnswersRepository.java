package com.example.project_ps_real.repository;

import com.example.project_ps_real.entity.Answers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends CrudRepository<Answers, Long> {
}
