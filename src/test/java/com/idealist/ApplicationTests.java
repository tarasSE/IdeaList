package com.idealist;

import com.idealist.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
@Transactional
public class ApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private CategoryRepository categoryRepository;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	@Description(value = "Test root")
	public void testHome() throws Exception {

		this.mvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(content().string(containsString("categories")));
	}

	@Test
	@Description(value = "Test CategoryRepository.getOne()")
	public void getOneCategory() throws Exception {

		this.mvc.perform(
				get("/categories/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name", equalTo("test_name")));

		this.mvc.perform(
				get("/categories/5"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name", equalTo("test_name4")));
	}

	@Test
	@Description(value = "Test CategoryRepository.findByName()")
	public void findByNameCategory() throws Exception {

		this.mvc.perform(
				get("/categories/search/findByName?name=test_name"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("_embedded.categories", hasSize(1)));
	}

	@Test
	@Description(value = "Test CategoryRepository.findAll()")
	public void findAllCategory() throws Exception {

		this.mvc.perform(
				get("/categories"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("_embedded.categories", hasSize(5)));
	}

	@Test
	@Description(value = "Test CategoryRepository.delete()")
	public void deleteCategory() throws Exception {

		this.mvc.perform(
				delete("/categories/5"));

		assertEquals(false, categoryRepository.exists(5L));
	}



}