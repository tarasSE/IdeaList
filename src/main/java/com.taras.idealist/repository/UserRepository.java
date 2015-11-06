package com.taras.idealist.repository;


import com.taras.idealist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(@Param("name") String name);

	@Override
	@PreAuthorize("#oauth2.hasScope('read')")
	List<User> findAll();

	@Override
	@PreAuthorize("#oauth2.hasScope('read')")
	User findOne(Long aLong);

	@Override
	@PreAuthorize("#oauth2.hasScope('write')")
	<S extends User> S save(S entity);

}