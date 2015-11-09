package com.idealist.service;

import com.idealist.Application;
import com.idealist.model.User;
import com.idealist.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotNull;

/**
 * Integration tests for {@link UserRepository}.
 *
 * @author Oliver Gierke
 * @author Andy Wilkinson
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
@Transactional
public class UserRepositoryIntegrationTests {

    @Autowired
    private UserRepository repository;

    private Random random = new Random();

    @Test
    public void createUserTest(){

        User user = new User();

        user.setName("some_name");

        user.setPassword("some_pass");

        log.info(user.toString());

        long id = repository.saveAndFlush(user).getId();

        assertNotNull(repository.getOne(id));

        log.info(repository.getOne(id).toString());
    }

    @Test
    public void findsFirstPageOfCities() {

        List<User> users = this.repository.findAll();

        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                        users.toString());

        assertNotNull(users.get(0));
    }


}