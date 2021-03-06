package com.game.dto.adventure;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdventureResponse {

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;
    private Enemy enemy;
    private HeroSkill heroSkill;
    private EnemySkill enemySkill;
    private String adventureDescription;
    private String heroSkillStatus;
    private String enemySkillStatus;

}
