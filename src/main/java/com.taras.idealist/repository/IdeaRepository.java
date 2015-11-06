package com.taras.idealist.repository;


import com.taras.idealist.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ideas", path = "ideas")
public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findById(@Param("id") long id);

}