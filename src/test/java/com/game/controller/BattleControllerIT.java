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
        return """
                {
                 "hero":\s
                        {
                            "heroClass": "KNIGHT",
                            "name": "Drago",
                            "health": 400,
                            "strength": 20,
                            "level": 1,
                            "dexterity": 10,
                            "armor": {
                                "id": 1,
                                "owner": "Drago",
                                "armorClass": "WITHOUT_ARMOR",
                                "durability": 2147483647,
                                "physicalDefense": 0,
                                "magicalDefense": 0,
                                "broken": false
                            },
                            "weapon": {
                                "id": 1,
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
                                    "output": "Р‘С‹СЃС‚СЂР°СЏ Р°С‚Р°РєР°",
                                    "criticalHitChance": 0,
                                    "missChance": 0
                                },
                                null,
                                null
                            ],
                            "alive": true
                        },
                "enemy": {
                        "health": 500,
                        "dexterity": 5,
                        "physicalDamage": 150,
                        "magicalDamage": 0,
                        "physicalDefense": 40,
                        "magicalDefense": 0,
                        "skills": [
                            {
                                "name": "FastAttack",
                                "criticalHitChance": 0,
                                "missChance": 0
                            },
                            {
                                "name": "PowerAttack",
                                "criticalHitChance": 5,
                                "missChance": 7
                            }
                        ],
                        "enemyClass": "ORC"\s
                    },
                "heroSkill":
                                {
                                    "name": "FireDamage",
                                    "output": "РђС‚Р°РєР° РѕРіРЅРµРј",
                                    "criticalHitChance": 0,
                                    "missChance": -5
                                },
                "enemySkill":\s
                            {
                                "name": "FastAttack",
                                "criticalHitChance": 0,
                                "missChance": 0
                            }
                 \s
                }""";

    }
}