package com.game.controller;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class HeroControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/create-hero-dataset.xml")
    @ExpectedDatabase(value = "classpath:dbunit/create-hero-expected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DatabaseTearDown(value = "classpath:dbunit/create-hero-teardown.xml", type = DatabaseOperation.DELETE_ALL)
    void shouldCreateHero() throws Exception {
        mockMvc.perform(post("/hero/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createHeroJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hero.name").value("Drago"))
                .andExpect(jsonPath("$.hero.heroClass").value("KNIGHT"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-hero-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-hero-dataset.xml")
    void shouldFindHeroByName() throws Exception {
        mockMvc.perform(get("/hero/Drago")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createHeroJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hero.name").value("Drago"))
                .andExpect(jsonPath("$.hero.heroClass").value("KNIGHT"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/delete-hero-dataset.xml")
    @ExpectedDatabase(value = "classpath:dbunit/delete-hero-expected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    void shouldDeleteHeroByName() throws Exception {
        mockMvc.perform(delete("/hero/Drago")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createHeroJSON()))
                .andExpect(status().isOk());

    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-hero-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-hero-dataset.xml")
    void shouldFindAllHeroes() throws Exception {
        mockMvc.perform(get("/hero/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createHeroJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.heroes").isArray())
                .andExpect(jsonPath("$.heroes.length()").value("1"));
    }

    private String createHeroJSON() {
        return """
                {
                    "heroClass": "KNIGHT",
                    "name": "Drago"
                }""";
    }
}