package com.game.controller;

import com.game.dto.hero.HeroDTO;
import com.game.repository.armor.ArmorFactory;
import com.game.repository.enemy.Orc;
import com.game.repository.hero.HeroFactory;
import com.game.repository.weapon.WeaponFactory;
import com.game.skills.enemy.ConcreteEnemySkillPowerAttack;
import com.game.skills.hero.ConcreteHeroSkillFireDamage;
import com.game.utils.ArmorDTOConverter;
import com.game.utils.HeroDTOConverter;
import com.game.utils.StringToSkillsDecoder;
import com.game.utils.WeaponDTOConverter;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.game.repository.armor.ArmorClass.WITHOUT_ARMOR;
import static com.game.repository.hero.HeroClass.WIZARD;
import static com.game.repository.weapon.WeaponType.WITHOUT_WEAPON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BattleControllerIT {
    @Autowired
    private MockMvc mockMvc;

    private final HeroDTOConverter heroDTOConverter = new HeroDTOConverter(
            new StringToSkillsDecoder(),
            new ArmorDTOConverter(),
            new WeaponDTOConverter()
    );


    @Test
    void startBattle() throws Exception {
        mockMvc.perform(put("/battle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(startBattleJSON()))
                .andExpect(status().isOk());
    }

    @Test
    void generateEnemy() {
    }

    private String startBattleJSON() throws JSONException {
        var hero = heroMaker();
        return new JSONObject()
                .put("hero", hero)
                .put("enemy", new Orc())
                .put("heroSkill", new ConcreteHeroSkillFireDamage())
                .put("enemySkill", new ConcreteEnemySkillPowerAttack())
                .toString();

    }

    private HeroDTO heroMaker() {
        var hero = HeroFactory.createHero(WIZARD, "Rexorr");
        var armor = ArmorFactory.createArmor(WITHOUT_ARMOR);
        var weapon = WeaponFactory.createWeapon(WITHOUT_WEAPON);
        armor.setOwner(hero.getName());
        hero.setArmor(armor);
        hero.setWeapon(weapon);
        return heroDTOConverter.convertToDto(hero);

    }
}