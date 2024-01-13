package com.quiz.repository;

import com.quiz.model.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Options, Integer> {


}
