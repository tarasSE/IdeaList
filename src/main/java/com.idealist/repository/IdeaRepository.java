package com.idealist.repository;


import com.idealist.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * METHOD           PATH
 * <p>
 * OPTIONS          /ideas
 * <p>
 * HEAD             /ideas
 * <p>
 * GET              /ideas
 * <p>
 * GET              /ideas   => produces=[application/x-spring-data-compact+json
 *                                     || text/uri-list]
 * POST             /ideas
 * <p>
 * <p>
 * OPTIONS          /ideas/{id}
 * <p>
 * HEAD             /ideas/{id}
 * <p>
 * GET              /ideas/{id}
 * <p>
 * PUT              /ideas/{id}
 * <p>
 * PATCH            /ideas/{id}
 * <p>
 * DELETE           /ideas/{id}
 * <p>
 * GET              /ideas/{id}/{property}
 * <p>
 * GET              /ideas/{id}/{property}/{propertyId}
 * <p>
 * DELETE           /ideas/{id}/{property}
 * <p>
 * GET              /ideas/{id}/{property}  => produces=[application/x-spring-data-compact+json
 *                                                    || text/uri-list]
 * <p>
 * PATCH || PUT     /ideas/{id}/{property} => consumes=[application/json
 *                                                   || application/x-spring-data-compact+json
 *                                                   || text/uri-list]
 * <p>
 * DELETE           /ideas/{id}/{property}/{propertyId}
 * <p>
 * <p>
 * GET              /ideas/schema  => produces=[application/schema+json]
 * <p>
 * OPTIONS          /ideas/search
 * <p>
 * HEAD             /ideas/search
 * <p>
 * GET              /ideas/search
 * <p>
 * GET              /ideas/search/{search}
 * <p>
 * GET              /ideas/search/{search} => produces=[application/x-spring-data-compact+json]
 * <p>
 * OPTIONS          /ideas/search/{search}
 * <p>
 * HEAD             /ideas/search/{search}
 * <p>
 * <p>
 * GET              /alps/ideas
 * <p>
 * OPTIONS          /alps || /alps/ideas
 */
@RepositoryRestResource(collectionResourceRel = "ideas", path = "ideas")
public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findAll();

    Idea getOne(@Param("id") Long id);

    List<Idea> getByPriority(@Param("priority") Integer priority);

    boolean exists(@Param("exist") Long exist);

    void delete(@Param("id") Long id);


}