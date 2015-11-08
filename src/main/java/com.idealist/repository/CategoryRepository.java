package com.idealist.repository;

import com.idealist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * METHOD           PATH
 * <p>
 * OPTIONS          /categories
 * <p>
 * HEAD             /categories
 * <p>
 * GET              /categories
 * <p>
 * GET              /categories   => produces=[application/x-spring-data-compact+json
 *                                          || text/uri-list]
 * POST             /categories
 * <p>
 * <p>
 * OPTIONS          /categories/{id}
 * <p>
 * HEAD             /categories/{id}
 * <p>
 * GET              /categories/{id}
 * <p>
 * PUT              /categories/{id}
 * <p>
 * PATCH            /categories/{id}
 * <p>
 * DELETE           /categories/{id}
 * <p>
 * GET              /categories/{id}/{property}
 * <p>
 * GET              /categories/{id}/{property}/{propertyId}
 * <p>
 * DELETE           /categories/{id}/{property}
 * <p>
 * GET              /categories/{id}/{property}  => produces=[application/x-spring-data-compact+json
 *                                                         || text/uri-list]
 * <p>
 * PATCH || PUT     /categories/{id}/{property} => consumes=[application/json
 *                                                        || application/x-spring-data-compact+json
 *                                                        || text/uri-list]
 * <p>
 * DELETE           /categories/{id}/{property}/{propertyId}
 * <p>
 * <p>
 * GET              /categories/schema  => produces=[application/schema+json]
 * <p>
 * OPTIONS          /categories/search
 * <p>
 * HEAD             /categories/search
 * <p>
 * GET              /categories/search
 * <p>
 * GET              /categories/search/{search}
 * <p>
 * GET              /categories/search/{search} => produces=[application/x-spring-data-compact+json]
 * <p>
 * OPTIONS          /categories/search/{search}
 * <p>
 * HEAD             /categories/search/{search}
 * <p>
 * <p>
 * GET              /alps/categories
 * <p>
 * OPTIONS          /alps || /alps/categories
 */
@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAll();

    Category findByName(@Param("name") String name);

    Category getOne(@Param("id") Long id);

    boolean exists(@Param("exist") Long exist);

    void delete(@Param("id") Long id);

}
