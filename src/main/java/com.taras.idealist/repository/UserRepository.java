package com.taras.idealist.repository;


import com.taras.idealist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * METHOD           PATH
 * <p>
 * OPTIONS          /users
 * <p>
 * HEAD             /users
 * <p>
 * GET              /users
 * <p>
 * GET              /users   => produces=[application/x-spring-data-compact+json
 *                                     || text/uri-list]
 * POST             /users
 * <p>
 * <p>
 * OPTIONS          /users/{id}
 * <p>
 * HEAD             /users/{id}
 * <p>
 * GET              /users/{id}
 * <p>
 * PUT              /users/{id}
 * <p>
 * PATCH            /users/{id}
 * <p>
 * DELETE           /users/{id}
 * <p>
 * GET              /users/{id}/{property}
 * <p>
 * GET              /users/{id}/{property}/{propertyId}
 * <p>
 * DELETE           /users/{id}/{property}
 * <p>
 * GET              /users/{id}/{property}  => produces=[application/x-spring-data-compact+json
 *                                                    || text/uri-list]
 * <p>
 * PATCH || PUT     /users/{id}/{property} => consumes=[application/json
 *                                                   || application/x-spring-data-compact+json
 *                                                   || text/uri-list]
 * <p>
 * DELETE           /users/{id}/{property}/{propertyId}
 * <p>
 * <p>
 * GET              /users/schema  => produces=[application/schema+json]
 * <p>
 * OPTIONS          /users/search
 * <p>
 * HEAD             /users/search
 * <p>
 * GET              /users/search
 * <p>
 * GET              /users/search/{search}
 * <p>
 * GET              /users/search/{search} => produces=[application/x-spring-data-compact+json]
 * <p>
 * OPTIONS          /users/search/{search}
 * <p>
 * HEAD             /users/search/{search}
 * <p>
 * <p>
 * GET              /alps/users
 * <p>
 * OPTIONS          /alps || /alps/users
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findAll();

    User findByName(@Param("name") String name);

    User getOne(@Param("id") Long id);

    boolean exists(@Param("exist") Long exist);

    void delete(@Param("id") Long id);
}

