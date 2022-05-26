package com.game.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BattleControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void startBattle() throws Exception {
        mockMvc.perform(put("/battle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(startBattleJSON()))
                .andExpect(status().isOk());
    }

    @Test
    void generateEnemy() throws Exception {
        mockMvc.perform(get("/battle/enemy")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    private String startBattleJSON() {
        return "{\n" +
                " \"hero\": \n" +
                "        {\n" +
                "            \"heroClass\": \"KNIGHT\",\n" +
                "            \"name\": \"Drago\",\n" +
                "            \"health\": 400,\n" +
                "            \"strength\": 20,\n" +
                "            \"level\": 1,\n" +
                "            \"dexterity\": 10,\n" +
                "            \"armor\": {\n" +
                "                \"id\": 1,\n" +
                "                \"owner\": \"Drago\",\n" +
                "                \"armorClass\": \"WITHOUT_ARMOR\",\n" +
                "                \"durability\": 2147483647,\n" +
                "                \"physicalDefense\": 0,\n" +
                "                \"magicalDefense\": 0,\n" +
                "                \"broken\": false\n" +
                "            },\n" +
                "            \"weapon\": {\n" +
                "                \"id\": 1,\n" +
                "                \"owner\": \"Drago\",\n" +
                "                \"weaponType\": \"WITHOUT_WEAPON\",\n" +
                "                \"durability\": 2147483647,\n" +
                "                \"physicalDamage\": 0,\n" +
                "                \"magicalDamage\": 0,\n" +
                "                \"level\": 1,\n" +
                "                \"criticalHitChance\": 0,\n" +
                "                \"broken\": false\n" +
                "            },\n" +
                "            \"skills\": [\n" +
                "                {\n" +
                "                    \"name\": \"FastAttack\",\n" +
                "                    \"output\": \"Р‘С‹СЃС‚СЂР°СЏ Р°С‚Р°РєР°\",\n" +
                "                    \"criticalHitChance\": 0,\n" +
                "                    \"missChance\": 0\n" +
                "                },\n" +
                "                null,\n" +
                "                null\n" +
                "            ],\n" +
                "            \"alive\": true\n" +
                "        },\n" +
                "\"enemy\": {\n" +
                "        \"health\": 500,\n" +
                "        \"dexterity\": 5,\n" +
                "        \"physicalDamage\": 150,\n" +
                "        \"magicalDamage\": 0,\n" +
                "        \"physicalDefense\": 40,\n" +
                "        \"magicalDefense\": 0,\n" +
                "        \"skills\": [\n" +
                "            {\n" +
                "                \"name\": \"FastAttack\",\n" +
                "                \"criticalHitChance\": 0,\n" +
                "                \"missChance\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"PowerAttack\",\n" +
                "                \"criticalHitChance\": 5,\n" +
                "                \"missChance\": 7\n" +
                "            }\n" +
                "        ],\n" +
                "        \"enemyClass\": \"ORC\" \n" +
                "    },\n" +
                "\"heroSkill\":\n" +
                "                {\n" +
                "                    \"name\": \"FireDamage\",\n" +
                "                    \"output\": \"РђС‚Р°РєР° РѕРіРЅРµРј\",\n" +
                "                    \"criticalHitChance\": 0,\n" +
                "                    \"missChance\": -5\n" +
                "                },\n" +
                "\"enemySkill\": \n" +
                "            {\n" +
                "                \"name\": \"FastAttack\",\n" +
                "                \"criticalHitChance\": 0,\n" +
                "                \"missChance\": 0\n" +
                "            }\n" +
                "  \n" +
                "}";
    }
}