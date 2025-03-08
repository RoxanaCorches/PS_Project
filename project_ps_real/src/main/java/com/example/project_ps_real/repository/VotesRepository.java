package com.example.project_ps_real.repository;

import com.example.project_ps_real.entity.Votes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesRepository extends CrudRepository<Votes, Long> {
}
