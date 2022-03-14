package com.game.config;

import com.game.skills.hero.ConcreteHeroSkillFastAttack;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.ConcreteHeroSkillPowerAttack;
import com.game.skills.hero.HeroSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.game")
public class AppConfig {

    @Bean(name = "knightSkills")
    @Autowired
    public List<HeroSkill> knightSkills(ConcreteHeroSkillFastAttack a, ConcreteHeroSkillPowerAttack b, ConcreteHeroSkillHealing c) {
        return List.of(a, b, c);
    }

}
