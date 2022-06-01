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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class WeaponControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/create-weapon-dataset.xml")
    @ExpectedDatabase(value = "classpath:dbunit/create-weapon-expected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DatabaseTearDown(value = "classpath:dbunit/create-weapon-teardown.xml", type = DatabaseOperation.DELETE_ALL)
    void shouldCreateWeapon() throws Exception {
        mockMvc.perform(post("/weapon/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createWeaponJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.weapon.id").value("1"))
                .andExpect(jsonPath("$.weapon.owner").value("Drago"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-weapon-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-weapon-dataset.xml")
    void shouldFindWeaponByOwner() throws Exception {
        mockMvc.perform(get("/weapon/Drago")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createWeaponJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.weapons").isArray())
                .andExpect(jsonPath("$.weapons.length()").value("1"));
    }


    private String createWeaponJSON() {
        return """
                {
                    "weaponType": "WITHOUT_WEAPON",
                    "hero":\s
                        {
                            "heroClass": "KNIGHT",
                            "name": "Drago",
                            "health": 400,
                            "strength": 20,
                            "level": 1,
                            "dexterity": 10,
                            "armor": {
                                "id": 0,
                                "owner": "Drago",
                                "armorClass": "WITHOUT_ARMOR",
                                "durability": 2147483647,
                                "physicalDefense": 0,
                                "magicalDefense": 0,
                                "broken": false
                            },
                            "weapon": {
                                "id": 0,
                                "owner": "Drago",
                                "weaponType": "WITHOUT_WEAPON",
                                "durability": 2147483647,
                                "physicalDamage": 0,
                                "magicalDamage": 0,
                                "level": 1,
                                "criticalHitChance": 0,
                                "broken": false
                            },
                           "skills": [
                                {
                                    "name": "FastAttack",
                                    "criticalHitChance": 0,
                                    "missChance": 0
                                },
                                null,
                                null
                            ],
                            "alive": true
                        }

                }""";
    }
}